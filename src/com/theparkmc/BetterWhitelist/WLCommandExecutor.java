package com.theparkmc.BetterWhitelist;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WLCommandExecutor implements CommandExecutor {

	public boolean onCommand(CommandSender snd, Command cmd, String label, String[] args) {
		if(snd instanceof Player) {
			if(args.length==0) {
				StringBuilder sb = new StringBuilder();
				sb.append(ChatColor.RED + "----BetterWhitelist----\n");
				sb.append("Coded by " + ChatColor.GOLD + "duper51!\n");
				sb.append(ChatColor.UNDERLINE + "" + ChatColor.BLUE + "Commands:\n");
				sb.append(ChatColor.RED + "/wl on - Enable the whitelist, but leave currently connected players online.\n");
				sb.append(ChatColor.DARK_RED + "/wl on oponly - Enable the whitelist, but leave currently connected players online.\n");
				sb.append(ChatColor.DARK_RED + "^---Only allow players with OP status to join. Ignore permissions.\n");
				sb.append(ChatColor.GREEN + "/wl off - Disable the whitelist\n");
				sb.append(ChatColor.GOLD + "/emergency - Kick all players and enable the whitelist\n");
				sb.append(ChatColor.GOLD + "/911 - Same as emergency");
				snd.sendMessage(sb.toString());
			} else if(args.length==1) {
				if(args[0].equals("on")) {
					if(snd.hasPermission("bw.whitelist")) {
						BetterWhitelist.setLockdown(true);
						BetterWhitelist.setOpOnly(false);
						snd.sendMessage(ChatColor.BOLD + "" + ChatColor.RED + "Whitelist enabled, OPs and Permissions allowed.");
						return true;
					} else {
						snd.sendMessage(ChatColor.DARK_RED + "You do not have the permission to do that!");
					}
				}
				if(args[0].equals("off")) {
					if(snd.hasPermission("bw.whitelist")) {
						BetterWhitelist.setLockdown(false);
						BetterWhitelist.setOpOnly(false);
						snd.sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "Whitelist disabled!");
						return true;
					} else {
						snd.sendMessage(ChatColor.DARK_RED + "You do not have the permission to do that!");
					}
				} else {
					snd.sendMessage("This is not a valid argument. Please check the command reference.");
				}
			} else if(args.length==2) {
				if(args[0].equals("on")) {
					if(args[1].equals("opsonly")) {
						if(snd.hasPermission("bw.whitelist.opsonly")) {
							BetterWhitelist.setLockdown(true);
							BetterWhitelist.setOpOnly(true);
							snd.sendMessage(ChatColor.BOLD + "" + ChatColor.RED + "Whitelist enabled, OPs only mode.");
						} else {
							snd.sendMessage(ChatColor.DARK_RED + "You do not have the permission to do that!");
						}
					} else {
						snd.sendMessage("This is not a valid argument. Please check the command reference.");
					}
				}
			}
		}
		return false;
	}

}
