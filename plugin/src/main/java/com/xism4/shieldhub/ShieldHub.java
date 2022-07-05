package com.xism4.shieldhub;

import com.xism4.shieldhub.commands.ShieldHubCommand;
import com.xism4.shieldhub.listeners.PlayerJoinHandler;
import com.xism4.shieldhub.listeners.WeatherHandler;
import com.xism4.shieldhub.utils.managers.ConfigurationManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ShieldHub extends JavaPlugin {

    private static ShieldHub instance;
    private ConfigurationManager config;

    public static ShieldHub getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        getLogger().info("ShieldHub has been enabled " +
                Bukkit.getVersion());
        commandHandler();
        eventHandler();
        this.config = new ConfigurationManager(
                this,"config.yml");
    }

    @Override
    public void onDisable() {
        getLogger().warning("ShieldHub has been disabled, remember to clear data");
    }

    public void commandHandler() {
        this.getCommand("shieldhub").setExecutor(
                new ShieldHubCommand(this));
    }

    public void eventHandler() {
        getServer().getPluginManager().registerEvents(new PlayerJoinHandler(this), this);
        getServer().getPluginManager().registerEvents(new WeatherHandler(this),this);
    }
    
    public ConfigurationManager configurationManager(){
        return config;
    }
}
