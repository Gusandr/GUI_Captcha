package me.gus.gui_captcha.gui_captcha.command;

import me.gus.gui_captcha.gui_captcha.menu.menu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class OpenMenuCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        menu.instance.getInventory(player);
        return true;
    }
}
