package com.entlogics.iplapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entlogics.iplapp.models.PlayerTeam;
import com.entlogics.iplapp.models.Team;
import com.entlogics.iplapp.models.TeamMatch;
import com.entlogics.iplapp.services.ITeamService;

@Controller
public class TeamController {

	ITeamService iTeamService;

	@Autowired
	public void setiTeamService(ITeamService iTeamService) {
		this.iTeamService = iTeamService;
	}

	// Get the Team Form
	@RequestMapping("/TeamForm")
	String newTeamForm(Model model) {
		System.out.println("Inside TeamController newTeamForm()");

		// Adding empty Team object to view page
		model.addAttribute("team", new Team());

		return "addTeamForm";
	}

	// After submitting the form, giving newly created team id
	@RequestMapping("/teamAdded")
	String createNewTeam(Model model, @ModelAttribute("team") Team team) {
		System.out.println("Inside TeamController createNewTeam()");

		// adding team to TeamService
		iTeamService.createTeam(team);

		// adding that Team Object in view page to print new award id
		model.addAttribute("team", team);

		return "teamAdded";
	}

	// Get Details of any team
	@RequestMapping("/teams/{teamId}")
	String getTeam(Model model, @PathVariable int teamId) {

		System.out.println("Inside TeamController getTeam()");

		// getting Team objetct from TeamService
		Team team = iTeamService.getTeam(teamId);
		System.out.println("Team Object : " + team);

		// Adding that team object in view page for printing it
		model.addAttribute("team", team);

		return "teamDetails";
	}

	// Get players of a team in a season
	@RequestMapping("/teams/{teamId}/seasons/{seasonId}/players")
	String getPlayersOfTeamInSeason(Model model, @PathVariable int teamId, @PathVariable int seasonId) {

		System.out.println("Inside TeamController getPlayersOfTeamInSeason()");

		// get list of players from team season
		List<PlayerTeam> players = iTeamService.getPlayersOfTeamInSeason(teamId, seasonId);
		System.out.println("Player List : " + players.size() + "\n" + players);

		// adding list of players in view page
		model.addAttribute("players", players);

		return "playersOfTeam";
	}

	// Get matches of a team in a season
	@RequestMapping("/teams/{teamId}/seasons/{seasonId}/matches")
	String getMatchesOfTeamInSeason(Model model, @PathVariable int teamId, @PathVariable int seasonId) {

		System.out.println("Inside TeamController getMatchesOfTeamInSeason()");

		// get list of matches from team season
		List<TeamMatch> matches = iTeamService.getMatchesOfTeamInSeason(teamId, seasonId);
		System.out.println("Match List : " + matches.size() + "\n" + matches);

		// adding list of matches in view page
		model.addAttribute("matches", matches);

		return "matchesOfTeam";
	}

}
