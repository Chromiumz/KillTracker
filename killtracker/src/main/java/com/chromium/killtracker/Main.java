package com.chromium.killtracker;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.chromium.killtracker.data.PlayerTracker;
import com.chromium.killtracker.listeners.PlayerTrackerListener;

public class Main extends JavaPlugin implements Listener {

	private static HashMap<UUID, PlayerTracker> onlinePlayers = new HashMap<UUID, PlayerTracker>(); 
	private static Main instance;
	
	public void onEnable() {
		Logger.log("&aKillTracker has been enabled");
		
		instance = this;
		
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new PlayerTrackerListener(), this);

	}
	
	public void onDisable() {
		Logger.log("&cKillTracker has been disabled");
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		UUID id = p.getUniqueId();
		PlayerTracker player = (PlayerTracker) Serializable.Players.readUniqueFile(id.toString());
		
		if(player != null) {
			Logger.log(String.format("&aLoaded player tracker for &e%s", p.getName()));
			onlinePlayers.put(id, player);
		} else {
			Logger.log(String.format("&aRegistered a player tracker for &e%s", p.getName()));
			onlinePlayers.put(id, new PlayerTracker(id));
		}
		
		
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		UUID id = p.getUniqueId();
		
		Logger.log(String.format("&aSaved player tracker for &e%s", p.getName()));
		Serializable.Players.writeUniqueFile(onlinePlayers.get(id), id.toString());
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	public static PlayerTracker getPlayerTracker(UUID id) {
		return onlinePlayers.get(id);
	}
	
}
