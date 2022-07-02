package com.xism4.shieldhub.listeners;

import com.xism4.shieldhub.ShieldHub;
import com.xism4.shieldhub.listeners.utils.PlaceHolderUtils;
import com.xism4.shieldhub.listeners.utils.managers.ConfigurationManager;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ShieldListener implements Listener {

    private ShieldHub core;
    private ConfigurationManager configurationManager;

    public ShieldListener(ShieldHub plugin) {
        this.core = plugin;
    }

    @EventHandler
    public void PlayerEntryHandler(PlayerJoinEvent event) {
        event.setJoinMessage(ChatMessageType.CHAT+ PlaceHolderUtils.colorize(configurationManager.getString("hub.joinMessage")));
        Player player = event.getPlayer();
    }
}
