package me.hsgamer.joinwork.config;

import me.hsgamer.hscore.bukkit.config.PluginConfig;
import org.bukkit.plugin.java.JavaPlugin;

public class MainConfig extends PluginConfig {

  public MainConfig(JavaPlugin plugin) {
    super(plugin, "config.yml");
  }
}
