package com.entlogics.iplapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	SessionFactory factory;

	public SeasonRepository() {
		super();
	}

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	/*
	 * Find all seasons of IPL from database
	 */
	@Override
	public List<Season> findAllSeasons() {

		System.out.println("Inside SeasonRepository findAllSeasons()");

		// get session from factory
		Session session = factory.getSessionFactory().openSession();
		// initialize session, opening portal to connect with database
		session.beginTransaction();

		// getting season list from database
		List<Season> seasons = session.createQuery("from Season s").getResultList();

		session.getTransaction().commit();

		// returning this list
		return seasons;
	}

	/*
	 * Season Object by id from database
	 */
	@Override
	public Season findSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findSeason()");

		Session session = factory.getSessionFactory().openSession();

		session.beginTransaction();
		Season s = session.get(Season.class, seasonId);

		return s;
	}

	/*
	 * find all team of Season by Id from database
	 */

	@Override
	public List<Team> findAllTeamsOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllTeamsOfSeason()");

		// get session from factory
		Session session = factory.getSessionFactory().openSession();

		// initialize session, opening portal to connect with database
		session.beginTransaction();

		Season season = session.get(Season.class, seasonId);

		// Creating list of TeamSeason
		// getting list of TeamSeason from database by seasonId
		List<TeamSeason> teamSeasons = season.getSeasonTeams();

		// Creating list of teams
		List<Team> teams = new ArrayList<Team>();

		// Iterate over TeamSeason
		ListIterator litr = teamSeasons.listIterator();

		while (litr.hasNext()) {

			TeamSeason tseason = (TeamSeason) litr.next();

			Team team = tseason.getTeam();

			teams.add(team);
		}

		return teams;
	}

	/*
	 * find all players of Season by Id from database
	 */
	@Override
	public List<Player> findAllPlayersOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllPlayersOfSeason()");

		// get session from factory
		Session session = factory.getSessionFactory().openSession();

		// initialize session, opening portal to connect with database
		session.beginTransaction();

		Season season = session.get(Season.class, seasonId);

		// Creating list of PlayerSeason
		// getting list of PlayerSeason from database by seasonId
		List<PlayerSeason> playerSeasons = season.getSeasonPlayers();

		// Creating list of players
		List<Player> players = new ArrayList<Player>();

		// Iterate over TeamSeason
		ListIterator litr = playerSeasons.listIterator();

		while (litr.hasNext()) {

			PlayerSeason pseason = (PlayerSeason) litr.next();

			Player player = pseason.getPlayer();

			players.add(player);
		}

		return players;
	}

	/*
	 * find all matches of Season by Id from database
	 */
	@Override
	public List<Match> findAllMatchesOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllMatchesOfSeason()");

		// initialize session, opening portal to connect with database
		Session session = factory.getSessionFactory().openSession();

		Season season = session.get(Season.class, seasonId);

		// Creating list of Matches
		// getting list of matches from database by seasonId
		List<Match> matches = season.getMatches();

		return matches;
	}

	/*
	 * find all matches of Season by Id from database iterate over a match to get it
	 * award hence return this award list
	 */

	@Override
	public List<Award> findAllAwardsOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllAwardsSeason()");

		Session session = factory.getSessionFactory().openSession();

		Season season = session.get(Season.class, seasonId);

		// Creating list of Matches
		// getting list of matches from database by seasonId
		List<Match> matches = season.getMatches();

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

		Session session = factory.getSessionFactory().openSession();

		session.beginTransaction();

		session.save(season);

	}

	/*
	 * get Season by seasonId and then edit it and save again
	 */
	@Override
	public void editSeason(Season season) {
		System.out.println("Inside SeasonRepository editSeason()");
		Session session = factory.getSessionFactory().openSession();

		session.beginTransaction();

		session.update(season);
		session.getTransaction().commit();

	}

	@Override
	public void deleteSeason(int seasonId) {
		System.out.println("Inside SeasonRepository deleteSeason()");

		Session session = factory.getSessionFactory().openSession();

		session.beginTransaction();

		session.delete(session.get(Season.class, seasonId));

		session.getTransaction().commit();
	}

}
