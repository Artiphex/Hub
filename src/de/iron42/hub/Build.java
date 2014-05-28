package de.iron42.hub;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Build implements Listener{
	@EventHandler
	public void on(BlockPlaceEvent e) {
		if (e.getPlayer().isOp()) {
			e.setCancelled(false);
		} else if (!e.getPlayer().isOp()){
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void on(BlockBreakEvent e) {
		if (e.getPlayer().isOp()) {
			e.setCancelled(false);
		} else if (!e.getPlayer().isOp()){
			e.setCancelled(true);
		}
	}
}
