package me.hsgamer.joinwork.config;

import me.hsgamer.hscore.config.ConfigPath;
import me.hsgamer.hscore.config.PluginConfig;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class MainConfig extends PluginConfig {

  public static final ConfigPath<Location> SPAWN_LOC = new ConfigPath<>(Location.class,
      "spawn-location", null);

  public MainConfig(JavaPlugin plugin) {
    super(plugin, "config.yml");
    getConfig().options().copyDefaults(true);
    setDefault();
    saveConfig();
  }

  private void setDefault() {
    SPAWN_LOC.setConfig(this);
  }
}
