package com.chromium.killtracker;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Logger {
	
	public static void log(String msg) {
		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6KillTracker&7] " + msg));
	}
	
	public static void log(String msg, Player p) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6KillTracker&7] " + msg));
	}
	
}
