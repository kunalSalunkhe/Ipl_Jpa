package com.entlogics.iplapp.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dt_team")
public class Team {

	@Id
	@Column(name = "teamID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teamId;

	@Column(name = "teamName")
	private String teamName;

	@Column(name = "ownerName")
	private String ownerName;

	@Column(name = "team_no")
	private int teamNo;

	@OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TeamSeason> teamSeasons;

	@OneToMany(mappedBy = "t", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PlayerTeam> teamPlayers;

	@OneToMany(mappedBy = "t1", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TeamMatch> teamMatches;

	public Team() {

	}

	public Team(String teamName, String ownerName) {
		super();
		this.teamName = teamName;
		this.ownerName = ownerName;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getTeamNo() {
		return teamNo;
	}

	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}

	public List<TeamSeason> getTeamSeasons() {
		return teamSeasons;
	}

	public void setTeamSeasons(List<TeamSeason> teamSeasons) {
		this.teamSeasons = teamSeasons;
	}

	public List<PlayerTeam> getTeamPlayers() {
		return teamPlayers;
	}

	public void setTeamPlayers(List<PlayerTeam> teamPlayers) {
		this.teamPlayers = teamPlayers;
	}

	public List<TeamMatch> getTeamMatches() {
		return teamMatches;
	}

	public void setTeamMatches(List<TeamMatch> teamMatches) {
		this.teamMatches = teamMatches;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", ownerName=" + ownerName + "]";
	}

}
