package me.hsgamer.joinwork.listener;

import java.util.Map;
import me.hsgamer.hscore.bukkit.utils.MessageUtils;
import me.hsgamer.joinwork.config.MainConfig;
import me.hsgamer.joinwork.config.MessageConfig;
import org.bukkit.Location;
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

    // SPAWN JOIN
    Map<String, Object> spawnLocData = MainConfig.SPAWN_LOCATION_MAP.getValue();
    if (spawnLocData != null && !spawnLocData.isEmpty()) {
      player.teleport(Location.deserialize(spawnLocData));
    } else {
      MessageUtils.sendMessage(player, MessageConfig.NO_LOC.getValue());
    }

    // SPAWN ITEM
    Map<Integer, ItemStack> itemStackMap = MainConfig.JOIN_ITEMS.getValue();
    if (itemStackMap != null) {
      Inventory inventory = player.getInventory();
      inventory.clear();
      itemStackMap.forEach(inventory::setItem);
    }
  }
}
