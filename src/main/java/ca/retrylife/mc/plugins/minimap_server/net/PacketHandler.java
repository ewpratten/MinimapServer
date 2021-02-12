package ca.retrylife.mc.plugins.minimap_server.net;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import ca.retrylife.mc.plugins.minimap_server.api.MinimapAPI;
import ca.retrylife.mc.plugins.minimap_server.registry.PlayerRegistry;

public class PacketHandler implements PluginMessageListener {

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {

        // Check if the incoming packet is a "player join" packet
        if (message[2] == MessageTypes.PLAYER_CONNECT.getData()) {

            // Log
            Bukkit.getLogger().info(String.format(
                    "Player %s joined with a modded client. Performing Minimap sync handshake.", player.getName()));

            // Register the player
            PlayerRegistry.getInstance().registerModdedPlayer(player);

            // Send the player their own world update
            try {
                MinimapAPI.getInstance().setPlayerWorld(player.getWorld(), player);
            } catch (IOException e) {
                Bukkit.getLogger()
                        .warning(String.format("Failed to send world update packet to player: %s", player.getName()));
                e.printStackTrace();
            }

        }

    }

}