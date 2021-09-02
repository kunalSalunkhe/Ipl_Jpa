package com.entlogics.iplapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.entlogics.iplapp.models.PlayerTeam;
import com.entlogics.iplapp.models.Team;
import com.entlogics.iplapp.models.TeamMatch;

//This class will fetch data of Team object from database
@Repository
@Component
public class TeamRepository implements ITeamRepository {

	// create entityManagerFactory to connect with database
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPADemo");

	public TeamRepository() {
		super();
	}

	// method for adding a new team in database
	@Override
	public void createTeam(Team team) {
		System.out.println("Inside TeamRepository createTeam()");

		// get entityManager from factory
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		// getting last entry of list of team for adding a serial number(teamno)
		List<Team> teams = entityManager.createQuery("from Team t").getResultList();
		int teamNo = teams.size();
		team.setTeamNo(teamNo + 1);

		// saving team in database
		entityManager.persist(team);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

	// for finding the details of a team
	@Override
	public Team findTeam(int teamId) {
		System.out.println("Inside TeamRepository findTeam()");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		// get team from database
		Team team = entityManager.find(Team.class, teamId);

		entityManager.close();

		return team;
	}

	// for getting list of players played in particular team in particular season
	public List<PlayerTeam> findPlayersOfTeamInSeason(int teamId, int seasonId) {
		System.out.println("Inside TeamRepository findPlayersOfTeamInSeason()");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		// Getting PlayerTeam list with given teamId and seasonId
		List<PlayerTeam> players = entityManager
				.createNativeQuery("select * from lt_player_team where teamID = :teamID and seasonID = :seasonID",
						PlayerTeam.class)
				.setParameter("teamID", teamId).setParameter("seasonID", seasonId).getResultList();

		entityManager.close();

		return players;

	}

	// for getting list of players played in particular team in particular season
	public List<TeamMatch> findMatchessOfTeamInSeason(int teamId, int seasonId) {

		System.out.println("Inside TeamRepository findMatchesOfTeamInSeason()");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		// Getting TeamMatch list with given teamId and seasonId
		List<TeamMatch> matches = entityManager.createQuery(
				"from TeamMatch t where t.t1.teamId = " + teamId + " and t.m.season.seasonId = " + seasonId + "")
				.getResultList();

		entityManager.close();

		return matches;

	}

}
