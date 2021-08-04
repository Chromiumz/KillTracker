package com.chromium.killtracker.data;

import java.io.Serializable;

public class Killstreak implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int killStreak;
	private int bestKillStreak;
	
	public Killstreak(int killStreak, int bestKillStreak) {
		this.killStreak = killStreak;
		this.bestKillStreak = bestKillStreak;
	}
	
	public Killstreak(int killstreak) {
		this(0,0);
	}
	
	public Killstreak() {
		this(0);
	}
	
	public void setKillStreak(int killStreak) {
		this.killStreak = killStreak;
		updateBestKillStreak();
	}
	
	public void addKill() {
		this.killStreak++;
		updateBestKillStreak();
	}
	
	public int getKillStreak() {
		return killStreak;
	}
	
	public int getBestKillStreak() {
		return bestKillStreak;
	}
	
	private void updateBestKillStreak() {
		if(killStreak > bestKillStreak) {
			bestKillStreak = killStreak;
		}
	}
}
