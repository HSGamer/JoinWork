package me.hsgamer.joinwork.command;

import me.hsgamer.hscore.bukkit.config.object.Position;
import me.hsgamer.hscore.bukkit.utils.MessageUtils;
import me.hsgamer.joinwork.Permissions;
import me.hsgamer.joinwork.config.MainConfig;
import me.hsgamer.joinwork.config.MessageConfig;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import static me.hsgamer.joinwork.JoinWork.getInstance;

public class SetSpawnCommand extends BukkitCommand {

    public SetSpawnCommand() {
        super("setspawn");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            MessageUtils.sendMessage(sender, MessageConfig.PLAYER_ONLY.getValue());
            return false;
        }

        if (!sender.hasPermission(Permissions.SET_SPAWN)) {
            MessageUtils.sendMessage(sender, MessageConfig.NO_PERMISSION.getValue());
            return false;
        }

        Location location = ((Player) sender).getLocation();
        MainConfig.SPAWN_LOCATION.setValue(new Position(location.getWorld().getName(), location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch()));
        getInstance().getMainConfig().save();
        MessageUtils.sendMessage(sender, MessageConfig.SUCCESS.getValue());

        return true;
    }
}
