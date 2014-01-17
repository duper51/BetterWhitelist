package com.theparkmc.BetterWhitelist;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class BetterWhitelist extends JavaPlugin {
	public BetterWhitelist plugin = this;
	public static boolean isLockdown = false;
	public static boolean isWhitelist = false;
	public void onEnable() {
		sendConsole("Starting up the system");
		Bukkit.getPluginManager().registerEvents(new PlayerListener(this), this);
		Bukkit.getServer().getPluginCommand("lockdown").setExecutor(new CommandListener());
		Bukkit.getServer().getPluginCommand("wl").setExecutor(new CommandListener());
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
