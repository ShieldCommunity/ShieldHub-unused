package com.xism4.shieldhub.interfaces;

import org.bukkit.Server;
import org.bukkit.entity.Player;

public interface IHubRegistry {
    void scoreboardHandler(Player player);

    void lobbyGuard(Server server);

    void reloadCore();

    boolean isPlayerHook(Boolean player);

    int placeHolderList(Player player);

}
