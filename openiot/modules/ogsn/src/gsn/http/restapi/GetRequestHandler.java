package gsn.http.restapi;

import gsn.Main;
import gsn.Mappings;
import gsn.beans.DataField;
import gsn.beans.DataTypes;
import gsn.beans.VSensorConfig;

import java.sql.*;
import java.text.ParseException;
import java.util.*;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import gsn.utils.geo.GridTools;

import org.apache.commons.collections.KeyValue;

public class GetRequestHandler {

    private static transient Logger logger = Logger.getLogger(GetRequestHandler.class);
    private static final String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private static final long DEFAULT_PREVIEW_SIZE = 1000;


    public RestResponse getSensors() {
        RestResponse restResponse = new RestResponse();

        restResponse.setHttpStatus(RestResponse.HTTP_STATUS_OK);
        restResponse.setResponse(getSensorsInfoAsJSON());
        restResponse.setType(RestResponse.JSON_CONTENT_TYPE);

        return restResponse;
    }

    public String getSensorsInfoAsJSON() {

        JSONArray sensorsInfo = new JSONArray();

        Iterator<VSensorConfig> vsIterator = Mappings.getAllVSensorConfigs();

        while (vsIterator.hasNext()) {

            JSONObject aSensor = new JSONObject();

            VSensorConfig sensorConfig = vsIterator.next();

            String vs_name = sensorConfig.getName();

            aSensor.put("name", vs_name);

            JSONArray listOfFields = new JSONArray();

            for (DataField df : sensorConfig.getOutputStructure()) {

                String field_name = df.getName().toLowerCase();
                String field_type = df.getType().toLowerCase();

                if (field_type.indexOf("double") >= 0) {
                    listOfFields.add(field_name);
                }
            }

            aSensor.put("fields", listOfFields);

            Double alt = 0.0;
            Double lat = 0.0;
            Double lon = 0.0;

            for (KeyValue df : sensorConfig.getAddressing()) {

                String adressing_key = df.getKey().toString().toLowerCase().trim();
                String adressing_value = df.getValue().toString().toLowerCase().trim();

                if (adressing_key.indexOf("altitude") >= 0)
                    alt = Double.parseDouble(adressing_value);

                if (adressing_key.indexOf("longitude") >= 0)
                    lon = Double.parseDouble(adressing_value);

                if (adressing_key.indexOf("latitude") >= 0)
                    lat = Double.parseDouble(adressing_value);
            }

            aSensor.put("lat", lat);
            aSensor.put("lon", lon);
            aSensor.put("alt", alt);

            sensorsInfo.add(aSensor);

        }

        return sensorsInfo.toJSONString();
    }


    public RestResponse getGeoDataForSensor() {
        RestResponse restResponse = new RestResponse();

        return restResponse;
    }

    public RestResponse getMeasurementsForSensor() {
        RestResponse restResponse = new RestResponse();

        return restResponse;
    }

    public RestResponse getGridData(String sensor, String date) {
        logger.warn(sensor);
        logger.warn(date);
        RestResponse restResponse = new RestResponse();
        long timestamp = -1;
        try {
            timestamp = new java.text.SimpleDateFormat(ISO_FORMAT).parse(date).getTime();
        } catch (ParseException e) {
            logger.warn("Timestamp is badly formatted: " + date);
        }
        if (timestamp == -1) {
            restResponse = RestResponse.CreateErrorResponse(RestResponse.HTTP_STATUS_BAD_REQUEST, "Malformed date for 'date' field.");
            logger.warn(restResponse.toString());
            return restResponse;
        }

        restResponse.setHttpStatus(RestResponse.HTTP_STATUS_OK);
        restResponse.setType(RestResponse.JSON_CONTENT_TYPE);
        restResponse.setResponse(GridTools.executeQueryForGridAsJSON(sensor, timestamp));

        logger.warn(restResponse.toString());
        return restResponse;
    }


    public RestResponse getPreviewMeasurementsForSensorField(String sensor, String field, String from, String to, String size) {

        RestResponse restResponse = new RestResponse();

        Vector<Double> stream = new Vector<Double>();
        Vector<Long> timestamps = new Vector<Long>();

        boolean errorFlag = false;

        long n = -1;
        long fromAsLong = -1;
        long toAsLong = -1;

        if (size == null)
            n = DEFAULT_PREVIEW_SIZE;
        else
            try {
                n = Long.parseLong(size);
            } catch (NumberFormatException e) {
                logger.error(e.getMessage(), e);
            }

        if (n < 1) n = DEFAULT_PREVIEW_SIZE; // size should be strictly larger than 0

        if (from == null) { // no lower bound provided
            fromAsLong = getMinTimestampForSensorField(sensor, field);
        } else try {
            fromAsLong = new java.text.SimpleDateFormat(ISO_FORMAT).parse(from).getTime();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            errorFlag = true;
        }

        if (to == null) { // no lower bound provided
            toAsLong = getMaxTimestampForSensorField(sensor, field);
        } else try {
            toAsLong = new java.text.SimpleDateFormat(ISO_FORMAT).parse(to).getTime();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            errorFlag = true;
        }

        if (errorFlag) {
            restResponse = RestResponse.CreateErrorResponse(RestResponse.HTTP_STATUS_BAD_REQUEST, "Malformed date for from or to field.");
            return (restResponse);
        }

        errorFlag = !getDataPreview(sensor, field, fromAsLong, toAsLong, stream, timestamps, n);

        if (errorFlag) {
            restResponse = RestResponse.CreateErrorResponse(RestResponse.HTTP_STATUS_BAD_REQUEST, "Error in request.");
            return (restResponse);
        }

        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("sensor", sensor);
        jsonResponse.put("field", field);
        jsonResponse.put("from", from);
        jsonResponse.put("to", to);
        JSONArray streamArray = new JSONArray();
        JSONArray timestampsArray = new JSONArray();
        JSONArray epochsArray = new JSONArray();
        for (int i = 0; i < stream.size(); i++) {
            streamArray.add(stream.get(i));
            timestampsArray.add(new java.text.SimpleDateFormat(ISO_FORMAT).format(new java.util.Date(timestamps.get(i))));
            epochsArray.add(timestamps.get(i));
        }
        jsonResponse.put("timestamps", timestampsArray);
        jsonResponse.put("values", streamArray);
        jsonResponse.put("epochs", epochsArray);
        restResponse.setHttpStatus(RestResponse.HTTP_STATUS_OK);
        restResponse.setType(RestResponse.JSON_CONTENT_TYPE);
        restResponse.setResponse(jsonResponse.toJSONString());

        return restResponse;
    }

    private long getMinTimestampForSensorField(String sensor, String field) {
        return getTimestampBoundForSensorField(sensor, field, "min");
    }

    private long getMaxTimestampForSensorField(String sensor, String field) {
        return getTimestampBoundForSensorField(sensor, field, "max");
    }

    private long getTimestampBoundForSensorField(String sensor, String field, String boundType) {
        Connection conn = null;
        ResultSet resultSet = null;

        boolean result = true;
        long timestamp = -1;

        try {
            conn = Main.getDefaultStorage().getConnection();
            StringBuilder query = new StringBuilder("select ").append(boundType).append("(timed) from ").append(sensor);

            resultSet = Main.getStorage(sensor).executeQueryWithResultSet(query, conn);

            if (resultSet.next()) {

                timestamp = resultSet.getLong(1);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            result = false;
        } finally {
            Main.getStorage(sensor).close(resultSet);
            Main.getStorage(sensor).close(conn);
        }

        return timestamp;
    }

    private long getTableSize(String sensor) {
        Connection conn = null;
        ResultSet resultSet = null;

        boolean result = true;
        long timestamp = -1;

        try {
            conn = Main.getDefaultStorage().getConnection();
            StringBuilder query = new StringBuilder("select count(*) from ").append(sensor);

            resultSet = Main.getStorage(sensor).executeQueryWithResultSet(query, conn);

            if (resultSet.next()) {

                timestamp = resultSet.getLong(1);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            result = false;
        } finally {
            Main.getStorage(sensor).close(resultSet);
            Main.getStorage(sensor).close(conn);
        }

        return timestamp;
    }


    public RestResponse getMeasurementsForSensorField(String sensor, String field, String from, String to) {

        RestResponse restResponse = new RestResponse();

        Vector<Double> stream = new Vector<Double>();
        Vector<Long> timestamps = new Vector<Long>();

        boolean errorFlag = false;

        long fromAsLong = 0;
        long toAsLong = 0;
        try {
            fromAsLong = new java.text.SimpleDateFormat(ISO_FORMAT).parse(from).getTime();
            toAsLong = new java.text.SimpleDateFormat(ISO_FORMAT).parse(to).getTime();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            errorFlag = true;
        }

        if (errorFlag) {
            restResponse = RestResponse.CreateErrorResponse(RestResponse.HTTP_STATUS_BAD_REQUEST, "Malformed date for from or to field.");
            return (restResponse);
        }

        errorFlag = !getData(sensor, field, fromAsLong, toAsLong, stream, timestamps);

        if (errorFlag) {
            restResponse = RestResponse.CreateErrorResponse(RestResponse.HTTP_STATUS_BAD_REQUEST, "Error in request.");
            return (restResponse);
        }

        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("sensor", sensor);
        jsonResponse.put("field", field);
        jsonResponse.put("from", from);
        jsonResponse.put("to", to);
        JSONArray streamArray = new JSONArray();
        JSONArray timestampsArray = new JSONArray();
        JSONArray epochsArray = new JSONArray();
        for (int i = 0; i < stream.size(); i++) {
            streamArray.add(stream.get(i));
            epochsArray.add(timestamps.get(i));
            timestampsArray.add(new java.text.SimpleDateFormat(ISO_FORMAT).format(new java.util.Date(timestamps.get(i))));
        }
        jsonResponse.put("timestamps", timestampsArray);
        jsonResponse.put("epochs", epochsArray);
        jsonResponse.put("values", streamArray);
        restResponse.setHttpStatus(RestResponse.HTTP_STATUS_OK);
        restResponse.setType(RestResponse.JSON_CONTENT_TYPE);
        restResponse.setResponse(jsonResponse.toJSONString());

        return restResponse;
    }

    public boolean getData(String sensor, String field, long from, long to, Vector<Double> stream, Vector<Long> timestamps) {
        Connection conn = null;
        ResultSet resultSet = null;

        boolean result = true;

        try {
            conn = Main.getDefaultStorage().getConnection();
            StringBuilder query = new StringBuilder("select timed, ")
                    .append(field)
                    .append(" from ")
                    .append(sensor)
                    .append(" where timed >= ")
                    .append(from)
                    .append(" and timed<=")
                    .append(to);

            resultSet = Main.getStorage(sensor).executeQueryWithResultSet(query, conn);

            while (resultSet.next()) {
                //int ncols = resultSet.getMetaData().getColumnCount();
                long timestamp = resultSet.getLong(1);
                double value = resultSet.getDouble(2);
                //logger.warn(ncols + " cols, value: " + value + " ts: " + timestamp);
                stream.add(value);
                timestamps.add(timestamp);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            result = false;
        } finally {
            Main.getStorage(sensor).close(resultSet);
            Main.getStorage(sensor).close(conn);
        }

        return result;
    }

    public boolean getDataPreview(String sensor, String field, long from, long to, Vector<Double> stream, Vector<Long> timestamps, long size) {
        Connection conn = null;
        ResultSet resultSet = null;

        boolean result = true;

        long skip = getTableSize(sensor) / size;

        /*
        logger.warn("skip = " + skip);
        logger.warn("size = " + size);
        logger.warn("getTableSize(sensor) = " + getTableSize(sensor));
        */

        try {
            conn = Main.getDefaultStorage().getConnection();
            StringBuilder query = new StringBuilder("select timed, ")
                    .append(field)
                    .append(" from ")
                    .append(sensor);
            if (skip > 1)
                query.append(" where mod(pk,")
                        .append(skip)
                        .append(")=1");

            resultSet = Main.getStorage(sensor).executeQueryWithResultSet(query, conn);

            while (resultSet.next()) {
                //int ncols = resultSet.getMetaData().getColumnCount();
                long timestamp = resultSet.getLong(1);
                double value = resultSet.getDouble(2);
                //logger.warn(ncols + " cols, value: " + value + " ts: " + timestamp);
                stream.add(value);
                timestamps.add(timestamp);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            result = false;
        } finally {
            Main.getStorage(sensor).close(resultSet);
            Main.getStorage(sensor).close(conn);
        }

        return result;
    }
}
