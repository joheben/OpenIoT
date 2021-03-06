package gsn.wrappers.tinyos;

/**
 * This class is automatically generated by mig. DO NOT EDIT THIS FILE.
 * This class implements a Java interface to the 'ThurBoard1Data'
 * message type.
 */

public class ThurBoard1Data extends net.tinyos.message.Message {

    /** The default size of this message type in bytes. */
    public static final int DEFAULT_MESSAGE_SIZE = 26;

    /** The Active Message type associated with this message. */
    public static final int AM_TYPE = 128;

    /** Create a new ThurBoard1Data of size 26. */
    public ThurBoard1Data() {
        super(DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /** Create a new ThurBoard1Data of the given data_length. */
    public ThurBoard1Data(int data_length) {
        super(data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new ThurBoard1Data with the given data_length
     * and base offset.
     */
    public ThurBoard1Data(int data_length, int base_offset) {
        super(data_length, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new ThurBoard1Data using the given byte array
     * as backing store.
     */
    public ThurBoard1Data(byte[] data) {
        super(data);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new ThurBoard1Data using the given byte array
     * as backing store, with the given base offset.
     */
    public ThurBoard1Data(byte[] data, int base_offset) {
        super(data, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new ThurBoard1Data using the given byte array
     * as backing store, with the given base offset and data length.
     */
    public ThurBoard1Data(byte[] data, int base_offset, int data_length) {
        super(data, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new ThurBoard1Data embedded in the given message
     * at the given base offset.
     */
    public ThurBoard1Data(net.tinyos.message.Message msg, int base_offset) {
        super(msg, base_offset, DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new ThurBoard1Data embedded in the given message
     * at the given base offset and length.
     */
    public ThurBoard1Data(net.tinyos.message.Message msg, int base_offset, int data_length) {
        super(msg, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
    /* Return a String representation of this message. Includes the
     * message type name and the non-indexed field values.
     */
    public String toString() {
      String s = "Message <ThurBoard1Data> \n";
      try {
        s += "  [ntw_sender_id=0x"+Long.toHexString(get_ntw_sender_id())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [ntw_cost_to_bs=0x"+Long.toHexString(get_ntw_cost_to_bs())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [tsp_hop_count=0x"+Long.toHexString(get_tsp_hop_count())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [tsp_packet_sn=0x"+Long.toHexString(get_tsp_packet_sn())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [reporter_id=0x"+Long.toHexString(get_reporter_id())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [timestamp=0x"+Long.toHexString(get_timestamp())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [wind_direction=0x"+Long.toHexString(get_wind_direction())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [solar_radiation=0x"+Long.toHexString(get_solar_radiation())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [soil_moisture_1=0x"+Long.toHexString(get_soil_moisture_1())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [soil_temperature_1=0x"+Long.toHexString(get_soil_temperature_1())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [soil_conductivity_1=0x"+Long.toHexString(get_soil_conductivity_1())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [soil_moisture_2=0x"+Long.toHexString(get_soil_moisture_2())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [soil_temperature_2=0x"+Long.toHexString(get_soil_temperature_2())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [soil_conductivity_2=0x"+Long.toHexString(get_soil_conductivity_2())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [soil_moisture_3=0x"+Long.toHexString(get_soil_moisture_3())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [soil_temperature_3=0x"+Long.toHexString(get_soil_temperature_3())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [soil_conductivity_3=0x"+Long.toHexString(get_soil_conductivity_3())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      return s;
    }

    // Message-type-specific access methods appear below.

    /////////////////////////////////////////////////////////
    // Accessor methods for field: ntw_sender_id
    //   Field type: short, unsigned
    //   Offset (bits): 0
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'ntw_sender_id' is signed (false).
     */
    public static boolean isSigned_ntw_sender_id() {
        return false;
    }

    /**
     * Return whether the field 'ntw_sender_id' is an array (false).
     */
    public static boolean isArray_ntw_sender_id() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'ntw_sender_id'
     */
    public static int offset_ntw_sender_id() {
        return (0 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'ntw_sender_id'
     */
    public static int offsetBits_ntw_sender_id() {
        return 0;
    }

    /**
     * Return the value (as a short) of the field 'ntw_sender_id'
     */
    public short get_ntw_sender_id() {
        return (short)getUIntBEElement(offsetBits_ntw_sender_id(), 8);
    }

    /**
     * Set the value of the field 'ntw_sender_id'
     */
    public void set_ntw_sender_id(short value) {
        setUIntBEElement(offsetBits_ntw_sender_id(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'ntw_sender_id'
     */
    public static int size_ntw_sender_id() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'ntw_sender_id'
     */
    public static int sizeBits_ntw_sender_id() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: ntw_cost_to_bs
    //   Field type: short, unsigned
    //   Offset (bits): 8
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'ntw_cost_to_bs' is signed (false).
     */
    public static boolean isSigned_ntw_cost_to_bs() {
        return false;
    }

    /**
     * Return whether the field 'ntw_cost_to_bs' is an array (false).
     */
    public static boolean isArray_ntw_cost_to_bs() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'ntw_cost_to_bs'
     */
    public static int offset_ntw_cost_to_bs() {
        return (8 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'ntw_cost_to_bs'
     */
    public static int offsetBits_ntw_cost_to_bs() {
        return 8;
    }

    /**
     * Return the value (as a short) of the field 'ntw_cost_to_bs'
     */
    public short get_ntw_cost_to_bs() {
        return (short)getUIntBEElement(offsetBits_ntw_cost_to_bs(), 8);
    }

    /**
     * Set the value of the field 'ntw_cost_to_bs'
     */
    public void set_ntw_cost_to_bs(short value) {
        setUIntBEElement(offsetBits_ntw_cost_to_bs(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'ntw_cost_to_bs'
     */
    public static int size_ntw_cost_to_bs() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'ntw_cost_to_bs'
     */
    public static int sizeBits_ntw_cost_to_bs() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: tsp_hop_count
    //   Field type: short, unsigned
    //   Offset (bits): 16
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'tsp_hop_count' is signed (false).
     */
    public static boolean isSigned_tsp_hop_count() {
        return false;
    }

    /**
     * Return whether the field 'tsp_hop_count' is an array (false).
     */
    public static boolean isArray_tsp_hop_count() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'tsp_hop_count'
     */
    public static int offset_tsp_hop_count() {
        return (16 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'tsp_hop_count'
     */
    public static int offsetBits_tsp_hop_count() {
        return 16;
    }

    /**
     * Return the value (as a short) of the field 'tsp_hop_count'
     */
    public short get_tsp_hop_count() {
        return (short)getUIntBEElement(offsetBits_tsp_hop_count(), 8);
    }

    /**
     * Set the value of the field 'tsp_hop_count'
     */
    public void set_tsp_hop_count(short value) {
        setUIntBEElement(offsetBits_tsp_hop_count(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'tsp_hop_count'
     */
    public static int size_tsp_hop_count() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'tsp_hop_count'
     */
    public static int sizeBits_tsp_hop_count() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: tsp_packet_sn
    //   Field type: short, unsigned
    //   Offset (bits): 24
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'tsp_packet_sn' is signed (false).
     */
    public static boolean isSigned_tsp_packet_sn() {
        return false;
    }

    /**
     * Return whether the field 'tsp_packet_sn' is an array (false).
     */
    public static boolean isArray_tsp_packet_sn() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'tsp_packet_sn'
     */
    public static int offset_tsp_packet_sn() {
        return (24 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'tsp_packet_sn'
     */
    public static int offsetBits_tsp_packet_sn() {
        return 24;
    }

    /**
     * Return the value (as a short) of the field 'tsp_packet_sn'
     */
    public short get_tsp_packet_sn() {
        return (short)getUIntBEElement(offsetBits_tsp_packet_sn(), 8);
    }

    /**
     * Set the value of the field 'tsp_packet_sn'
     */
    public void set_tsp_packet_sn(short value) {
        setUIntBEElement(offsetBits_tsp_packet_sn(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'tsp_packet_sn'
     */
    public static int size_tsp_packet_sn() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'tsp_packet_sn'
     */
    public static int sizeBits_tsp_packet_sn() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: reporter_id
    //   Field type: short, unsigned
    //   Offset (bits): 32
    //   Size (bits): 8
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'reporter_id' is signed (false).
     */
    public static boolean isSigned_reporter_id() {
        return false;
    }

    /**
     * Return whether the field 'reporter_id' is an array (false).
     */
    public static boolean isArray_reporter_id() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'reporter_id'
     */
    public static int offset_reporter_id() {
        return (32 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'reporter_id'
     */
    public static int offsetBits_reporter_id() {
        return 32;
    }

    /**
     * Return the value (as a short) of the field 'reporter_id'
     */
    public short get_reporter_id() {
        return (short)getUIntBEElement(offsetBits_reporter_id(), 8);
    }

    /**
     * Set the value of the field 'reporter_id'
     */
    public void set_reporter_id(short value) {
        setUIntBEElement(offsetBits_reporter_id(), 8, value);
    }

    /**
     * Return the size, in bytes, of the field 'reporter_id'
     */
    public static int size_reporter_id() {
        return (8 / 8);
    }

    /**
     * Return the size, in bits, of the field 'reporter_id'
     */
    public static int sizeBits_reporter_id() {
        return 8;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: timestamp
    //   Field type: long, unsigned
    //   Offset (bits): 40
    //   Size (bits): 32
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'timestamp' is signed (false).
     */
    public static boolean isSigned_timestamp() {
        return false;
    }

    /**
     * Return whether the field 'timestamp' is an array (false).
     */
    public static boolean isArray_timestamp() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'timestamp'
     */
    public static int offset_timestamp() {
        return (40 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'timestamp'
     */
    public static int offsetBits_timestamp() {
        return 40;
    }

    /**
     * Return the value (as a long) of the field 'timestamp'
     */
    public long get_timestamp() {
        return (long)getUIntBEElement(offsetBits_timestamp(), 32);
    }

    /**
     * Set the value of the field 'timestamp'
     */
    public void set_timestamp(long value) {
        setUIntBEElement(offsetBits_timestamp(), 32, value);
    }

    /**
     * Return the size, in bytes, of the field 'timestamp'
     */
    public static int size_timestamp() {
        return (32 / 8);
    }

    /**
     * Return the size, in bits, of the field 'timestamp'
     */
    public static int sizeBits_timestamp() {
        return 32;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: wind_direction
    //   Field type: short, unsigned
    //   Offset (bits): 72
    //   Size (bits): 12
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'wind_direction' is signed (false).
     */
    public static boolean isSigned_wind_direction() {
        return false;
    }

    /**
     * Return whether the field 'wind_direction' is an array (false).
     */
    public static boolean isArray_wind_direction() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'wind_direction'
     */
    public static int offset_wind_direction() {
        return (72 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'wind_direction'
     */
    public static int offsetBits_wind_direction() {
        return 72;
    }

    /**
     * Return the value (as a short) of the field 'wind_direction'
     */
    public short get_wind_direction() {
        return (short)getUIntBEElement(offsetBits_wind_direction(), 12);
    }

    /**
     * Set the value of the field 'wind_direction'
     */
    public void set_wind_direction(short value) {
        setUIntBEElement(offsetBits_wind_direction(), 12, value);
    }

    /**
     * Return the size, in bytes, of the field 'wind_direction'
     * WARNING: This field is not an even-sized number of bytes (12 bits).
     */
    public static int size_wind_direction() {
        return (12 / 8) + 1;
    }

    /**
     * Return the size, in bits, of the field 'wind_direction'
     */
    public static int sizeBits_wind_direction() {
        return 12;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: solar_radiation
    //   Field type: short, unsigned
    //   Offset (bits): 84
    //   Size (bits): 12
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'solar_radiation' is signed (false).
     */
    public static boolean isSigned_solar_radiation() {
        return false;
    }

    /**
     * Return whether the field 'solar_radiation' is an array (false).
     */
    public static boolean isArray_solar_radiation() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'solar_radiation'
     * WARNING: This field is not byte-aligned (bit offset 84).
     */
    public static int offset_solar_radiation() {
        return (84 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'solar_radiation'
     */
    public static int offsetBits_solar_radiation() {
        return 84;
    }

    /**
     * Return the value (as a short) of the field 'solar_radiation'
     */
    public short get_solar_radiation() {
        return (short)getUIntBEElement(offsetBits_solar_radiation(), 12);
    }

    /**
     * Set the value of the field 'solar_radiation'
     */
    public void set_solar_radiation(short value) {
        setUIntBEElement(offsetBits_solar_radiation(), 12, value);
    }

    /**
     * Return the size, in bytes, of the field 'solar_radiation'
     * WARNING: This field is not an even-sized number of bytes (12 bits).
     */
    public static int size_solar_radiation() {
        return (12 / 8) + 1;
    }

    /**
     * Return the size, in bits, of the field 'solar_radiation'
     */
    public static int sizeBits_solar_radiation() {
        return 12;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: soil_moisture_1
    //   Field type: short, unsigned
    //   Offset (bits): 96
    //   Size (bits): 12
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'soil_moisture_1' is signed (false).
     */
    public static boolean isSigned_soil_moisture_1() {
        return false;
    }

    /**
     * Return whether the field 'soil_moisture_1' is an array (false).
     */
    public static boolean isArray_soil_moisture_1() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'soil_moisture_1'
     */
    public static int offset_soil_moisture_1() {
        return (96 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'soil_moisture_1'
     */
    public static int offsetBits_soil_moisture_1() {
        return 96;
    }

    /**
     * Return the value (as a short) of the field 'soil_moisture_1'
     */
    public short get_soil_moisture_1() {
        return (short)getUIntBEElement(offsetBits_soil_moisture_1(), 12);
    }

    /**
     * Set the value of the field 'soil_moisture_1'
     */
    public void set_soil_moisture_1(short value) {
        setUIntBEElement(offsetBits_soil_moisture_1(), 12, value);
    }

    /**
     * Return the size, in bytes, of the field 'soil_moisture_1'
     * WARNING: This field is not an even-sized number of bytes (12 bits).
     */
    public static int size_soil_moisture_1() {
        return (12 / 8) + 1;
    }

    /**
     * Return the size, in bits, of the field 'soil_moisture_1'
     */
    public static int sizeBits_soil_moisture_1() {
        return 12;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: soil_temperature_1
    //   Field type: short, unsigned
    //   Offset (bits): 108
    //   Size (bits): 12
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'soil_temperature_1' is signed (false).
     */
    public static boolean isSigned_soil_temperature_1() {
        return false;
    }

    /**
     * Return whether the field 'soil_temperature_1' is an array (false).
     */
    public static boolean isArray_soil_temperature_1() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'soil_temperature_1'
     * WARNING: This field is not byte-aligned (bit offset 108).
     */
    public static int offset_soil_temperature_1() {
        return (108 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'soil_temperature_1'
     */
    public static int offsetBits_soil_temperature_1() {
        return 108;
    }

    /**
     * Return the value (as a short) of the field 'soil_temperature_1'
     */
    public short get_soil_temperature_1() {
        return (short)getUIntBEElement(offsetBits_soil_temperature_1(), 12);
    }

    /**
     * Set the value of the field 'soil_temperature_1'
     */
    public void set_soil_temperature_1(short value) {
        setUIntBEElement(offsetBits_soil_temperature_1(), 12, value);
    }

    /**
     * Return the size, in bytes, of the field 'soil_temperature_1'
     * WARNING: This field is not an even-sized number of bytes (12 bits).
     */
    public static int size_soil_temperature_1() {
        return (12 / 8) + 1;
    }

    /**
     * Return the size, in bits, of the field 'soil_temperature_1'
     */
    public static int sizeBits_soil_temperature_1() {
        return 12;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: soil_conductivity_1
    //   Field type: short, unsigned
    //   Offset (bits): 120
    //   Size (bits): 12
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'soil_conductivity_1' is signed (false).
     */
    public static boolean isSigned_soil_conductivity_1() {
        return false;
    }

    /**
     * Return whether the field 'soil_conductivity_1' is an array (false).
     */
    public static boolean isArray_soil_conductivity_1() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'soil_conductivity_1'
     */
    public static int offset_soil_conductivity_1() {
        return (120 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'soil_conductivity_1'
     */
    public static int offsetBits_soil_conductivity_1() {
        return 120;
    }

    /**
     * Return the value (as a short) of the field 'soil_conductivity_1'
     */
    public short get_soil_conductivity_1() {
        return (short)getUIntBEElement(offsetBits_soil_conductivity_1(), 12);
    }

    /**
     * Set the value of the field 'soil_conductivity_1'
     */
    public void set_soil_conductivity_1(short value) {
        setUIntBEElement(offsetBits_soil_conductivity_1(), 12, value);
    }

    /**
     * Return the size, in bytes, of the field 'soil_conductivity_1'
     * WARNING: This field is not an even-sized number of bytes (12 bits).
     */
    public static int size_soil_conductivity_1() {
        return (12 / 8) + 1;
    }

    /**
     * Return the size, in bits, of the field 'soil_conductivity_1'
     */
    public static int sizeBits_soil_conductivity_1() {
        return 12;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: soil_moisture_2
    //   Field type: short, unsigned
    //   Offset (bits): 132
    //   Size (bits): 12
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'soil_moisture_2' is signed (false).
     */
    public static boolean isSigned_soil_moisture_2() {
        return false;
    }

    /**
     * Return whether the field 'soil_moisture_2' is an array (false).
     */
    public static boolean isArray_soil_moisture_2() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'soil_moisture_2'
     * WARNING: This field is not byte-aligned (bit offset 132).
     */
    public static int offset_soil_moisture_2() {
        return (132 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'soil_moisture_2'
     */
    public static int offsetBits_soil_moisture_2() {
        return 132;
    }

    /**
     * Return the value (as a short) of the field 'soil_moisture_2'
     */
    public short get_soil_moisture_2() {
        return (short)getUIntBEElement(offsetBits_soil_moisture_2(), 12);
    }

    /**
     * Set the value of the field 'soil_moisture_2'
     */
    public void set_soil_moisture_2(short value) {
        setUIntBEElement(offsetBits_soil_moisture_2(), 12, value);
    }

    /**
     * Return the size, in bytes, of the field 'soil_moisture_2'
     * WARNING: This field is not an even-sized number of bytes (12 bits).
     */
    public static int size_soil_moisture_2() {
        return (12 / 8) + 1;
    }

    /**
     * Return the size, in bits, of the field 'soil_moisture_2'
     */
    public static int sizeBits_soil_moisture_2() {
        return 12;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: soil_temperature_2
    //   Field type: short, unsigned
    //   Offset (bits): 144
    //   Size (bits): 12
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'soil_temperature_2' is signed (false).
     */
    public static boolean isSigned_soil_temperature_2() {
        return false;
    }

    /**
     * Return whether the field 'soil_temperature_2' is an array (false).
     */
    public static boolean isArray_soil_temperature_2() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'soil_temperature_2'
     */
    public static int offset_soil_temperature_2() {
        return (144 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'soil_temperature_2'
     */
    public static int offsetBits_soil_temperature_2() {
        return 144;
    }

    /**
     * Return the value (as a short) of the field 'soil_temperature_2'
     */
    public short get_soil_temperature_2() {
        return (short)getUIntBEElement(offsetBits_soil_temperature_2(), 12);
    }

    /**
     * Set the value of the field 'soil_temperature_2'
     */
    public void set_soil_temperature_2(short value) {
        setUIntBEElement(offsetBits_soil_temperature_2(), 12, value);
    }

    /**
     * Return the size, in bytes, of the field 'soil_temperature_2'
     * WARNING: This field is not an even-sized number of bytes (12 bits).
     */
    public static int size_soil_temperature_2() {
        return (12 / 8) + 1;
    }

    /**
     * Return the size, in bits, of the field 'soil_temperature_2'
     */
    public static int sizeBits_soil_temperature_2() {
        return 12;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: soil_conductivity_2
    //   Field type: short, unsigned
    //   Offset (bits): 156
    //   Size (bits): 12
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'soil_conductivity_2' is signed (false).
     */
    public static boolean isSigned_soil_conductivity_2() {
        return false;
    }

    /**
     * Return whether the field 'soil_conductivity_2' is an array (false).
     */
    public static boolean isArray_soil_conductivity_2() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'soil_conductivity_2'
     * WARNING: This field is not byte-aligned (bit offset 156).
     */
    public static int offset_soil_conductivity_2() {
        return (156 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'soil_conductivity_2'
     */
    public static int offsetBits_soil_conductivity_2() {
        return 156;
    }

    /**
     * Return the value (as a short) of the field 'soil_conductivity_2'
     */
    public short get_soil_conductivity_2() {
        return (short)getUIntBEElement(offsetBits_soil_conductivity_2(), 12);
    }

    /**
     * Set the value of the field 'soil_conductivity_2'
     */
    public void set_soil_conductivity_2(short value) {
        setUIntBEElement(offsetBits_soil_conductivity_2(), 12, value);
    }

    /**
     * Return the size, in bytes, of the field 'soil_conductivity_2'
     * WARNING: This field is not an even-sized number of bytes (12 bits).
     */
    public static int size_soil_conductivity_2() {
        return (12 / 8) + 1;
    }

    /**
     * Return the size, in bits, of the field 'soil_conductivity_2'
     */
    public static int sizeBits_soil_conductivity_2() {
        return 12;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: soil_moisture_3
    //   Field type: short, unsigned
    //   Offset (bits): 168
    //   Size (bits): 12
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'soil_moisture_3' is signed (false).
     */
    public static boolean isSigned_soil_moisture_3() {
        return false;
    }

    /**
     * Return whether the field 'soil_moisture_3' is an array (false).
     */
    public static boolean isArray_soil_moisture_3() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'soil_moisture_3'
     */
    public static int offset_soil_moisture_3() {
        return (168 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'soil_moisture_3'
     */
    public static int offsetBits_soil_moisture_3() {
        return 168;
    }

    /**
     * Return the value (as a short) of the field 'soil_moisture_3'
     */
    public short get_soil_moisture_3() {
        return (short)getUIntBEElement(offsetBits_soil_moisture_3(), 12);
    }

    /**
     * Set the value of the field 'soil_moisture_3'
     */
    public void set_soil_moisture_3(short value) {
        setUIntBEElement(offsetBits_soil_moisture_3(), 12, value);
    }

    /**
     * Return the size, in bytes, of the field 'soil_moisture_3'
     * WARNING: This field is not an even-sized number of bytes (12 bits).
     */
    public static int size_soil_moisture_3() {
        return (12 / 8) + 1;
    }

    /**
     * Return the size, in bits, of the field 'soil_moisture_3'
     */
    public static int sizeBits_soil_moisture_3() {
        return 12;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: soil_temperature_3
    //   Field type: short, unsigned
    //   Offset (bits): 180
    //   Size (bits): 12
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'soil_temperature_3' is signed (false).
     */
    public static boolean isSigned_soil_temperature_3() {
        return false;
    }

    /**
     * Return whether the field 'soil_temperature_3' is an array (false).
     */
    public static boolean isArray_soil_temperature_3() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'soil_temperature_3'
     * WARNING: This field is not byte-aligned (bit offset 180).
     */
    public static int offset_soil_temperature_3() {
        return (180 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'soil_temperature_3'
     */
    public static int offsetBits_soil_temperature_3() {
        return 180;
    }

    /**
     * Return the value (as a short) of the field 'soil_temperature_3'
     */
    public short get_soil_temperature_3() {
        return (short)getUIntBEElement(offsetBits_soil_temperature_3(), 12);
    }

    /**
     * Set the value of the field 'soil_temperature_3'
     */
    public void set_soil_temperature_3(short value) {
        setUIntBEElement(offsetBits_soil_temperature_3(), 12, value);
    }

    /**
     * Return the size, in bytes, of the field 'soil_temperature_3'
     * WARNING: This field is not an even-sized number of bytes (12 bits).
     */
    public static int size_soil_temperature_3() {
        return (12 / 8) + 1;
    }

    /**
     * Return the size, in bits, of the field 'soil_temperature_3'
     */
    public static int sizeBits_soil_temperature_3() {
        return 12;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: soil_conductivity_3
    //   Field type: short, unsigned
    //   Offset (bits): 192
    //   Size (bits): 12
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'soil_conductivity_3' is signed (false).
     */
    public static boolean isSigned_soil_conductivity_3() {
        return false;
    }

    /**
     * Return whether the field 'soil_conductivity_3' is an array (false).
     */
    public static boolean isArray_soil_conductivity_3() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'soil_conductivity_3'
     */
    public static int offset_soil_conductivity_3() {
        return (192 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'soil_conductivity_3'
     */
    public static int offsetBits_soil_conductivity_3() {
        return 192;
    }

    /**
     * Return the value (as a short) of the field 'soil_conductivity_3'
     */
    public short get_soil_conductivity_3() {
        return (short)getUIntBEElement(offsetBits_soil_conductivity_3(), 12);
    }

    /**
     * Set the value of the field 'soil_conductivity_3'
     */
    public void set_soil_conductivity_3(short value) {
        setUIntBEElement(offsetBits_soil_conductivity_3(), 12, value);
    }

    /**
     * Return the size, in bytes, of the field 'soil_conductivity_3'
     * WARNING: This field is not an even-sized number of bytes (12 bits).
     */
    public static int size_soil_conductivity_3() {
        return (12 / 8) + 1;
    }

    /**
     * Return the size, in bits, of the field 'soil_conductivity_3'
     */
    public static int sizeBits_soil_conductivity_3() {
        return 12;
    }

}
