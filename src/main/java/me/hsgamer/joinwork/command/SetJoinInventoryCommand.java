package me.hsgamer.joinwork.command;

import me.hsgamer.hscore.bukkitutils.MessageUtils;
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
      MessageUtils.sendMessage(sender, MessageConfig.PLAYER_ONLY.getValue());
      return false;
    }

    if (!sender.hasPermission(Permissions.SET_INVENTORY)) {
      MessageUtils.sendMessage(sender, MessageConfig.NO_PERMISSION.getValue());
      return false;
    }

    Inventory inventory = ((Player) sender).getInventory();

    MainConfig mainConfig = JoinWork.getInstance().getMainConfig();
    FileConfiguration config = mainConfig.getConfig();

    config.set("join-items", null); // Reset

    for (int i = 0; i < inventory.getSize(); i++) {
      ItemStack itemStack = inventory.getItem(i);
      if (itemStack != null) {
        config.set("join-items." + i, itemStack);
      }
    }

    mainConfig.saveConfig();
    MessageUtils.sendMessage(sender, MessageConfig.SUCCESS.getValue());

    return true;
  }
}
