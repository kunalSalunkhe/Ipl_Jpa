package com.entlogics.iplapp.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dt_season")
public class Season {

	@Id
	@Column(name = "seasonID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seasonId;

	@Column(name = "sName")
	private String seasonName;

	@Column(name = "seasonNo")
	private Integer yearOfSeason;

	@OneToMany(mappedBy = "season", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PlayerSeason> seasonPlayers;

	@OneToMany(mappedBy = "season", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Match> matches;

	@OneToMany(mappedBy = "season", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TeamSeason> seasonTeams;

	public Season(String seasonName, Integer yearOfSeason) {
		super();
		this.seasonName = seasonName;
		this.yearOfSeason = yearOfSeason;
	}

	public Season() {
		super();
	}

	public int getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public Integer getYearOfSeason() {
		return yearOfSeason;
	}

	public void setYearOfSeason(Integer yearOfSeason) {
		this.yearOfSeason = yearOfSeason;
	}

	public List<PlayerSeason> getSeasonPlayers() {
		return seasonPlayers;
	}

	public void setSeasonPlayers(List<PlayerSeason> seasonPlayers) {
		this.seasonPlayers = seasonPlayers;
	}

	public List<TeamSeason> getSeasonTeams() {
		return seasonTeams;
	}

	public void setSeasonTeams(List<TeamSeason> seasonTeams) {
		this.seasonTeams = seasonTeams;
	}

	@Override
	public String toString() {
		return "Season [seasonId=" + seasonId + ", seasonName=" + seasonName + ", yearOfSeason=" + yearOfSeason + "]";
	}

}