package de.iron42.hub;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import de.howaner.BungeeCordLib.BungeeCord;
import de.howaner.BungeeCordLib.server.BungeeServer;

public class ItemJoin implements Listener {
	
	public static ArrayList<Player> hide = new ArrayList<Player>();
	public Inventory inv = null;
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
			if (e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getMaterial().equals(Material.SPECKLED_MELON)) {
					this.inv = p.getServer().createInventory(null, 9, "§e§lChange Lobby");
					ItemStack item = new ItemStack (Material.RECORD_4);
					ItemStack item2 = new ItemStack (Material.GREEN_RECORD);
					ItemStack item3 = new ItemStack(Material.LAPIS_BLOCK);
					   item3.setDurability((short) 4);
					
					ItemMeta meta = item.getItemMeta();
					ItemMeta meta2 = item.getItemMeta();
					ItemMeta meta3 = item.getItemMeta();
					
					meta.setDisplayName("§4Regular Lobby");
					meta2.setDisplayName("§2Premium");
					meta.setLore(null);
					meta2.setLore(null);
					meta3.setDisplayName("§3Controll Panel");
					
					item.setItemMeta(meta);
					item2.setItemMeta(meta2);
					item3.setItemMeta(meta3);
					
					this.inv.setItem(1, item);
					this.inv.setItem(7, item2);
					if (p.hasPermission("chat.yt")) {
						this.inv.setItem(4, item3);
					}
					
					
					p.openInventory(this.inv);
				}
			}
			
			if (e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getMaterial().equals(Material.REDSTONE)) {
					  
					ItemStack hitem = new ItemStack (Material.SULPHUR);
					ItemMeta meta = hitem.getItemMeta();
					meta.setDisplayName("§aShow Players");
					hitem.setItemMeta(meta);
					
					for (Player pl : Bukkit.getOnlinePlayers()) {   
							p.hidePlayer(pl);
					        hide.add(p);
					  }
					p.getInventory().setItem(7, new ItemStack(hitem));
					p.updateInventory();
					p.sendMessage("§8[§6Hub§8] §7All players are hidden");
				}
				
				
			} 
				if (e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (e.getMaterial().equals(Material.SULPHUR)) {
				ItemStack hitem2 = new ItemStack (Material.REDSTONE);
				ItemMeta meta2 = hitem2.getItemMeta();
				meta2.setDisplayName("§cHide Players");
				hitem2.setItemMeta(meta2);
				
				if(hide.contains(p)) {
					for (Player pl1 : Bukkit.getOnlinePlayers()) {
				        p.showPlayer(pl1);
				        hide.remove(p);
					}
			        p.getInventory().setItem(7, new ItemStack(hitem2));
			        p.updateInventory();
			        p.sendMessage("§8[§6Hub§8] §7All players are visible");
				}
			}
			}

	}
	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		
		if (e.getInventory().getName().equalsIgnoreCase("§e§lChange Lobby")) {
			if(e.getCurrentItem().getType() == Material.RECORD_4) {
				e.setCancelled(true);
				e.setResult(Result.DENY);
				//BungeeServer server = BungeeCord.getManager().addServer("de");
				//server.teleport(p);	
			} else if (e.getCurrentItem().getType() == Material.GREEN_RECORD) {
				//BungeeServer server = BungeeCord.getManager().addServer("eu");
				//server.teleport(p);	
				e.setCancelled(true);
				e.setResult(Result.DENY);
			} else {
				e.setCancelled(false);
				e.setResult(Result.ALLOW);
			}
		}
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		ItemStack join1 = new ItemStack (Material.SPECKLED_MELON);
		ItemStack join2 = new ItemStack (Material.REDSTONE);
		ItemStack join3 = new ItemStack (Material.REDSTONE);
		
		ItemMeta meta = join1.getItemMeta();
		ItemMeta meta2 = join2.getItemMeta();
		ItemMeta meta3 = join3.getItemMeta();
		
		meta.setDisplayName("§2Lobby");
		meta2.setDisplayName("§cHide Players");
		meta3.setDisplayName("§3Teleport");
		
		
		meta.setLore(null);
		meta2.setLore(null);
		meta3.setLore(null);
		
		
		join1.setItemMeta(meta);
		join2.setItemMeta(meta2);
		join3.setItemMeta(meta3);
		
		Player p = e.getPlayer();
		p.getInventory().clear();	
		p.getInventory().setItem(8, new ItemStack(join1));
		p.getInventory().setItem(7, new ItemStack(join2));
		p.setFoodLevel(20);
		p.teleport(new Location(Bukkit.getWorld("world"), -1.5, 24.5, 0.5));
		
		for (Player hidePlayer : hide) {
		    e.getPlayer().hidePlayer(hidePlayer);
		}

	}
	
	  @EventHandler
	  public void on(PlayerDropItemEvent e)
	  {
	    e.setCancelled(true);
	  }

}
