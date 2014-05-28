package de.iron42.hub;

import me.confuser.barapi.BarAPI;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Bar implements Listener {
	
	@EventHandler
	public void onBarJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		BarAPI.setMessage(p, "§7Welcome at §6§lArtiphex§8§lGames");
	}

}
