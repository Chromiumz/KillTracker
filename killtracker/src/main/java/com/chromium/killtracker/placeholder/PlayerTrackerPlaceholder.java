package com.chromium.killtracker.placeholder;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import com.chromium.killtracker.Main;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class PlayerTrackerPlaceholder extends PlaceholderExpansion {

	@Override
	public @NotNull String getIdentifier() {
		return "killtracker";
	}

	@Override
	public @NotNull String getAuthor() {
		return "Chromium";
	}

	@Override
	public @NotNull String getVersion() {
		return "1.0.0";
	}

	@Override
    public String onRequest(OfflinePlayer player, String params) {
		
        if(params.equalsIgnoreCase("kills")){
            return String.valueOf(Main.getPlayerTracker(player.getUniqueId()).getKills());
        }
        
        if(params.equalsIgnoreCase("deaths")){
        	return String.valueOf(Main.getPlayerTracker(player.getUniqueId()).getDeaths());
        }
        
        if(params.equalsIgnoreCase("kda")){
        	return String.format("%.2f", Main.getPlayerTracker(player.getUniqueId()).getKDA());
        }
        
        if(params.equalsIgnoreCase("killstreak")){
        	return String.valueOf(Main.getPlayerTracker(player.getUniqueId()).getKillstreak().getKillStreak());
        }
        
        if(params.equalsIgnoreCase("bestkillstreak")){
        	return String.valueOf(Main.getPlayerTracker(player.getUniqueId()).getKillstreak().getBestKillStreak());
        }
        
        return null; // Placeholder is unknown by the expansion
    }
}
