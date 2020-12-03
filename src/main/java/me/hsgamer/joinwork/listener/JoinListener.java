package me.hsgamer.joinwork.listener;

import me.hsgamer.joinwork.config.MainConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class JoinListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        // SPAWN JOIN
        player.teleport(MainConfig.SPAWN_LOCATION.getValue());

        // SPAWN ITEM
        Map<Integer, ItemStack> itemStackMap = MainConfig.JOIN_ITEMS.getValue();
        if (itemStackMap != null) {
            Inventory inventory = player.getInventory();
            inventory.clear();
            itemStackMap.forEach(inventory::setItem);
        }
    }
}
