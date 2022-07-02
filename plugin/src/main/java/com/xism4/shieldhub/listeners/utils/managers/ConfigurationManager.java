package com.xism4.shieldhub.listeners.utils.managers;

import com.xism4.shieldhub.ShieldHub;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigurationManager extends YamlConfiguration {

    private static ConfigurationManager configurationManager;

    public static ConfigurationManager getMessages() {
        if (configurationManager == null) {
            configurationManager = new ConfigurationManager();
        }
        return configurationManager;
    }

    private final ShieldHub plugin;
    private final File configurationFile;

    public ConfigurationManager() {
        plugin = ShieldHub.getPlugin(ShieldHub.class);
        configurationFile = new File(plugin.getDataFolder(), "config.yml");
        saveDefault();
        reload();
    }

    public void reload() {
        try {
            super.load(configurationFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            super.save(configurationFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveDefault() {
        plugin.saveResource("config.yml", false);
    }
}