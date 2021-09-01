package com.entlogics.iplapp.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.models.Match;
import com.entlogics.iplapp.models.Player;
import com.entlogics.iplapp.models.Season;
import com.entlogics.iplapp.models.Team;

/*
 * this class is fetching the data from database according to methods specified
 */
@Repository
@Component
public class SeasonRepository implements ISeasonRepository {

	public SeasonRepository() {
		super();
	}

	/*
	 * Find all seasons of IPL from database
	 */
	@Override
	public List<Season> findAllSeasons() {

		System.out.println("Inside SeasonRepository findAllSeasons()");

		return null;
	}

	/*
	 * Season Object by id from database
	 */
	@Override
	public Season findSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findSeason()");

		return null;
	}

	/*
	 * find all team of Season by Id from database
	 */

	@Override
	public List<Team> findAllTeamsOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllTeamsOfSeason()");

		return null;
	}

	/*
	 * find all players of Season by Id from database
	 */
	@Override
	public List<Player> findAllPlayersOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllPlayersOfSeason()");

		return null;
	}

	/*
	 * find all matches of Season by Id from database
	 */
	@Override
	public List<Match> findAllMatchesOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllMatchesOfSeason()");

		return null;
	}

	/*
	 * find all matches of Season by Id from database iterate over a match to get it
	 * award hence return this award list
	 */

	@Override
	public List<Award> findAllAwardsOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllAwardsSeason()");

		return null;
	}

	/*
	 * get a new season object and save it in session
	 */
	@Override
	public void createSeason(Season season) {
		System.out.println("Inside SeasonRepository createSeason()");

	}

	/*
	 * get Season by seasonId and then edit it and save again
	 */
	@Override
	public void editSeason(Season season) {
		System.out.println("Inside SeasonRepository editSeason()");

	}

	@Override
	public void deleteSeason(int seasonId) {
		System.out.println("Inside SeasonRepository deleteSeason()");

	}

}
