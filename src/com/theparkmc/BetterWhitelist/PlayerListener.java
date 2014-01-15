package com.theparkmc.BetterWhitelist;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class PlayerListener implements Listener {
	private BetterWhitelist plugin;
	public PlayerListener(BetterWhitelist pl) {
		pl = this.plugin;
	}
	public void onPlayerLogin(PlayerLoginEvent e) {
		if(BetterWhitelist.isLockdown) {
			if(e.getPlayer().isOp()) {
				e.allow();
			} else {
				e.disallow(Result.KICK_WHITELIST, plugin.getKickMessage());
			}
		}
	}
}
