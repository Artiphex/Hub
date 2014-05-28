package de.iron42.hub;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor{
	 
	 private Hub hub;
	 
	 public Commands(Hub hub){
	  this.hub = hub;
	 }

	 @Override
	 public boolean onCommand(final CommandSender cs, Command cmd, String label,
	   String[] args) {
	  if (cs.isOp()) {
	   
	  
	  if (label.equalsIgnoreCase("cc")) {
	    Bukkit.getScheduler().scheduleSyncDelayedTask(hub, new Runnable() {
	       
	       @Override
	       public void run() {
	       for (int i = 0; i < 100; i++) {
	        cs.sendMessage("\n");
	       }
	       }
	    });
	  }
	  
	  for (int i = 0; i < 100; i++) {
	  
	  }
	  // TODO Auto-generated method stub
	  
	  }
	  return true;
	 }

	}