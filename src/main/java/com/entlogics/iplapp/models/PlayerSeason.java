package com.entlogics.iplapp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lt_player_season")
@IdClass(PlayerSeason.class)
public class PlayerSeason implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name="playerID")
	private Player player;

	@Id
	@ManyToOne
	@JoinColumn(name = "seasonID")
	private Season season;

	@Column(name = "total_runs")
	private int totalRuns;

	@Column(name = "total_wickets")
	private int totalWickets;

	@Column(name = "total_catches")
	private int totalCatches;

	@Column(name = "strike_rate")
	private float strikeRate;

	public PlayerSeason() {
		
	}
	
	public PlayerSeason(Player player, Season season) {
		super();
		this.player = player;
		this.season = season;
	}

	public void setPlayerSeasonProperties(int runs, int wickets, float strikeRate, int catches) {

		this.setTotalRuns(runs);
		this.setTotalWickets(wickets);
		this.setStrikeRate(strikeRate);
		this.setTotalCatches(catches);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public int getTotalRuns() {
		return totalRuns;
	}

	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}

	public int getTotalWickets() {
		return totalWickets;
	}

	public void setTotalWickets(int totalWickets) {
		this.totalWickets = totalWickets;
	}

	public int getTotalCatches() {
		return totalCatches;
	}

	public void setTotalCatches(int totalCatches) {
		this.totalCatches = totalCatches;
	}

	public float getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(float strikeRate) {
		this.strikeRate = strikeRate;
	}

	@Override
	public String toString() {
		return "PlayerSeason [totalRuns=" + totalRuns + ", totalWickets=" + totalWickets + "]";
	}

}
