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
import javax.persistence.Table;

@Entity
@Table(name = "dt_player")
public class Player {

	@Id
	@Column(name = "playerID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;

	@Column(name = "pName")
	private String playerName;

	@Column(name = "pType")
	private String type;

	@Column(name = "age")
	private int age;

	@OneToMany(mappedBy = "player", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PlayerSeason> playerSeasons;

	@OneToMany(mappedBy = "p", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PlayerTeam> playerTeams;

	@OneToMany(mappedBy = "player", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PlayerMatch> playerMatches;

	@OneToMany(mappedBy = "winner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Award> awardsWon;

	public Player(int playerId, String playerName, String type) {
		super();

		this.playerId = playerId;
		this.playerName = playerName;
		this.type = type;
	}

	public Player() {

	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<PlayerSeason> getPlayerSeasons() {
		return playerSeasons;
	}

	public void setPlayerSeasons(List<PlayerSeason> playerSeasons) {
		this.playerSeasons = playerSeasons;
	}

	public List<PlayerTeam> getPlayerTeams() {
		return playerTeams;
	}

	public void setPlayerTeams(List<PlayerTeam> playerTeams) {
		this.playerTeams = playerTeams;
	}

	public List<PlayerMatch> getPlayerMatches() {
		return playerMatches;
	}

	public void setPlayerMatches(List<PlayerMatch> playerMatches) {
		this.playerMatches = playerMatches;
	}

	public List<Award> getAwardsWon() {
		return awardsWon;
	}

	public void setAwardsWon(List<Award> awardsWon) {
		this.awardsWon = awardsWon;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + "type=" + type + "]";
	}

}
