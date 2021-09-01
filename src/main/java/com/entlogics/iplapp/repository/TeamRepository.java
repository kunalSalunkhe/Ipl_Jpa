package com.entlogics.iplapp.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.entlogics.iplapp.models.PlayerTeam;
import com.entlogics.iplapp.models.Team;
import com.entlogics.iplapp.models.TeamMatch;

//This class will fetch data of Team object from database
@Repository
@Component
public class TeamRepository implements ITeamRepository {

	public TeamRepository() {
		super();
	}

	// method for adding a new team in database
	@Override
	public void createTeam(Team team) {
		System.out.println("Inside TeamRepository createTeam()");

	}

	// for finding the details of a team
	@Override
	public Team findTeam(int teamId) {
		System.out.println("Inside TeamRepository findTeam()");

		return null;
	}

	// for getting list of players played in particular team in particular season
	public List<PlayerTeam> findPlayersOfTeamInSeason(int teamId, int seasonId) {
		System.out.println("Inside TeamRepository findPlayersOfTeamInSeason()");

		return null;

	}

	// for getting list of players played in particular team in particular season
	public List<TeamMatch> findMatchessOfTeamInSeason(int teamId, int seasonId) {

		return null;

	}

}
