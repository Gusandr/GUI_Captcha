package me.gus.gui_captcha.gui_captcha.events;

import me.gus.gui_captcha.gui_captcha.menu.menu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

public class Event implements Listener {

    public int popitki = 0;
    public List<String> popitku = new ArrayList<>();
    public List<String> menushkaClose = new ArrayList<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        popitku.add(player.getName());
        menushkaClose.add(player.getName());
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String name = player.getName();
        if (event.getView().getTitle().equals("Вычисли: " + menu.instance.firstNumber() + " + " + menu.instance.secondNumber() + " = ???")) {
            event.setCancelled(true);
            if (event.getCurrentItem() != null) {
                String itemName = event.getCurrentItem().getItemMeta().getDisplayName();

                int numbersSum = menu.instance.getNumbersSum();

                if (itemName.equals("§c(!) §7Мой ответ: " + numbersSum)) {
                    popitku.remove(player.getName());
                    menushkaClose.remove(player.getName());
                    player.closeInventory();
                    player.sendMessage("§c(!) §7Ура");
                } else {
                    player.sendMessage("§c(!) §7Не ура");
                    menushkaClose.remove(player.getName());
                    player.closeInventory();
                    menushkaClose.add(player.getName());
                    player.openInventory(menu.instance.getInventoryPlus(player));
                }
            } else if (event.getCurrentItem() == null) {
                player.sendMessage("§c(!) §7Не туда нажал!");
                menushkaClose.remove(player.getName());
                player.closeInventory();
                menushkaClose.add(player.getName());
                player.openInventory(menu.instance.getInventory(player));
            }
        }
    }

    @EventHandler
    public void onClickPlus(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String name = event.getWhoClicked().getName();
        if (event.getView().getTitle().equals("Вычислите: " + menu.instance.firstNumberPlus() + " + " + menu.instance.secondNumberPlus() + " = ???")) { // костыли
            event.setCancelled(true);
            if (event.getCurrentItem() != null) {
                String itemName = event.getCurrentItem().getItemMeta().getDisplayName();

                int numbersSum = menu.instance.getNumbersSumPlus();

                if (itemName.equals("§c(!) §7Мой ответ: " + numbersSum)) {
                    popitku.remove(player.getName());
                    menushkaClose.remove(player.getName());
                    player.closeInventory();
                    player.sendMessage("§c(!) §7Ура");
                } else {
                    player.sendMessage("§c(!) §7Не ура");
                    menushkaClose.remove(player.getName());
                    player.closeInventory();
                    menushkaClose.add(player.getName());
                    player.openInventory(menu.instance.getInventoryPlus(player));
                }
            } else if (event.getCurrentItem() == null) {
                player.sendMessage("§c(!) §7Не туда нажал!");
                menushkaClose.remove(player.getName());
                player.closeInventory();
                menushkaClose.add(player.getName());
                player.openInventory(menu.instance.getInventoryPlus(player));
            }
        }
    }

    @EventHandler
    public void MenuNummerator(InventoryOpenEvent event) {

        if (event.getView().getTitle().equals("Вычислите: " + menu.instance.firstNumberPlus() + " + " + menu.instance.secondNumberPlus() + " = ???")) {

            String name = event.getPlayer().getName();
            Player player = (Player) event.getPlayer();

            if (!this.popitku.contains(name)) {
                popitki++;
                if (popitki >= 5) {
                    player.kickPlayer("§c(!) §7Вы использовали все свои попытки!");

                }
            }
        }
    }

    @EventHandler
    public void CloseMenu (InventoryCloseEvent event) {

        String name = event.getPlayer().getName();
        Player player = (Player) event.getPlayer();

        if (event.getView().getTitle().equals("Вычисли: " + menu.instance.firstNumber() + " + " + menu.instance.secondNumber() + " = ???")) { // костыли

            if (!this.menushkaClose.contains(player.getName())) {

                player.sendMessage("§c(!) §7Вы потратили одну попытку, из-за того что закрыли меню с проверкой!");
                menushkaClose.add(player.getName());
                menu.instance.openInventoryPlus(player);

            }
        }
    }

    @EventHandler
    public void CloseMenuPlus (InventoryCloseEvent event) {

        String name = event.getPlayer().getName();
        Player player = (Player) event.getPlayer();

        if (event.getView().getTitle().equals("Вычислите: " + menu.instance.firstNumberPlus() + " + " + menu.instance.secondNumberPlus() + " = ???")) { // костыли

            if (!this.menushkaClose.contains(player.getName())) {

                player.sendMessage("§c(!) §7Вы потратили одну попытку, из-за того что закрыли меню с проверкой!");
                menushkaClose.add(player.getName());
                menu.instance.openInventoryPlus(player);

            }
        }
    }

}
