package com.entlogics.iplapp.services;

import java.util.List;

import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.models.Match;
import com.entlogics.iplapp.models.Player;
import com.entlogics.iplapp.models.Season;
import com.entlogics.iplapp.models.Team;

public interface ISeasonService {

	// public void createDatabase();

	public List<Season> getAllSeasons();

	public Season getSeason(int seasonId);

	public List<Team> getAllTeamsOfSeason(int seasonId);

	public List<Player> getAllPlayersOfSeason(int seasonId);

	public List<Match> getAllMatchesOfSeason(int seasonId);

	public List<Award> getAllAwardsOfSeason(int seasonId);

	public int createSeason(Season season);

	public void editSeason(Season season, int seasonId);

	public void deleteSeason(int seasonId);

}