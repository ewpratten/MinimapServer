package ca.retrylife.mc.plugins.minimap_server.api;

import java.util.concurrent.atomic.AtomicInteger;

import org.bukkit.ChatColor;
import org.bukkit.Location;

import lombok.Getter;
import lombok.Setter;

/**
 * Object representation of an in-game waypoint
 */
@Getter
public class Waypoint {

    // Max length of a waypoint's name
    private static final int MAX_NAME_LENGTH = 40;

    // Atomic counter for generating unique waypoint ids
    private static final AtomicInteger COUNTER = new AtomicInteger();

    @Setter
    private Location location;
    private String name;

    // Finals
    private final String identifier;
    private final char symbol;
    private final ChatColor color;
    private final boolean yawTeleportEnabled;
    private final int uid;

    /**
     * Create a new Waypoint
     * 
     * @param loc        In-world location of the waypoint
     * @param identifier Unique case-sensitive name for later retrieval
     * @param name       Actual waypoint name shown to the player
     * @param symbol     Character used for the icon
     * @param color      Icon color
     */
    public Waypoint(Location loc, String identifier, String name, char symbol, ChatColor color) {
        this(loc, identifier, name, symbol, color, false);
    }

    /**
     * Create a new Waypoint
     * 
     * @param loc        In-world location of the waypoint
     * @param identifier Unique case-sensitive name for later retrieval
     * @param name       Actual waypoint name shown to the player
     * @param symbol     Character used for the icon
     * @param color      Icon color
     * @param useYaw     Whether to use yaw value on teleport
     */
    public Waypoint(Location loc, String identifier, String name, char symbol, ChatColor color, boolean useYaw) {

        // Set locals
        this.location = loc;
        this.identifier = identifier;
        this.symbol = symbol;
        this.yawTeleportEnabled = useYaw;

        // Set the UUID
        this.uid = COUNTER.getAndIncrement();

        // Set the name
        this.setName(name);

        // Handle colors
        if (color.ordinal() > 15) {
            this.color = ChatColor.WHITE;
        } else {
            this.color = color;
        }


    }

    @Override
    public String toString() {
        return String.format("Waypoint<\"%s\" at %s>", this.getName(), this.getLocation().toString());
    }

    public void setName(String name) {

        // Handle string limitations on names
        if (name.length() > MAX_NAME_LENGTH) {
            this.name = name.substring(0, MAX_NAME_LENGTH);
        } else {
            this.name = name;
        }

    }
}