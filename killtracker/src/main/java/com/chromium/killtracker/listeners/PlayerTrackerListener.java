package com.chromium.killtracker.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import com.chromium.killtracker.Main;
import com.chromium.killtracker.data.PlayerTracker;

public class PlayerTrackerListener implements Listener {
	
	 @EventHandler
	 public void onDeath(EntityDeathEvent e) {
		 Entity victim = e.getEntity();
		 Entity killer = e.getEntity().getKiller();
		 
		 if(victim instanceof Player && killer instanceof Player) {
			 PlayerTracker deadPlayer = Main.getPlayerTracker(((Player) victim).getUniqueId());
			 PlayerTracker killerPlayer = Main.getPlayerTracker(((Player) killer).getUniqueId());
			 
			 deadPlayer.addDeath();
			 killerPlayer.addKill();
		 }
	 }
	
}
