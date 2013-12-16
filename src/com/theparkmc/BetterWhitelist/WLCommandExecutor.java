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
				sb.append("/wl on - Enable the whitelist, but leave currently connected players online.\n");
				sb.append("/wl off - Disable the whitelist\n");
				sb.append("/emergency - Kick all players and enable the whitelist\n");
				sb.append("/911 - Same as emergency\n");
				snd.sendMessage(sb.toString());
			} else if(args.length==1) {
				if(args[0].equals("on")) {
					if(snd.hasPermission("bw.whitelist")) {
						BetterWhitelist.setLockdown(true);
					}
				}
				if(args[0].equals("off")) {
					if(snd.hasPermission("bw.whitelist")) {
						BetterWhitelist.setLockdown(false);
					}
				}
			}
		}
		return false;
	}

}
