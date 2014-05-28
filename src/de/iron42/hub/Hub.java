package de.iron42.hub;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class Hub extends JavaPlugin{
	
	public void onEnable(){
		System.out.println("Hub started!");
		System.out.println("Coded by iron42");
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new Build(), this);
		pm.registerEvents(new Weather(), this);
		pm.registerEvents(new ItemJoin(), this);
		pm.registerEvents(new Food(), this);
		pm.registerEvents(new PlayerDeathEvent(), this);
		pm.registerEvents(new Messages(), this);
		pm.registerEvents(new JumpPad(), this);
		pm.registerEvents(new Bar(), this);
		this.getCommand("store").setExecutor(new Shop());
		this.getCommand("cc").setExecutor(new Commands(this));
		
	}
	
	public void OnDisable(){
		System.out.println("Hub stoped!");
	}
}
