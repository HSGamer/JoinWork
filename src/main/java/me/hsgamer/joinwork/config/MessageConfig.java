package me.hsgamer.joinwork.config;

import me.hsgamer.hscore.bukkit.config.PluginConfig;
import me.hsgamer.hscore.config.path.StringConfigPath;
import org.bukkit.plugin.java.JavaPlugin;

public class MessageConfig extends PluginConfig {

    public static final StringConfigPath PREFIX = new StringConfigPath("prefix",
            "&f[&a&lJoinWork&f] ");
    public static final StringConfigPath NO_PERMISSION = new StringConfigPath("no-permission",
            "&cYou don't have permission to do this");
    public static final StringConfigPath PLAYER_ONLY = new StringConfigPath("player-only",
            "&cYou should be a player to do this");
    public static final StringConfigPath SUCCESS = new StringConfigPath("success", "&aSuccess");
    public static final StringConfigPath NO_LOC = new StringConfigPath("no-location-found",
            "&cNo location found");

    public MessageConfig(JavaPlugin plugin) {
        super(plugin, "messages.yml");
        getConfig().options().copyDefaults(true);
        setDefault();
        saveConfig();
    }

    private void setDefault() {
        PREFIX.setConfig(this);
        NO_PERMISSION.setConfig(this);
        PLAYER_ONLY.setConfig(this);
        SUCCESS.setConfig(this);
        NO_LOC.setConfig(this);
    }
}
