package ca.retrylife.mc.plugins.minimap_server;

import kr.entree.spigradle.annotations.PluginMain;

import java.io.File;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import ca.retrylife.mc.plugins.minimap_server.events.PlayerConnectEvent;
import ca.retrylife.mc.plugins.minimap_server.events.PlayerDisconnectEvent;
import ca.retrylife.mc.plugins.minimap_server.events.PlayerWorldChangeEvent;
import ca.retrylife.mc.plugins.minimap_server.net.ClientMessaging;
import ca.retrylife.mc.plugins.minimap_server.net.PacketHandler;

@PluginMain
public class MinimapServerPlugin extends JavaPlugin {

    // Internal instance reference
    private static MinimapServerPlugin instance = null;

    /**
     * Get the global instance of MinimapServerPlugin
     *
     * @return MinimapServerPlugin instance
     */
    public static MinimapServerPlugin getInstance() {
        if (instance == null) {
            instance = new MinimapServerPlugin();
        }
        return instance;
    }

    public MinimapServerPlugin() {
        instance = this;
    }

    public MinimapServerPlugin(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
        instance = this;
    }

    @Override
    public void onEnable() {

        // Set up networking channels
        getServer().getMessenger().registerOutgoingPluginChannel(this, ClientMessaging.NET_CHANNEL_ID);
        getServer().getMessenger().registerIncomingPluginChannel(this, ClientMessaging.NET_CHANNEL_ID,
                new PacketHandler());

        // Set up event handlers
        getServer().getPluginManager().registerEvents(new PlayerConnectEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerDisconnectEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerWorldChangeEvent(), this);

    }

}