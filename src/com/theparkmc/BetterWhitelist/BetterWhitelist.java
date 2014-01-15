package com.theparkmc.BetterWhitelist;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class BetterWhitelist extends JavaPlugin {
	public BetterWhitelist plugin = this;
	public static boolean isLockdown = false;
	public void onEnable() {
		sendConsole("Starting up the system");
	}
	public void onDisable() {
		
	}
	public static void sendConsole(String s) {
		Bukkit.getLogger().info("[BetterWhitelist] " + s);
	}
	public String getKickMessage() {
		if(this.plugin.getConfig().contains("kickMessage")) {
			return ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("kickMessage"));
		} else {
			return ChatColor.RED + "This server is in lockdown.";
		}
	}
}
