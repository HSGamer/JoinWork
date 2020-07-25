package me.hsgamer.joinwork.config;

import me.hsgamer.hscore.bukkit.config.ConfigPath;
import me.hsgamer.hscore.bukkit.config.PluginConfig;
import org.bukkit.plugin.java.JavaPlugin;

public class MessageConfig extends PluginConfig {

  public static final ConfigPath<String> PREFIX = new ConfigPath<>(String.class, "prefix",
      "&f[&a&lJoinWork&f] ");
  public static final ConfigPath<String> NO_PERMISSION = new ConfigPath<>(String.class,
      "no-permission", "&cYou don't have permission to do this");
  public static final ConfigPath<String> PLAYER_ONLY = new ConfigPath<>(String.class, "player-only",
      "&cYou should be a player to do this");
  public static final ConfigPath<String> SUCCESS = new ConfigPath<>(String.class, "success",
      "&aSuccess");
  public static final ConfigPath<String> NO_LOC = new ConfigPath<>(String.class,
      "no-location-found", "&cNo location found");

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
