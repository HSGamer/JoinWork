package me.hsgamer.joinwork.command;

import me.hsgamer.hscore.utils.CommonUtils;
import me.hsgamer.joinwork.JoinWork;
import me.hsgamer.joinwork.Permissions;
import me.hsgamer.joinwork.config.MainConfig;
import me.hsgamer.joinwork.config.MessageConfig;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SetJoinInventoryCommand extends BukkitCommand {

  public SetJoinInventoryCommand() {
    super("setjoininventory");
  }

  @Override
  public boolean execute(CommandSender sender, String commandLabel, String[] args) {
    if (!(sender instanceof Player)) {
      CommonUtils.sendMessage(sender, MessageConfig.PLAYER_ONLY.getValue());
      return false;
    }

    if (!sender.hasPermission(Permissions.SET_INVENTORY)) {
      CommonUtils.sendMessage(sender, MessageConfig.NO_PERMISSION.getValue());
      return false;
    }

    Inventory inventory = ((Player) sender).getInventory();

    MainConfig mainConfig = JoinWork.getInstance().getMainConfig();
    FileConfiguration config = mainConfig.getConfig();

    for (int i = 0; i < inventory.getSize(); i++) {
      ItemStack itemStack = inventory.getItem(i);
      if (itemStack != null) {
        config.set("join-items." + i, itemStack);
      }
    }

    mainConfig.saveConfig();
    CommonUtils.sendMessage(sender, MessageConfig.SUCCESS.getValue());

    return true;
  }
}
