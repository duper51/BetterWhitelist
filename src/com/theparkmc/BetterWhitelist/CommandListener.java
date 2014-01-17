package com.theparkmc.BetterWhitelist;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandListener implements CommandExecutor{
	public boolean onCommand(CommandSender p, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("lockdown")) {
			if(p.isOp()) {
				if(BetterWhitelist.isLockdown==false) {
					BetterWhitelist.isLockdown=true;
					for(Player pl : Bukkit.getOnlinePlayers()) {
						if(!pl.isOp()) {
							pl.kickPlayer(ChatColor.RED + "Player " + p.getName() + "has enabled a lockdown!");
						}
					}
					BetterWhitelist.sendConsole(ChatColor.RED + "Player " + p.getName() + "has enabled a lockdown!");
				} else {
					BetterWhitelist.isLockdown=false;
					BetterWhitelist.sendConsole(ChatColor.RED + "Player " + p.getName() + "has disabled a lockdown!");
				}
			}
		}
		if(label.equalsIgnoreCase("wl")) {
			if(p.hasPermission("bw.enablewhitelist")) {
				if(BetterWhitelist.isWhitelist==false) {
					BetterWhitelist.isWhitelist=true;
					BetterWhitelist.sendConsole(ChatColor.RED + "Player " + p.getName() + "has enabled a whitelist!");
				} else {
					BetterWhitelist.isWhitelist=false;
					BetterWhitelist.sendConsole(ChatColor.RED + "Player " + p.getName() + "has disabled a whitelist!");
				}
			}
		}
		//Leave this here
		return true;
	}

}
