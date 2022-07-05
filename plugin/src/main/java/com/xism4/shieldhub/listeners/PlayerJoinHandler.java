package com.xism4.shieldhub.listeners;

import com.xism4.shieldhub.ShieldHub;
import com.xism4.shieldhub.utils.managers.ConfigurationManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinHandler implements Listener {

    private ShieldHub core;
    private ConfigurationManager configurationManager;
    private String noPermission = "[ShieldHub] You can't use that command without permission";

    public PlayerJoinHandler(ShieldHub plugin) {
        this.core = plugin;
    }

    @EventHandler
    public void PlayerEntryHandler(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);
        player.setHealth(20);

        for (Player p : Bukkit.getOnlinePlayers())
            p.hidePlayer(player);
        for (Player p : Bukkit.getOnlinePlayers())
            player.hidePlayer(p);
    }
    /* //fixme: Just ill keep it here until new configManager
        List<String> list = PlaceholderAPI.setPlaceholders(player, configurationManager.getStringList("hub.joinmessage"));
        for (String s : list) {
            player.sendMessage(PlaceHolderUtils.colorize(s).replace("%player%", player.getName()).replace("%bullet_point%", "•"));
        }
     */

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("shieldhub.command.blockplace") || !event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            event.setCancelled(true);
            player.sendMessage(noPermission);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("shieldhub.command.blockbreak") || !event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            event.setCancelled(true);
            player.sendMessage(noPermission);
        }
    }
}
