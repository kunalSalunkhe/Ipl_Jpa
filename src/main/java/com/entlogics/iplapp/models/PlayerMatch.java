package com.entlogics.iplapp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lt_player_match")
@IdClass(PlayerMatch.class)
public class PlayerMatch implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "playerID")
	private Player player;

	@Id
	@ManyToOne
	@JoinColumn(name = "matchID")
	private Match match;

	@Column(name = "runScored")
	private int runsScored;

	@Column(name = "wicketsTaken")
	private int wicketsTaken;

	@Column(name = "strikeRate")
	private float strikeRate;

	public PlayerMatch() {
		super();

	}

	public PlayerMatch(Player player, Match match) {
		super();
		this.player = player;
		this.match = match;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public int getRunsScored() {
		return runsScored;
	}

	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	public float getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(float strikeRate) {
		this.strikeRate = strikeRate;
	}

}
