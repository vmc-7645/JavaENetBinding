package enet;

public class ENetPacketHelper {
    static {
        System.loadLibrary("enetjni"); // Ensure the native library is loaded
    }

    // Native method to get packet data
    public static native byte[] getPacketData(ENetPacket packet, int length);

    // Native method to set packet data
    public static native void setPacketData(ENetPacket packet, byte[] data, int length);
}
