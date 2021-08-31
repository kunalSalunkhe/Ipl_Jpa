package com.entlogics.iplapp.repository;

import java.util.List;

import com.entlogics.iplapp.models.PlayerTeam;
import com.entlogics.iplapp.models.Team;
import com.entlogics.iplapp.models.TeamMatch;

public interface ITeamRepository {

	public void createTeam(Team team);

	public Team findTeam(int teamId);

	public List<PlayerTeam> findPlayersOfTeamInSeason(int teamId, int seasonId);

	public List<TeamMatch> findMatchessOfTeamInSeason(int teamId, int seasonId);
}
