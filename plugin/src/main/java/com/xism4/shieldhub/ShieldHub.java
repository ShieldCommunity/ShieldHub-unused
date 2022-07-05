package com.xism4.shieldhub;

import com.xism4.shieldhub.commands.ShieldHubCommand;
import com.xism4.shieldhub.listeners.PlayerJoinHandler;
import com.xism4.shieldhub.listeners.WeatherHandler;
import com.xism4.shieldhub.utils.managers.ConfigurationManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class ShieldHub extends JavaPlugin {

    private static ShieldHub instance;

    public static ShieldHub getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        getLogger().info("ShieldHub has been enabled " +
                Bukkit.getVersion());
        commandHandler();
        eventHandler();
        ConfigurationManager.getMessages();
    }

    @Override
    public void onDisable() {
        getLogger().warning("ShieldHub has been disabled, remember to clear data");
    }

    public void commandHandler() {
        Objects.requireNonNull(this.getCommand("shieldhub")).setExecutor(
                new ShieldHubCommand(this));
    }

    public void eventHandler() {
        getServer().getPluginManager().registerEvents(new PlayerJoinHandler(this), this);
        getServer().getPluginManager().registerEvents(new WeatherHandler(this),this);
    }
}
