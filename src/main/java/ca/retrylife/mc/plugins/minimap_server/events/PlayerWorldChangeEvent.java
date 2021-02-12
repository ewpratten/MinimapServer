package ca.retrylife.mc.plugins.minimap_server.events;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import ca.retrylife.mc.plugins.minimap_server.api.MinimapAPI;

public class PlayerWorldChangeEvent implements Listener {

    @EventHandler
    public void onPlayerChangeWorld(PlayerChangedWorldEvent event) {

        // Update the player's world
        try {
            MinimapAPI.getInstance().setPlayerWorld(event.getPlayer().getWorld(), event.getPlayer());
        } catch (IOException e) {
            Bukkit.getLogger().warning(
                    String.format("Failed to send world update packet to player: %s", event.getPlayer().getName()));
            e.printStackTrace();
        }

    }

}