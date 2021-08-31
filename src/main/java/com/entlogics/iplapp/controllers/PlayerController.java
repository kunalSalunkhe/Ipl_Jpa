package com.entlogics.iplapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.models.Match;
import com.entlogics.iplapp.models.Player;
import com.entlogics.iplapp.models.PlayerMatch;
import com.entlogics.iplapp.services.IPlayerService;

@Controller
@RequestMapping("/players")
public class PlayerController {

	IPlayerService iPlayerService;

	@Autowired
	public void setiPlayerService(IPlayerService iPlayerService) {
		this.iPlayerService = iPlayerService;
	}

	// form for creating new player
	@RequestMapping("/playerForm")
	String playerForm(Model model) {

		System.out.println("Inside PlayerController playerForm()");

		model.addAttribute("player", new Player());

		return "playerForm";
	}

	// form for creating new player
	@RequestMapping("/addPlayer")
	String playerForm(Model model, @ModelAttribute("player") Player player) {

		System.out.println("Inside PlayerController addPlayer()");

		// adding new player using PlayerService
		iPlayerService.createPlayer(player);

		// adding this player to view page to print newly created player id
		model.addAttribute("player", player);

		return "playerAdded";
	}

	// get details of player
	@RequestMapping("/{playerId}")
	String getPlayer(Model model, @PathVariable int playerId) {

		System.out.println("Inside PlayerController getPlayer()");

		// getting Player object from PlayerService
		Player player = iPlayerService.getPlayer(playerId);
		System.out.println("Player Objetct : " + player);

		// add this player in view page to print it
		model.addAttribute("player", player);

		return "playerDetails";
	}

	// get Awards Of Player
	@RequestMapping("/{playerId}/awards")
	String getAwardsOfPlayer(Model model, @PathVariable int playerId) {

		System.out.println("Inside PlayerController getAwardsOfPlayer()");

		// getting Awards of Player from PlayerService
		List<Award> awards = iPlayerService.getAwardsOfPlayer(playerId);
		System.out.println("Award List : " + awards.size() + "\n" + awards);

		// add this award list in view page to print it
		model.addAttribute("awards", awards);

		return "playerAwards";
	}

	// get Matches Of Player
	@RequestMapping("/{playerId}/matches")
	String getMatchesOfPlayer(Model model, @PathVariable int playerId) {

		System.out.println("Inside PlayerController getMatchesOfPlayer()");

		// getting Matches of Player from PlayerService
		List<PlayerMatch> playerMatches = iPlayerService.getMatchesOfPlayer(playerId);
		System.out.println("Award List : " + playerMatches.size() + "\n" + playerMatches);

		// add this award list in view page to print it
		model.addAttribute("playerMatches", playerMatches);

		return "playerMatches";
	}

}
