package ca.retrylife.mc.plugins.minimap_server.api;

import org.bukkit.entity.Player;

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
    
    public void sendWaypoint(Waypoint wp, Player player) {

    }
    
    public void removeWaypoint(Waypoint wp, Player player) {

    }
    
}