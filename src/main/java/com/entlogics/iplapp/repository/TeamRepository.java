package com.entlogics.iplapp.repository;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.models.Match;
import com.entlogics.iplapp.models.Player;
import com.entlogics.iplapp.models.PlayerMatch;
import com.entlogics.iplapp.models.PlayerSeason;
import com.entlogics.iplapp.models.PlayerTeam;
import com.entlogics.iplapp.models.Season;
import com.entlogics.iplapp.models.Team;
import com.entlogics.iplapp.models.TeamMatch;
import com.entlogics.iplapp.models.TeamSeason;

//This class will fetch data of Team object from database
@Repository
@Component
public class TeamRepository implements ITeamRepository {

	SessionFactory factory;

	public TeamRepository() {
		super();
	}

	// Injecting SessionFactory by setter injection
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	// method for adding a new team in database
	@Override
	public void createTeam(Team team) {
		System.out.println("Inside TeamRepository createTeam()");
		Session session = factory.openSession();

		session.beginTransaction();

		// getting last entry of list of team for adding a serial number(teamno)
		List<Team> teams = session.createQuery("from Team t").getResultList();
		int teamNo = teams.size();
		team.setTeamNo(teamNo + 1);

		// adding team in database
		session.save(team);

		session.getTransaction().commit();

		// session.close();
	}

	// for finding the details of a team
	@Override
	public Team findTeam(int teamId) {
		System.out.println("Inside TeamRepository findTeam()");
		Session session = factory.openSession();

		Team team = session.get(Team.class, teamId);

		return team;
	}

	// for getting list of players played in particular team in particular season
	public List<PlayerTeam> findPlayersOfTeamInSeason(int teamId, int seasonId) {
		System.out.println("Inside TeamRepository findPlayersOfTeamInSeason()");
		Session session = factory.openSession();

		session.beginTransaction();

		// Getting PlayerTeam list with given teamId and seasonId
		List<PlayerTeam> players = session
				.createQuery("from PlayerTeam p where p.t.teamId = " + teamId + " and p.s.seasonId = " + seasonId + "")
				.getResultList();

		// session.close();

		return players;

	}

	// for getting list of players played in particular team in particular season
	public List<TeamMatch> findMatchessOfTeamInSeason(int teamId, int seasonId) {
		Session session = factory.openSession();

		session.beginTransaction();

		List<TeamMatch> matches = session.createQuery(
				"from TeamMatch t where t.t1.teamId = " + teamId + " and t.m.season.seasonId = " + seasonId + "")
				.getResultList();

		return matches;

	}

}
