package ca.retrylife.mc.plugins.minimap_server.net;

/**
 * Various packet types
 */
public enum MessageTypes {

    PLAYER_CONNECT((byte) 0x48), WORLD_UPDATE((byte) 0x57), UPDATE_WAYPOINT((byte) 0x41);

    private final byte data;

    private MessageTypes(byte data) {
        this.data = data;
    }

    public byte getData() {
        return data;
    }

}