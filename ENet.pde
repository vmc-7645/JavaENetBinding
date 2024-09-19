import enet.*;
import enet.ENetEventType; // Import the ENetEventType class
import enet.ENetPacketFlag;
import enet.ENetPacketHelper;

String serverHost = "127.0.0.1"; // Server's IP address
int serverPort = 35000;          // Server's port number

class ENetClient {
    ENetHost clientHost;
    ENetPeer serverPeer;
    
    ENetClient() {
        init();
    }
    
    void init() {
        // Load the native library (only if not already loaded)
        try {
            System.loadLibrary("enetjni");
        } catch (UnsatisfiedLinkError e) {
            // Library already loaded or couldn't be loaded; handle as needed
        }
        
        // Initialize ENet
        if (enet.enet_initialize() != 0) {
            println("An error occurred while initializing enet.");
            exit();
        } else {
            println("ENet initialized successfully.");
        }
        
        // Create a client host
        clientHost = enet.enet_host_create(null, 1, 2, 0, 0);
        if (clientHost == null) {
            println("An error occurred while trying to create an ENet client host.");
            exit();
        }
    }
    
    void connect(String host, int port) {
        ENetAddress address = new ENetAddress();
        if (enet.enet_address_set_host(address, host) != 0) {
            println("Failed to set host address.");
            exit();
        }
        address.setPort(port);
        
        serverPeer = enet.enet_host_connect(clientHost, address, 2, 0);
        if (serverPeer == null) {
            println("No available peers for initiating an ENet connection.");
            exit();
        }
        
        // Wait up to 5 seconds for the connection attempt to succeed
        ENetEvent event = new ENetEvent();
        int eventStatus = enet.enet_host_service(clientHost, event, 5000);
        if (eventStatus > 0 && event.getType() == ENetEventType.ENET_EVENT_TYPE_CONNECT) {
            println("Connection to " + host + ":" + port + " succeeded.");
        } else {
            println("Connection to " + host + ":" + port + " failed.");
            enet.enet_peer_reset(serverPeer);
            exit();
        }
    }
    
    void service() {
        ENetEvent event = new ENetEvent();
        while (enet.enet_host_service(clientHost, event, 0) > 0) {
            int eventType = (int)event.getType().swigValue();
            if (eventType == ENetEventType.ENET_EVENT_TYPE_RECEIVE.swigValue()) {
                ENetPacket packet = event.getPacket();
                int dataLength = (int) packet.getDataLength();
                byte[] data = ENetPacketHelper.getPacketData(packet, dataLength);
                if (data != null) {
                    String message = new String(data);
                    println("Received message: " + message);
                } else {
                    println("Failed to read packet data.");
                }
                enet.enet_packet_destroy(packet);
            } else if (eventType == ENetEventType.ENET_EVENT_TYPE_DISCONNECT.swigValue()) {
                println("Disconnected from server.");
            }
        }
    }

    
    void sendMessage(String message) {
        byte[] data = message.getBytes();
        int pkFlag = (int)ENetPacketFlag.ENET_PACKET_FLAG_RELIABLE.swigValue();
        ENetPacket packet = enet.enet_packet_create(null, (long)data.length, pkFlag);
        ENetPacketHelper.setPacketData(packet, data, data.length);
        enet.enet_peer_send(serverPeer, 0, packet);
        enet.enet_host_flush(clientHost);
    }
    
    void disconnect() {
        enet.enet_peer_disconnect(serverPeer, 0);
        ENetEvent event = new ENetEvent();
        while (enet.enet_host_service(clientHost, event, 3000) > 0) {
            if (event.getType() == ENetEventType.ENET_EVENT_TYPE_DISCONNECT) {
                println("Disconnection succeeded.");
                return;
            }
        }
        // If we didn't receive a disconnect event, forcefully reset the peer
        enet.enet_peer_reset(serverPeer);
    }
    
    void dispose() {
        enet.enet_host_destroy(clientHost);
        enet.enet_deinitialize();
    }
}