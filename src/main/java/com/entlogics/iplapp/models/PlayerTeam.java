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
@Table(name = "lt_player_team")
@IdClass(PlayerTeam.class)
public class PlayerTeam implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "playerID")
	private Player p;

	@Id
	@ManyToOne
	@JoinColumn(name = "teamID")
	private Team t;

	@Column(name = "noOfMatches")
	private int noOfMatchesPlayed;

	@ManyToOne
	@JoinColumn(name = "seasonID")
	private Season s;

	public PlayerTeam() {

	}

	public PlayerTeam(Player p, Team t) {
		super();
		this.p = p;
		this.t = t;
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public Team getT() {
		return t;
	}

	public void setT(Team t) {
		this.t = t;
	}

	public int getNoOfMatchesPlayed() {
		return noOfMatchesPlayed;
	}

	public void setNoOfMatchesPlayed(int noOfMatchesPlayed) {
		this.noOfMatchesPlayed = noOfMatchesPlayed;
	}

	public Season getS() {
		return s;
	}

	public void setS(Season s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "PlayerTeam [p=" + p + ", t=" + t + ", noOfMatchesPlayed=" + noOfMatchesPlayed + ", s=" + s + "]";
	}

}
