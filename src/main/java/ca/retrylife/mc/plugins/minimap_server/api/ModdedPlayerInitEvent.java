package ca.retrylife.mc.plugins.minimap_server.api;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * This event is called whenever a client connects to the server, and reports
 * that it is running Xaero's Minimap
 */
public class ModdedPlayerInitEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    // The player
    private final Player player;

    public ModdedPlayerInitEvent(Player player) {
        this.player = player;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    /**
     * Get the player
     * 
     * @return Player
     */
    public Player getPlayer() {
        return player;
    }

}