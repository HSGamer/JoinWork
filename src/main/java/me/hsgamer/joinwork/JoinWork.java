package me.hsgamer.joinwork;

import me.hsgamer.hscore.bukkit.baseplugin.BasePlugin;
import me.hsgamer.hscore.bukkit.utils.MessageUtils;
import me.hsgamer.joinwork.command.SetJoinInventoryCommand;
import me.hsgamer.joinwork.command.SetSpawnCommand;
import me.hsgamer.joinwork.config.MainConfig;
import me.hsgamer.joinwork.config.MessageConfig;
import me.hsgamer.joinwork.listener.JoinListener;

public final class JoinWork extends BasePlugin {

    private static JoinWork instance;
    private final MessageConfig messageConfig = new MessageConfig(this);
    private final MainConfig mainConfig = new MainConfig(this);

    public static JoinWork getInstance() {
        return instance;
    }

    @Override
    public void preLoad() {
        instance = this;
    }

    @Override
    public void load() {
        MessageUtils.setPrefix(MessageConfig.PREFIX::getValue);
        mainConfig.setup();
        messageConfig.setup();
    }

    @Override
    public void enable() {
        registerListener(new JoinListener());
        registerCommand(new SetSpawnCommand());
        registerCommand(new SetJoinInventoryCommand());
    }

    public MainConfig getMainConfig() {
        return mainConfig;
    }

    public MessageConfig getMessageConfig() {
        return messageConfig;
    }
}
