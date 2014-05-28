package de.iron42.hub;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class Food implements Listener{
	@EventHandler
	  public void on(FoodLevelChangeEvent e)
	  {
	    e.setCancelled(true);
	  }


}
