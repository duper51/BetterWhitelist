package com.theparkmc.BetterWhitelist;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class BetterWhitelist extends JavaPlugin {
	public static boolean lockdown = true;
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);
	}
	public void onDisable() {
		
	}
	public static boolean isLockdown() {
		return lockdown;
	}
	public static void setLockdown(boolean b) {
		lockdown=b;
	}
	public String getKickMessage() {
		if(this.getConfig().contains("config.kickMessage")) {
			String kickMessage = this.getConfig().getString("config.kickMessage");
			kickMessage = kickMessage.replaceAll("&", "§");
			return kickMessage;
		} else {
			return ChatColor.RED + "Server is in lockdown";
		}
	}
}
