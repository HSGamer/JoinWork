package me.hsgamer.joinwork.listener;

import me.hsgamer.hscore.utils.CommonUtils;
import me.hsgamer.joinwork.JoinWork;
import me.hsgamer.joinwork.config.MessageConfig;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class JoinListener implements Listener {

  @EventHandler(priority = EventPriority.LOWEST)
  public void onJoin(PlayerJoinEvent e) {
    Player player = e.getPlayer();
    FileConfiguration config = JoinWork.getInstance().getMainConfig().getConfig();

    // SPAWN JOIN
    if (config.isSet("spawn-location")) {
      player.teleport((Location) config.get("spawn-location"));
    } else {
      CommonUtils.sendMessage(player, MessageConfig.NO_LOC.getValue());
    }

    // SPAWN ITEM
    if (config.isSet("join-items")) {
      Inventory inventory = player.getInventory();
      inventory.clear();
      ConfigurationSection section = config.getConfigurationSection("join-items");
      for (String k : section.getKeys(false)) {
        int index = Integer.parseInt(k);
        ItemStack itemStack = config.getItemStack(k);
        inventory.setItem(index, itemStack);
      }
      player.updateInventory();
    }
  }
}
