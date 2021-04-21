package me.hsgamer.joinwork.config;

import me.hsgamer.hscore.bukkit.config.BukkitConfig;
import me.hsgamer.hscore.bukkit.config.object.Position;
import me.hsgamer.hscore.bukkit.config.path.PositionConfigPath;
import me.hsgamer.hscore.config.AdvancedConfigPath;
import me.hsgamer.hscore.config.Config;
import me.hsgamer.hscore.config.PathableConfig;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class MainConfig extends PathableConfig {
    public static final PositionConfigPath SPAWN_LOCATION = new PositionConfigPath("spawn-location", new Position("world", 0, 60, 0, 0, 0));
    public static final AdvancedConfigPath<Map<String, Object>, Map<Integer, ItemStack>> JOIN_ITEMS = new AdvancedConfigPath<Map<String, Object>, Map<Integer, ItemStack>>("join-items", new HashMap<>()) {
        @Override
        public Map<String, Object> getFromConfig(Config config) {
            return config.getValues(getPath(), false);
        }

        @Override
        public Map<Integer, ItemStack> convert(Map<String, Object> rawValue) {
            Map<Integer, ItemStack> map = new HashMap<>();
            rawValue.forEach((s, o) -> {
                if (o instanceof Map) {
                    // noinspection unchecked
                    map.put(Integer.parseInt(s), ItemStack.deserialize((Map<String, Object>) o));
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

    public MainConfig(Plugin plugin) {
        super(new BukkitConfig(plugin, "config.yml"));
    }
}
