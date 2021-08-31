package com.entlogics.iplapp.repository;

import java.util.List;

import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.models.Match;
import com.entlogics.iplapp.models.Player;
import com.entlogics.iplapp.models.Season;
import com.entlogics.iplapp.models.Team;

public interface ISeasonRepository {

	public List<Season> findAllSeasons();

	public Season findSeason(int seasonId);

	public List<Team> findAllTeamsOfSeason(int seasonId);

	public List<Player> findAllPlayersOfSeason(int seasonId);

	public List<Match> findAllMatchesOfSeason(int seasonId);

	public List<Award> findAllAwardsOfSeason(int seasonId);

	public void createSeason(Season season);

	public void editSeason(Season season);

	public void deleteSeason(int seasonId);

}
