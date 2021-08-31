package com.entlogics.iplapp.controllers;

import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.models.Match;
import com.entlogics.iplapp.models.Player;
import com.entlogics.iplapp.models.Season;
import com.entlogics.iplapp.models.Team;
import com.entlogics.iplapp.services.ISeasonService;

@Controller
@ComponentScan
public class SeasonController {

	ISeasonService iSeasonService;

	@Autowired
	public void setiSeasonService(ISeasonService iSeasonService) {
		this.iSeasonService = iSeasonService;
	}

	@RequestMapping("/seasons")
	String getAllSeasons(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("Inside SeasonController getAllSeasons method");

		// getting seasons from database
		List<Season> seasons = iSeasonService.getAllSeasons();

		ListIterator litr = seasons.listIterator();

		while (litr.hasNext()) {

			Season s = (Season) litr.next();

			System.out.println("Season Object is : " + s);
		}

		// adding season model in view
		model.addAttribute("seasonList", seasons);
		return "listSeasons";
	}

	@RequestMapping("/seasons/{seasonId}")
	String getSeason(HttpServletRequest request, HttpServletResponse response, Model model,
			@PathVariable int seasonId) {
		System.out.println("Inside SeasonController getSeason method");

		// Getting corresponding Season object from databse
		Season season = iSeasonService.getSeason(seasonId);

		System.out.println("Season Object : " + season);

		// adding season model in view
		model.addAttribute("season", season);
		return "seasonDetails";
	}

	@RequestMapping("/seasons/{seasonId}/teams")
	String getAllTeamsOfSeason(HttpServletRequest request, HttpServletResponse response, Model model,
			@PathVariable int seasonId) {
		System.out.println("Inside SeasonController getAllTeamsOfSeason method");

		// Getting List of teams of the given season
		List<Team> teams = iSeasonService.getAllTeamsOfSeason(seasonId);

		ListIterator litr = teams.listIterator();

		while (litr.hasNext()) {

			Team team = (Team) litr.next();

			System.out.println("Team Object is : " + team);
		}

		// adding season model in view
		model.addAttribute("seasonTeamList", teams);

		return "seasonTeams";
	}

	@RequestMapping("/seasons/{seasonId}/players")
	String getAllPlayersOfSeason(HttpServletRequest request, HttpServletResponse response, Model model,
			@PathVariable int seasonId) {
		System.out.println("Inside SeasonController getAllPlayersOfSeason method");

		// Getting the players of the given season
		List<Player> players = iSeasonService.getAllPlayersOfSeason(seasonId);

		ListIterator litr = players.listIterator();

		while (litr.hasNext()) {

			Player player = (Player) litr.next();

			System.out.println("Player Object is : " + player);
		}
		// adding season model in view
		model.addAttribute("seasonPlayerList", players);

		return "seasonPlayers";
	}

	@RequestMapping("/seasons/{seasonId}/matches")
	String getAllMatchesOfSeason(HttpServletRequest request, HttpServletResponse response, Model model,
			@PathVariable int seasonId) {
		System.out.println("Inside SeasonController getAllMatchesOfSeason method");

		// getting the matches of the given season from database
		List<Match> matches = iSeasonService.getAllMatchesOfSeason(seasonId);

		ListIterator litr = matches.listIterator();

		while (litr.hasNext()) {

			Match match = (Match) litr.next();

			System.out.println("Match Object is : " + match);
		}

		// adding season model in view
		model.addAttribute("seasonMatchList", matches);

		return "seasonMatches";
	}

	@RequestMapping("/seasons/{seasonId}/awards")
	String getAllAwardsOfSeason(HttpServletRequest request, HttpServletResponse response, Model model,
			@PathVariable int seasonId) {
		System.out.println("Inside SeasonController getAllAwardsOfSeason method");

		List<Award> awards = iSeasonService.getAllAwardsOfSeason(seasonId);

		ListIterator litr = awards.listIterator();

		while (litr.hasNext()) {

			Award award = (Award) litr.next();

			System.out.println("Award Object is : " + award);
		}

		// adding season model in view
		model.addAttribute("seasonAwardList", awards);

		return "seasonAwards";
	}

	// write method for preprocessing controller
	// add an Initbinber ... to convert trim input strings
	@InitBinder
	public void initBinder(WebDataBinder databinder) {

		// remove leading and trailing whitespaces from input Strings
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		databinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/seasons/seasonForm")
	public String newSeasonForm(Model model) {

		model.addAttribute("season", new Season());

		return "createSeason";
	}

	@RequestMapping("/seasons/seasons/add")
	String createSeason(Model model, @ModelAttribute("season") Season season) {

		System.out.println("Inside SeasonController createSeason method");

		// iSeasonService.createSeason(season);
		iSeasonService.createSeason(season);

		model.addAttribute("season", season);

		return "New-season";
	}

	@RequestMapping("/seasons/editForm/{seasonId}")
	public String newSeasonForm(Model model, @PathVariable int seasonId) {

		Season season = iSeasonService.getSeason(seasonId);

		System.out.println(season);

		model.addAttribute("season", season);

		return "editSeason";
	}

	@RequestMapping("/seasons/editForm/seasons/edit/{seasonId}")
	String editSeason(HttpServletRequest request, @ModelAttribute("season") Season season, @PathVariable int seasonId) {

		System.out.println("Inside SeasonController editSeason method");

		// send it to service class to save it
		iSeasonService.editSeason(season, seasonId);

		return "afterEdit";
	}

	@RequestMapping("/seasons/delete/{seasonId}")
	String deleteSeason(@PathVariable int seasonId) {

		System.out.println("Inside SeasonController deleteSeason method");

		iSeasonService.deleteSeason(seasonId);

		return "afterDelete";
	}

}
