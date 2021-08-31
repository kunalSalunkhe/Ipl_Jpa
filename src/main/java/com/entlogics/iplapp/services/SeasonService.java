package com.entlogics.iplapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.models.Match;
import com.entlogics.iplapp.models.Player;
import com.entlogics.iplapp.models.Season;
import com.entlogics.iplapp.models.Team;
import com.entlogics.iplapp.repository.ISeasonRepository;

@Service
public class SeasonService implements ISeasonService {

	public static List<Season> listOfSeasons = new ArrayList<Season>();

	public ISeasonRepository seasonRepo;

	@Autowired
	public void setSeasonRepo(ISeasonRepository seasonRepo) {
		this.seasonRepo = seasonRepo;
	}

	@Override
	public List<Season> getAllSeasons() {

		return seasonRepo.findAllSeasons();
	}

	@Override
	public Season getSeason(int seasonId) {
		System.out.println("Inside SeasonService getSeason() method");

		return seasonRepo.findSeason(seasonId);
	}

	@Override
	public List<Team> getAllTeamsOfSeason(int seasonId) {
		System.out.println("Inside SeasonService getAllTeamsOfSeason() method");

		return seasonRepo.findAllTeamsOfSeason(seasonId);
	}

	@Override
	public List<Player> getAllPlayersOfSeason(int seasonId) {

		System.out.println("Inside SeasonService getAllPlayerOfSeason() method");

		return seasonRepo.findAllPlayersOfSeason(seasonId);
	}

	@Override
	public List<Match> getAllMatchesOfSeason(int seasonId) {

		System.out.println("Inside SeasonService getAllMatchesOfSeason() method");

		return seasonRepo.findAllMatchesOfSeason(seasonId);
	}

	@Override
	public List<Award> getAllAwardsOfSeason(int seasonId) {

		System.out.println("Inside SeasonService getAllAwardsSeason() method");

		return seasonRepo.findAllAwardsOfSeason(seasonId);
	}

	@Override
	public int createSeason(Season season) {
		System.out.println("Inside SeasonService createSeason method");

		seasonRepo.createSeason(season);

		return 0;
	}

	@Override
	public void editSeason(Season season, int seasonId) {

		System.out.println("Inside SeasonService editSeason() method");

		seasonRepo.editSeason(season);

		System.out.println("Season after editing : " + season);

	}

	@Override
	public void deleteSeason(int seasonId) {

		System.out.println("Inside SeasonService deleteSeason() method" + seasonId);

		seasonRepo.deleteSeason(seasonId);
	}
}
