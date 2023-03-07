package me.gus.gui_captcha.gui_captcha.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.List;

public class util {

    public static ItemStack createItemStack(Material material, String name) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(name);

        itemStack.setItemMeta(meta);

        return itemStack;
    }


    public static ItemStack createItemStack(Material material, String name, List<String> lore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(lore);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
}
