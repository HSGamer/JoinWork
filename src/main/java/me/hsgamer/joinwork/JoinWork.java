package me.hsgamer.joinwork;

import me.hsgamer.hscore.bukkit.command.CommandManager;
import me.hsgamer.hscore.bukkit.utils.MessageUtils;
import me.hsgamer.joinwork.command.SetJoinInventoryCommand;
import me.hsgamer.joinwork.command.SetSpawnCommand;
import me.hsgamer.joinwork.config.MainConfig;
import me.hsgamer.joinwork.config.MessageConfig;
import me.hsgamer.joinwork.listener.JoinListener;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinWork extends JavaPlugin {

  private static JoinWork instance;
  private final CommandManager commandManager = new CommandManager(this);
  private final MessageConfig messageConfig = new MessageConfig(this);
  private MainConfig mainConfig;

  public static JoinWork getInstance() {
    return instance;
  }

  @Override
  public void onLoad() {
    instance = this;
  }

  @Override
  public void onEnable() {
    mainConfig = new MainConfig(this);

    MessageUtils.setPrefix(MessageConfig.PREFIX::getValue);
    getServer().getPluginManager().registerEvents(new JoinListener(), this);

    commandManager.register(new SetSpawnCommand());
    commandManager.register(new SetJoinInventoryCommand());
    commandManager.syncCommand();
  }

  @Override
  public void onDisable() {
    HandlerList.unregisterAll(this);
  }

  public CommandManager getCommandManager() {
    return commandManager;
  }

  public MainConfig getMainConfig() {
    return mainConfig;
  }

  public MessageConfig getMessageConfig() {
    return messageConfig;
  }
}
