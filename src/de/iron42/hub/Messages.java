package de.iron42.hub;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Messages implements Listener{
	@EventHandler
	public void on(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage("");
		p.teleport(new Location(Bukkit.getWorld("Game"), 79.5, 155.5, 323.5));
	}
	
	@EventHandler
	public void on(PlayerQuitEvent e) {
		e.setQuitMessage("");
	}
	
}
