package com.xism4.shieldhub.commands;

import com.xism4.shieldhub.ShieldHub;
import com.xism4.shieldhub.utils.PlaceHolderUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShieldHubCommand implements CommandExecutor {

    private final ShieldHub core;

    public ShieldHubCommand(ShieldHub plugin) {
        this.core = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            if (args.length <= 0) {
                sender.sendMessage(
                        PlaceHolderUtils.colorize("&eUse &6/shieldhub help &fto see more info about the plugin")
                );
                return true;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                // empty
            }
        }
        return true;
    }
}

