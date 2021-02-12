package ca.retrylife.mc.plugins.minimap_server;

import kr.entree.spigradle.annotations.PluginMain;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

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
    }

    public MinimapServerPlugin(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
    }
    
}