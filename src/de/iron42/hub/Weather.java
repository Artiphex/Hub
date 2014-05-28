package de.iron42.hub;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Weather implements Listener{
	@EventHandler
	public void on(WeatherChangeEvent e) {
		e.setCancelled(true);
		
	}
}
