package com.xism4.shieldhub;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ShieldHub extends JavaPlugin {
	
    @Override
    public void onEnable() {
        getLogger().info("ShieldHub has been enabled "+
                Bukkit.getVersion());
        commandHandler();
        eventHandler();
    }

    @Override
    public void onDisable() {
        getLogger().warning("ShieldHub has been disabled, remember to clear data");
    }

    public void commandHandler() {}

    public void eventHandler() {}
}
