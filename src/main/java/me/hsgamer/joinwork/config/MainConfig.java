package me.hsgamer.joinwork.config;

import java.util.HashMap;
import java.util.Map;
import me.hsgamer.hscore.bukkit.config.ConfigPath;
import me.hsgamer.hscore.bukkit.config.PluginConfig;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

public class MainConfig extends PluginConfig {

  public static final ConfigPath<Map<String, Object>> SPAWN_LOCATION_MAP = new ConfigPath<>(
      "spawn-location",
      null, o -> {
    if (o == null) {
      return null;
    }

    Map<String, Object> values = new HashMap<>();
    if (o instanceof ConfigurationSection) {
      values.putAll(((ConfigurationSection) o).getValues(false));
    }
    return values;
  });

  public MainConfig(JavaPlugin plugin) {
    super(plugin, "config.yml");
    getConfig().options().copyDefaults(true);
    setDefault();
    saveConfig();
  }

  private void setDefault() {
    SPAWN_LOCATION_MAP.setConfig(this);
  }
}
