package com.theparkmc.BetterWhitelist;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class Listeners implements Listener {
	private BetterWhitelist plugin;
	public Listeners(BetterWhitelist plugin) {
		this.plugin = plugin;
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(PlayerLoginEvent e) {
		if(BetterWhitelist.isLockdown()) {
			if(e.getPlayer().hasPermission("bw.joinwhitelisted")) {
				if(!BetterWhitelist.isOpOnly()) {
					e.getPlayer().sendMessage(ChatColor.YELLOW + "You joined the server while it was whitelisted.");
				} else {
					if(!e.getPlayer().isOp()) {
						e.disallow(Result.KICK_WHITELIST, plugin.getKickMessage());
					} else {
						e.getPlayer().sendMessage(ChatColor.YELLOW + "You joined the server while it was whitelisted AND OP ONLY!");
					}
				}
			} else {
				e.disallow(Result.KICK_WHITELIST, plugin.getKickMessage());
			}
		}
	}
}
