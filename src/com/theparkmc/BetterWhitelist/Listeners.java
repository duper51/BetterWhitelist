package com.theparkmc.BetterWhitelist;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class Listeners implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(PlayerLoginEvent e) {
		if(BetterWhitelist.isLockdown()) {
			e.disallow(Result.KICK_WHITELIST, ChatColor.YELLOW + "TheParkMC is currently updating! " + ChatColor.RED + "Please check on our site for further updates!");
		}
	}
}
