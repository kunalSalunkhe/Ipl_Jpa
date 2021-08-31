package com.entlogics.iplapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entlogics.iplapp.models.PlayerTeam;
import com.entlogics.iplapp.models.Team;
import com.entlogics.iplapp.models.TeamMatch;
import com.entlogics.iplapp.repository.ITeamRepository;

@Service
public class TeamService implements ITeamService {

	ITeamRepository teamRepo;

	@Autowired
	public void setTeamRepo(ITeamRepository teamRepo) {
		this.teamRepo = teamRepo;
	}

	@Override
	public void createTeam(Team team) {
		System.out.println("Inside TeamService createTeam()");
		teamRepo.createTeam(team);
	}

	@Override
	public Team getTeam(int teamId) {
		System.out.println("Inside TeamService getTeam()");
		return teamRepo.findTeam(teamId);
	}

	@Override
	public List<PlayerTeam> getPlayersOfTeamInSeason(int teamId, int seasonId) {
		System.out.println("Inside TeamService getPlayersOfTeamInSeason()");
		return teamRepo.findPlayersOfTeamInSeason(teamId, seasonId);
	}

	@Override
	public List<TeamMatch> getMatchesOfTeamInSeason(int teamId, int seasonId) {
		System.out.println("Inside TeamService getMatchesOfTeamInSeason()");
		return teamRepo.findMatchessOfTeamInSeason(teamId, seasonId);
	}

}
