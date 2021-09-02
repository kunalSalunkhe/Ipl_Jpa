package com.entlogics.iplapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.models.Match;
import com.entlogics.iplapp.models.Player;
import com.entlogics.iplapp.models.PlayerSeason;
import com.entlogics.iplapp.models.Season;
import com.entlogics.iplapp.models.Team;
import com.entlogics.iplapp.models.TeamSeason;

/*
 * this class is fetching the data from database according to methods specified
 */
@Repository
@Component
public class SeasonRepository implements ISeasonRepository {

	// create entityManagerFactory to connect with database
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPADemo");

	public SeasonRepository() {
		super();
	}

	/*
	 * Find all seasons of IPL from database
	 */
	@Override
	public List<Season> findAllSeasons() {

		System.out.println("Inside SeasonRepository findAllSeasons()");

		// get entityManager from factory
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		// get list of seasons
		List<Season> seasons = entityManager.createNativeQuery("select * from dt_season", Season.class).getResultList();

		entityManager.close();

		return seasons;
	}

	/*
	 * Season Object by id from database
	 */
	@Override
	public Season findSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findSeason()");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		Season season = entityManager.find(Season.class, seasonId);

		entityManager.close();

		return season;
	}

	/*
	 * find all team of Season by Id from database
	 */

	@Override
	public List<TeamSeason> findAllTeamsOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllTeamsOfSeason()");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		// Creating list of TeamSeason
		// getting list of TeamSeason from database by seasonId
		List<TeamSeason> teams = entityManager
				.createNativeQuery("select * from lt_team_Season where seasonID = :seasonID", TeamSeason.class)
				.setParameter("seasonID", seasonId).getResultList();

		entityManager.close();

		return teams;
	}

	/*
	 * find all players of Season by Id from database
	 */
	@Override
	public List<PlayerSeason> findAllPlayersOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllPlayersOfSeason()");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		// Creating list of PlayerSeason
		// getting list of PlayerSeason from database by seasonId
		List<PlayerSeason> players = entityManager
				.createNativeQuery("select * from lt_player_season where seasonID = :seasonID", PlayerSeason.class)
				.setParameter("seasonID", seasonId).getResultList();

		entityManager.close();

		return players;
	}

	/*
	 * find all matches of Season by Id from database
	 */
	@Override
	public List<Match> findAllMatchesOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllMatchesOfSeason()");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		// Creating list of Match
		// getting list of Match from database by seasonId
		List<Match> matches = entityManager
				.createNativeQuery("select * from dt_match where seasonID = :seasonID", Match.class)
				.setParameter("seasonID", seasonId).getResultList();

		return matches;
	}

	/*
	 * find all awards of Season by Id from database iterate over a match to get it
	 * award hence return this award list
	 */

	@Override
	public List<Award> findAllAwardsOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllAwardsSeason()");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		// Creating list of Matches
		// getting list of matches from database by seasonId
		List<Match> matches = entityManager
				.createNativeQuery("select * from dt_match where seasonID = :seasonID", Match.class)
				.setParameter("seasonID", seasonId).getResultList();

		// Creating award list
		List<Award> totalAwards = new ArrayList<Award>();

		// Iterating over matches to get awards of each match
		ListIterator litr = matches.listIterator();

		while (litr.hasNext()) {

			Match match = (Match) litr.next();

			List<Award> awardsOfMatch = match.getAwards();

			// iterate over awardOfMatch and add award one by one in totalAwards

			ListIterator alitr = awardsOfMatch.listIterator();

			while (alitr.hasNext()) {

				Award award = (Award) alitr.next();

				totalAwards.add(award);

			}

		}

		return totalAwards;
	}

	/*
	 * get a new season object and save it in session
	 */
	@Override
	public void createSeason(Season season) {
		System.out.println("Inside SeasonRepository createSeason()");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(season);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	/*
	 * get Season by seasonId and then edit it and save again
	 */
	@Override
	public void editSeason(Season season) {
		System.out.println("Inside SeasonRepository editSeason()");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(season);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	@Override
	public void deleteSeason(int seasonId) {
		System.out.println("Inside SeasonRepository deleteSeason()");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		Season season = entityManager.find(Season.class, seasonId);

		entityManager.remove(season);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

}
