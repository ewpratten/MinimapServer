package ca.retrylife.mc.plugins.minimap_server.api;

import java.io.IOException;

import org.bukkit.World;
import org.bukkit.entity.Player;

import ca.retrylife.mc.plugins.minimap_server.net.ClientMessaging;
import ca.retrylife.mc.plugins.minimap_server.registry.PlayerRegistry;

/**
 * Public API for use by other plugins
 */
public class MinimapAPI {

    // Internal instance reference
    private static MinimapAPI instance = null;

    /**
     * Get the global instance of MinimapAPI
     *
     * @return MinimapAPI instance
     */
    public static MinimapAPI getInstance() {
        if (instance == null) {
            instance = new MinimapAPI();
        }
        return instance;
    }

    // Hidden constructor to force singleton usage
    private MinimapAPI() {

    }

    /**
     * Send a waypoint to a player
     * 
     * @param wp     Waypoint
     * @param player Player
     * @throws IOException Thrown if there is a networking error
     */
    public void sendWaypoint(Waypoint wp, Player player) throws IOException {
        if (PlayerRegistry.getInstance().isPlayerModded(player)) {
            ClientMessaging.getInstance().updateWaypointForPlayer(player, wp);
        }
    }

    /**
     * Remove a waypoint from a player
     * 
     * @param wp Waypoint
     * @param player     Player
     * @throws IOException Thrown if there is a networking error
     */
    public void removeWaypoint(Waypoint wp, Player player) throws IOException {
        if (PlayerRegistry.getInstance().isPlayerModded(player)) {
            ClientMessaging.getInstance().deleteWaypointForPlayer(player, wp);
        }
    }

    /**
     * Change the current world for a player
     * 
     * @param world  World
     * @param player Player
     * @throws IOException Thrown if there is a networking error
     */
    public void setPlayerWorld(World world, Player player) throws IOException {
        if (PlayerRegistry.getInstance().isPlayerModded(player)) {
            ClientMessaging.getInstance().updateClientWorld(player, world);
        }
    }

}