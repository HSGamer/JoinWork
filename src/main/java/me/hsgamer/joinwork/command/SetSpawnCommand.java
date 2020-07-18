package me.hsgamer.joinwork.command;

import static me.hsgamer.joinwork.JoinWork.getInstance;

import me.hsgamer.hscore.utils.CommonUtils;
import me.hsgamer.joinwork.Permissions;
import me.hsgamer.joinwork.config.MessageConfig;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class SetSpawnCommand extends BukkitCommand {

  public SetSpawnCommand() {
    super("setspawn");
  }

  @Override
  public boolean execute(CommandSender sender, String commandLabel, String[] args) {
    if (!(sender instanceof Player)) {
      CommonUtils.sendMessage(sender, MessageConfig.PLAYER_ONLY.getValue());
      return false;
    }

    if (!sender.hasPermission(Permissions.SET_SPAWN)) {
      CommonUtils.sendMessage(sender, MessageConfig.NO_PERMISSION.getValue());
      return false;
    }

    getInstance().getMainConfig().getConfig()
        .set("spawn-location", ((Player) sender).getLocation());
    getInstance().getMainConfig().saveConfig();
    CommonUtils.sendMessage(sender, MessageConfig.SUCCESS.getValue());

    return true;
  }
}
