package me.hsgamer.joinwork.config;

import me.hsgamer.hscore.bukkit.config.BukkitConfig;
import me.hsgamer.hscore.config.PathableConfig;
import me.hsgamer.hscore.config.path.StringConfigPath;
import org.bukkit.plugin.Plugin;

public class MessageConfig extends PathableConfig {

    public static final StringConfigPath PREFIX = new StringConfigPath("prefix", "&f[&a&lJoinWork&f] ");
    public static final StringConfigPath NO_PERMISSION = new StringConfigPath("no-permission", "&cYou don't have permission to do this");
    public static final StringConfigPath PLAYER_ONLY = new StringConfigPath("player-only", "&cYou should be a player to do this");
    public static final StringConfigPath SUCCESS = new StringConfigPath("success", "&aSuccess");

    public MessageConfig(Plugin plugin) {
        super(new BukkitConfig(plugin, "messages.yml"));
    }
}
