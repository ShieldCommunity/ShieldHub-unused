package com.xism4.shieldhub.utils.managers;

import com.xism4.shieldhub.ShieldHub;
import com.xism4.shieldhub.utils.PlaceHolderUtils;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;


public class ConfigurationManager extends YamlConfiguration {

    private final String fileName;

    private final ShieldHub plugin;

    private File file;

    private File folder;

    public ConfigurationManager(ShieldHub plugin, String fileName, File folder) {
        this.folder = folder;
        this.plugin = plugin;
        this.fileName = fileName + (fileName.endsWith(".yml") ? "" : ".yml");
        createFile();
    }

    public ConfigurationManager(ShieldHub plugin, String fileName) {
        this(plugin, fileName, plugin.getDataFolder());
    }

    private void createFile() {
        try {
            this.file = new File(this.folder, this.fileName);
            if (file.exists()) {
                load(this.file);
                save(this.file);
                return;
            }
            if (this.plugin.getResource(this.fileName) != null) {
                this.plugin.saveResource(this.fileName, false);
            } else {
                save(this.file);
            }
            load(this.file);
        } catch (InvalidConfigurationException | IOException e) {
            this.plugin.getLogger().log(Level.SEVERE, "Creation of Configuration '" + this.fileName + "' failed.", e);
        }
    }

    public void delete() {
        if (!this.file.delete()) {
            this.plugin.getLogger().log(Level.SEVERE, "Error on delete the file '" + this.fileName + "'.");
        }
    }

    public void save() {

        if (folder == null) {
            folder = this.plugin.getDataFolder();
        }
        File file = new File(folder, this.fileName);
        try {
            save(file);
        } catch (IOException e) {
            this.plugin.getLogger().log(Level.SEVERE, "Save of the file '" + this.fileName + "' failed.", e);
        }
    }

    public void reload() {
        File folder = this.plugin.getDataFolder();
        File file = new File(folder, this.fileName);
        try {
            load(file);
        } catch (IOException | InvalidConfigurationException e) {
            this.plugin.getLogger().log(Level.SEVERE, "Reload of the file '" + this.fileName + "' failed.", e);
        }
    }

    public String getColoredString(String path) {
        return PlaceHolderUtils.colorize(getString(path));
    }

    public List<String> getColoredStringList(String path) {

        List<String> stringList = getStringList(path);
        stringList.replaceAll(PlaceHolderUtils::colorize);

        return stringList;
    }
}