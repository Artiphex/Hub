package de.iron42.hub;

import java.util.ArrayList;



import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
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
import org.bukkit.inventory.meta.ItemMeta;


public class ItemJoin implements Listener {
	
	public static ArrayList<Player> hide = new ArrayList<Player>();
	public Inventory inv = null;
	public Inventory inv2 = null;
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
			if (e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getMaterial().equals(Material.INK_SACK)) {
					this.inv = p.getServer().createInventory(null, 9, "§3§lControl Panel");
					ItemStack item = new ItemStack (Material.WATCH);
					ItemStack item2 = new ItemStack (Material.GREEN_RECORD);
					
					ItemMeta meta = item.getItemMeta();
					ItemMeta meta2 = item.getItemMeta();
					
					meta.setDisplayName("§9Time");
					meta2.setDisplayName("§2Premium");
					meta.setLore(null);
					meta2.setLore(null);
					
					item.setItemMeta(meta);
					item2.setItemMeta(meta2);
					
					this.inv.setItem(1, item);
					this.inv.setItem(7, item2);
					
					p.openInventory(this.inv);
				}
			}
			
				this.inv2 = p.getServer().createInventory(null, 9, "§3§lChange Time");
				ItemStack itemDay = new ItemStack (Material.GLOWSTONE_DUST);
				ItemStack itemNight = new ItemStack (Material.STAINED_GLASS, 1, (short) 11 /*data of dye*/);
				ItemStack itemFreeze = new ItemStack (Material.ICE);
				
				ItemMeta metaDay = itemDay.getItemMeta();
				ItemMeta metaNight = itemNight.getItemMeta();
				ItemMeta metaFreeze = itemFreeze.getItemMeta();
				
				metaDay.setDisplayName("§6Day");
				metaNight.setDisplayName("§3Night");
				metaFreeze.setDisplayName("§9Freeze Time");
				
				metaDay.setLore(null);
				metaNight.setLore(null);
				metaFreeze.setLore(null);
				//1800
				//5200
				itemDay.setItemMeta(metaDay);
				itemNight.setItemMeta(metaNight);
				itemFreeze.setItemMeta(metaFreeze);
				
				this.inv2.setItem(1, itemDay);
				this.inv2.setItem(4, itemNight);
				this.inv2.setItem(7, itemFreeze);
				
				
				
			
			
			
			
			
			
			
			
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
					p.getInventory().setItem(1, new ItemStack(hitem));
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
			        p.getInventory().setItem(1, new ItemStack(hitem2));
			        p.updateInventory();
			        p.sendMessage("§8[§6Hub§8] §7All players are visible");
				}
			}
			}
				
				if (e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (e.getMaterial().equals(Material.SPECKLED_MELON)) {
				p.sendMessage("§8[§6ArtiphexGame§8] §7For more Lobby's we need donations!");
			}
			}
				
				if (e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (e.getMaterial().equals(Material.GLOWSTONE_DUST)) {
					for (World world : Bukkit.getWorlds()) {
						world.setTime(5200);
				}
			}
			}
				

	}
	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		
		if (e.getInventory().getName().equalsIgnoreCase("§3§lControl Panel")) {
			if(e.getCurrentItem().getType() == Material.WATCH) {
				e.setCancelled(true);
				e.setResult(Result.DENY);
				p.openInventory(this.inv2);
				//BungeeServer server = BungeeCord.getManager().addServer("de");
				//server.teleport(p);	
			
				
			} else {
				e.setCancelled(false);
				e.setResult(Result.ALLOW);
			}
		}
	}
	
	@EventHandler
	public void onInvClick2(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if (e.getCurrentItem().getType() == Material.GLOWSTONE_DUST) {
		//BungeeServer server = BungeeCord.getManager().addServer("eu");
		//server.teleport(p);
		e.setCancelled(true);
		e.setResult(Result.DENY);
		p.closeInventory();
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule doDaylightCycle true");
		for(World world : Bukkit.getWorlds()) {
			world.setTime(5200);
		}
		} else if (e.getCurrentItem().getType() == Material.STAINED_GLASS) {
			e.setCancelled(true);
			e.setResult(Result.DENY);
			p.closeInventory();
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule doDaylightCycle true");
			
			for(World world : Bukkit.getWorlds()) {
				world.setTime(18000);
		}
		} else if (e.getCurrentItem().getType() == Material.ICE) {
			e.setCancelled(true);
			e.setResult(Result.DENY);
			p.closeInventory();
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule doDaylightCycle false");
		}
	}

		
		
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		ItemStack join1 = new ItemStack (Material.SPECKLED_MELON);
		ItemStack join2 = new ItemStack (Material.REDSTONE);
		ItemStack join3 = new ItemStack (Material.REDSTONE);
		ItemStack join4 =  new ItemStack(Material.INK_SACK, 1, (short) 4 /*data of dye*/);
		
		ItemMeta meta = join1.getItemMeta();
		ItemMeta meta2 = join2.getItemMeta();
		ItemMeta meta3 = join3.getItemMeta();
		ItemMeta meta4 = join4.getItemMeta();
		
		meta.setDisplayName("§2Lobby");
		meta2.setDisplayName("§cHide Players");
		meta3.setDisplayName("§3Teleport");
		meta4.setDisplayName("§3Control Panel");
		
		
		meta.setLore(null);
		meta2.setLore(null);
		meta3.setLore(null);
		meta4.setLore(null);
		
		
		join1.setItemMeta(meta);
		join2.setItemMeta(meta2);
		join3.setItemMeta(meta3);
		join4.setItemMeta(meta4);
		
		Player p = e.getPlayer();
		p.getInventory().clear();	
		p.getInventory().setItem(8, new ItemStack(join1));
		p.getInventory().setItem(1, new ItemStack(join2));
		if (e.getPlayer().hasPermission("chat.yt")) {
			p.getInventory().setItem(4, new ItemStack(join4));
		}
		p.setFoodLevel(20);
		p.teleport(new Location(Bukkit.getWorld("world"), -1.5, 24.5, 0.5));
		p.updateInventory();
		
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
