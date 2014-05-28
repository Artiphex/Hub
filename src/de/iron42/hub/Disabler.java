package de.iron42.hub;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Disabler implements Listener{
	@EventHandler
	public void on(PlayerCommandPreprocessEvent e) {
		//e.getMessage().replaceFirst("/", "");
		//if (Message.equalsIgnoreCase("ban")) e.setCancelled(true);
	}
}
