package de.iron42.hub;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class JumpPad implements Listener{
	@EventHandler
	public void on (PlayerMoveEvent e) {
		Player p = e.getPlayer();
		Location From1 = new Location(p.getWorld(), e.getFrom().getX(), e.getFrom().getY() - 0.0D, e.getFrom().getZ());
		Location From2 = new Location(p.getWorld(), e.getFrom().getX(), e.getFrom().getY() - 1.0D, e.getFrom().getZ());
		if(From1.getBlock().getType() == Material.STONE_PLATE && From2.getBlock().getType() == Material.REDSTONE_BLOCK) {
			p.setVelocity(p.getLocation().getDirection().multiply(3.0D));
			p.setVelocity(p.getVelocity().setY(0.6D));
		}
	}

}
