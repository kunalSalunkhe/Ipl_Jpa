package com.entlogics.iplapp.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lt_team_Season")
@IdClass(TeamSeason.class)
public class TeamSeason implements Serializable {

	@Id
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "teamID")
	private Team team;

	@Id
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "seasonID")
	private Season season;

	@OneToOne
	@JoinColumn(name = "captainID")
	private Player captain;

	@Column(name = "tRank")
	private String rank;

	@OneToOne
	@JoinColumn(name = "highestRunsScorer")
	private Player highestRunsScorer;

	@OneToOne
	@JoinColumn(name = "highestWicketTaker")
	private Player highestWicketTaker;

	public TeamSeason() {
		
	}
	
	public TeamSeason(Team team, Season season) {
		super();
		this.team = team;
		this.season = season;
	}

	public void setTeamSeasonProperties(Player cap, String rank, Player hrs, Player hwt) {

		this.setCaptain(cap);
		this.setRank(rank);
		this.setHighestRunsScorer(hwt);
		this.setHighestWicketTaker(hwt);

	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Player getCaptain() {
		return captain;
	}

	public void setCaptain(Player captain) {
		this.captain = captain;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Player getHighestRunsScorer() {
		return highestRunsScorer;
	}

	public void setHighestRunsScorer(Player highestRunsScorer) {
		this.highestRunsScorer = highestRunsScorer;
	}

	public Player getHighestWicketTaker() {
		return highestWicketTaker;
	}

	public void setHighestWicketTaker(Player highestWicketTaker) {
		this.highestWicketTaker = highestWicketTaker;
	}

	@Override
	public String toString() {
		return "TeamSeason [team=" + team + ", captain=" + captain + ", rank=" + rank + ", highestRunsScorer="
				+ highestRunsScorer + ", highestWicketTaker=" + highestWicketTaker + "]";
	}
}
