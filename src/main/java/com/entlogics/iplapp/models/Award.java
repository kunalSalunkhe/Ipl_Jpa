package com.entlogics.iplapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dt_award")
public class Award {

	@Id
	@Column(name = "awardId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int awardId;

	@Column(name = "awardName")
	private String awardName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "winnerID")
	private Player winner;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matchId")
	private Match match;

	public Award() {

	}

	public Award(int awardId, String awardName, Match match) {
		super();
		this.awardId = awardId;
		this.awardName = awardName;
		this.match = match;
	}

	public int getAwardId() {
		return awardId;
	}

	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	@Override
	public String toString() {
		return "Award [awardId=" + awardId + ", awardName=" + awardName + ", Winner= " + winner.getPlayerName() + "]";
	}
}