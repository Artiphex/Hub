package de.iron42.hub;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Shop implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("store")){
			cs.sendMessage("§8[§6ArtiphexGame§8] §7Coming Soon");
		}
		return true;
	}

}
