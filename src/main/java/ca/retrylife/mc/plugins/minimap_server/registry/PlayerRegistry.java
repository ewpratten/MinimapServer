package ca.retrylife.mc.plugins.minimap_server.registry;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

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

    // List of modded players
    private final List<Player> moddedPlayers = new ArrayList<Player>();

    // Hidden constructor to force singleton usage
    private PlayerRegistry() {
    }

    /**
     * Tracks a player as having Xaero's Minimap installed and running
     * 
     * @param player Player
     */
    public void registerModdedPlayer(Player player) {
        moddedPlayers.add(player);
        Bukkit.getLogger().info(String.format("Player %s added to modded client registry", player.getName()));
    }

    /**
     * Remove a player from the modded players list (call on logout)
     * 
     * @param player Player
     */
    public void unregisterPlayer(Player player) {
        moddedPlayers.remove(player);
        Bukkit.getLogger().info(String.format("Player %s removed from modded client registry", player.getName()));
    }

    /**
     * Check if a player has Xaero's Minimap installed and running
     * 
     * @param player Player
     * @return Has Minimap?
     */
    public boolean isPlayerModded(Player player) {
        return moddedPlayers.contains(player);
    }

    /**
     * Get a list of all modded players online right now
     * 
     * @return Modded players (reference to internal list)
     */
    public List<Player> getAllModdedPlayersOnline() {
        return this.moddedPlayers;
    }

}