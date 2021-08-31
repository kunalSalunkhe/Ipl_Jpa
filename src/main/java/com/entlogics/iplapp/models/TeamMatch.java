package com.entlogics.iplapp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lt_team_matches")
public class TeamMatch implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_match_id")
	private int teamMatchId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matchID")
	private Match m;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team1ID")
	private Team t1;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team2ID")
	private Team t2;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "winner_id")
	private Team winnerTeam;

	@Column(name = "match_status")
	private String matchStatus;

	@Column(name = "team1_score")
	private int team1Score;

	@Column(name = "team2_score")
	private int team2Score;

	public TeamMatch() {

	}

	public TeamMatch(Team t1, Team t2, Match m) {
		super();
		this.t1 = t1;
		this.t2 = t2;
		this.m = m;
	}

	public Team getT1() {
		return t1;
	}

	public int getTeamMatchId() {
		return teamMatchId;
	}

	public void setTeamMatchId(int teamMatchId) {
		this.teamMatchId = teamMatchId;
	}

	public void setT1(Team t1) {
		this.t1 = t1;
	}

	public Team getT2() {
		return t2;
	}

	public void setT2(Team t2) {
		this.t2 = t2;
	}

	public Team getWinnerTeam() {
		return winnerTeam;
	}

	public void setWinnerTeam(Team winnerTeam) {
		this.winnerTeam = winnerTeam;
	}

	public Match getM() {
		return m;
	}

	public void setM(Match m) {
		this.m = m;
	}

	public String getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
	}

	public int getTeam1Score() {
		return team1Score;
	}

	public void setTeam1Score(int team1Score) {
		this.team1Score = team1Score;
	}

	public int getTeam2Score() {
		return team2Score;
	}

	public void setTeam2Score(int team2Score) {
		this.team2Score = team2Score;
	}

	@Override
	public String toString() {
		return "TeamMatch [m=" + m + ", matchStatus=" + matchStatus + ", team1Score=" + team1Score + ", team2Score="
				+ team2Score + "]";
	}

}
