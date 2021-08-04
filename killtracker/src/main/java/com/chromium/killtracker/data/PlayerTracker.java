package com.chromium.killtracker.data;

import java.io.Serializable;
import java.util.UUID;

public class PlayerTracker implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private UUID id;
	private int kills;
	private int deaths;
	private Killstreak killstreak;
	
	public PlayerTracker(UUID id) {
		this.id = id;
		this.kills = 0;
		this.deaths = 0;
		this.killstreak = new Killstreak();
	}
	
	public UUID getUUID() {
		return id;
	}
	
	public int getKills() {
		return kills;
	}
	
	public void setKills(int kills) {
		this.kills = kills;
		this.killstreak.setKillStreak(this.getKillstreak().getKillStreak()+kills);
	}
	
	public void addKill() {
		this.kills++;
		this.killstreak.addKill();
	}
	
	public int getDeaths() {
		return deaths;
	}
	
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	
	public void addDeath() {
		this.deaths++;
		this.killstreak.setKillStreak(0);
	}
	
	public double getKDA() {
		if(this.deaths == 0)
			return 0;
		return (double)this.kills/(double)this.deaths;
	}
	
	public Killstreak getKillstreak() {
		return killstreak;
	}
	
	public void setKillstreak(Killstreak killstreak) {
		this.killstreak = killstreak;
	}
	
}
