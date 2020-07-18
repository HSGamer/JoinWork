package me.hsgamer.joinwork;

import static me.hsgamer.hscore.utils.PermissionUtils.createPermission;

import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

public class Permissions {

  public static final Permission SET_SPAWN = createPermission("joinwork.setspawn", null,
      PermissionDefault.OP);
  public static final Permission SET_INVENTORY = createPermission("joinwork.setinventory", null,
      PermissionDefault.OP);

  private Permissions() {
    // EMPTY
  }
}
