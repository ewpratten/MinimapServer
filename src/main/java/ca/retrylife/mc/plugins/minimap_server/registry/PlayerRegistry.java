package ca.retrylife.mc.plugins.minimap_server.registry;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import ca.retrylife.mc.plugins.minimap_server.registry.data.PlayerInfo;

/**
 * Registry of all connected players
 */
public class PlayerRegistry {

    // Internal instance reference
    private static PlayerRegistry instance = null;

    /**
     * Get the global instance of PlayerRegistry
     *
     * @return PlayerRegistry instance
     */
    public static PlayerRegistry getInstance() {
        if (instance == null) {
            instance = new PlayerRegistry();
        }
        return instance;
    }

    // List of connected players
    private final List<PlayerInfo> players = new ArrayList<PlayerInfo>();

    // Hidden constructor to force singleton usage
    private PlayerRegistry() {
    }

    public void addPlayer(Player player) {

    }

}