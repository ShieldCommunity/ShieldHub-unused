package com.xism4.shieldhub.listeners;

import com.xism4.shieldhub.ShieldHub;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherHandler implements Listener {

    private ShieldHub core;

    public WeatherHandler(ShieldHub plugin) {
        this.core = plugin;
    }

    @EventHandler
    public void weatherDetect(WeatherChangeEvent event) {
        event.setCancelled(true);
        event.getWorld()
                .setWeatherDuration(0);
    }
}
