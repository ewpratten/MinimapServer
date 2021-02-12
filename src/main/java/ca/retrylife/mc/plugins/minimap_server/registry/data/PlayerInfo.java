package ca.retrylife.mc.plugins.minimap_server.registry.data;

import org.bukkit.World;
import org.bukkit.entity.Player;

import lombok.Data;

/**
 * Metadata wrapper for connected players
 */
@Data
public class PlayerInfo {
    Player player;
    World world;
}