package me.gus.gui_captcha.gui_captcha;

import me.gus.gui_captcha.gui_captcha.command.OpenMenuCMD;
import me.gus.gui_captcha.gui_captcha.events.Event;
import org.bukkit.plugin.java.JavaPlugin;

public final class GUI_captcha extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("gcap").setExecutor(new OpenMenuCMD());

        getServer().getPluginManager().registerEvents(new Event(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
