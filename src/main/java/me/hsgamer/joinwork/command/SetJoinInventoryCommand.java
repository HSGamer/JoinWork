package me.hsgamer.joinwork.command;

import me.hsgamer.hscore.bukkit.utils.MessageUtils;
import me.hsgamer.joinwork.JoinWork;
import me.hsgamer.joinwork.Permissions;
import me.hsgamer.joinwork.config.MainConfig;
import me.hsgamer.joinwork.config.MessageConfig;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

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

        Map<Integer, ItemStack> itemStackMap = new HashMap<>();
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack itemStack = inventory.getItem(i);
            if (itemStack != null) {
                itemStackMap.put(i, itemStack);
            }
        }
        MainConfig.JOIN_ITEMS.setValue(itemStackMap);
        JoinWork.getInstance().getMainConfig().saveConfig();

        MessageUtils.sendMessage(sender, MessageConfig.SUCCESS.getValue());

        return true;
    }
}
