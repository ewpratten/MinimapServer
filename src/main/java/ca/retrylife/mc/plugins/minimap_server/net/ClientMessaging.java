package ca.retrylife.mc.plugins.minimap_server.net;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.World;
import org.bukkit.entity.Player;

import ca.retrylife.mc.plugins.minimap_server.MinimapServerPlugin;
import ca.retrylife.mc.plugins.minimap_server.api.Waypoint;

public class ClientMessaging {

    // Internal instance reference
    private static ClientMessaging instance = null;

    /**
     * Get the global instance of ClientMessaging
     *
     * @return ClientMessaging instance
     */
    public static ClientMessaging getInstance() {
        if (instance == null) {
            instance = new ClientMessaging();
        }
        return instance;
    }

    // Hidden constructor to force singleton usage
    private ClientMessaging() {
    }

    /**
     * Send a raw packet to a player
     * 
     * @param player Target player
     * @param packet Packet
     */
    private void writePacketToPlayer(Player player, byte[] packet) {
        player.sendPluginMessage(MinimapServerPlugin.getInstance(), "XaeroMinimap", packet);
    }

    /**
     * Tell a player what world they are in
     * 
     * @param player Player
     * @param world  World
     * @throws IOException
     */
    public void updateClientWorld(Player player, World world) throws IOException {

        // Create output buffers
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        DataOutputStream dataBuffer = new DataOutputStream(byteBuffer);

        // Construct packet
        dataBuffer.write(new byte[] { 0 });
        dataBuffer.writeChar(MessageTypes.WORLD_UPDATE.getData());
        dataBuffer.writeUTF(world.getUID().toString());
        dataBuffer.writeUTF(world.getName());

        // Send to player
        writePacketToPlayer(player, byteBuffer.toByteArray());

    }

    public void updateWaypointForPlayer(Player player, Waypoint wp) throws IOException {

        // Create output buffers
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        DataOutputStream dataBuffer = new DataOutputStream(byteBuffer);

        // Construct packet
        dataBuffer.write(new byte[] { 0 });
        dataBuffer.writeChar(MessageTypes.UPDATE_WAYPOINT.getData());
        dataBuffer.writeUTF(wp.getLocation().getWorld().getUID().toString());
        dataBuffer.writeInt((int) wp.getLocation().getX());
        dataBuffer.writeInt((int) wp.getLocation().getY());
        dataBuffer.writeInt((int) wp.getLocation().getZ());
        dataBuffer.writeUTF(wp.getName());
        dataBuffer.writeChar(wp.getSymbol());
        dataBuffer.write(wp.getColor().ordinal());
        dataBuffer.writeInt(wp.getUid());
        dataBuffer.writeBoolean(wp.isYawTeleportEnabled());
        if (wp.isYawTeleportEnabled()) {
            dataBuffer.writeShort((short) ((int) wp.getLocation().getYaw()));
        }

    }

}