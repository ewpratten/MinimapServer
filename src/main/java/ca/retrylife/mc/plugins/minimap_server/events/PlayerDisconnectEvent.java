package ca.retrylife.mc.plugins.minimap_server.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerDisconnectEvent implements Listener{
    
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        
    }
}