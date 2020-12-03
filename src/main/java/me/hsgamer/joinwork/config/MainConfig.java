package me.hsgamer.joinwork.config;

import me.hsgamer.hscore.bukkit.config.PluginConfig;
import me.hsgamer.hscore.bukkit.config.path.LocationConfigPath;
import me.hsgamer.hscore.config.AdvancedConfigPath;
import me.hsgamer.hscore.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.simpleyaml.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MainConfig extends PluginConfig {
    public static final LocationConfigPath SPAWN_LOCATION = new LocationConfigPath("spawn-location", new Location(Bukkit.getServer().getWorlds().get(0), 0, 60, 0));
    public static final AdvancedConfigPath<Map<String, Object>, Map<Integer, ItemStack>> JOIN_ITEMS = new AdvancedConfigPath<Map<String, Object>, Map<Integer, ItemStack>>("join-items", new HashMap<>()) {
        @Override
        public Map<String, Object> getFromConfig(Config config) {
            return Optional.ofNullable(config.getConfig().getConfigurationSection(getPath())).map(section -> section.getValues(false)).orElse(null);
        }

        @Override
        public Map<Integer, ItemStack> convert(Map<String, Object> rawValue) {
            Map<Integer, ItemStack> map = new HashMap<>();
            rawValue.forEach((s, o) -> {
                if (o instanceof ConfigurationSection) {
                    map.put(Integer.parseInt(s), ItemStack.deserialize(((ConfigurationSection) o).getValues(false)));
                }
            });
            return map;
        }

        @Override
        public Map<String, Object> convertToRaw(Map<Integer, ItemStack> value) {
            Map<String, Object> map = new HashMap<>();
            value.forEach((integer, itemStack) -> map.put(String.valueOf(integer), itemStack.serialize()));
            return map;
        }
    };

    public MainConfig(JavaPlugin plugin) {
        super(plugin, "config.yml");
        getConfig().options().copyDefaults(true);
    }

    public void setDefault() {
        SPAWN_LOCATION.setConfig(this);
        JOIN_ITEMS.setConfig(this);
    }
}
