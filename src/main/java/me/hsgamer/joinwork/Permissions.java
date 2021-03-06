package me.hsgamer.joinwork;

import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import static me.hsgamer.hscore.bukkit.utils.PermissionUtils.createPermission;

public class Permissions {

    public static final Permission SET_SPAWN = createPermission("joinwork.setspawn", null, PermissionDefault.OP);
    public static final Permission SET_INVENTORY = createPermission("joinwork.setinventory", null, PermissionDefault.OP);

    private Permissions() {
        // EMPTY
    }
}
