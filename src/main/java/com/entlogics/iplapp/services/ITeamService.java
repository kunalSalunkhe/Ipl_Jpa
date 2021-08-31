package com.entlogics.iplapp.services;

import java.util.List;

import com.entlogics.iplapp.models.PlayerTeam;
import com.entlogics.iplapp.models.Team;
import com.entlogics.iplapp.models.TeamMatch;

public interface ITeamService {

	public void createTeam(Team team);

	public Team getTeam(int teamId);

	public List<PlayerTeam> getPlayersOfTeamInSeason(int teamId, int seasonId);

	public List<TeamMatch> getMatchesOfTeamInSeason(int teamId, int seasonId);
}
