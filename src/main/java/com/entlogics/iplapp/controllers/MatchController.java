package com.entlogics.iplapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entlogics.iplapp.models.Match;
import com.entlogics.iplapp.models.Season;
import com.entlogics.iplapp.services.IMatchService;
import com.entlogics.iplapp.services.ISeasonService;

@Controller
public class MatchController {

	IMatchService iMatchService;

	// for getting season list
	ISeasonService iSeasonService;

	@Autowired
	public void setiMatchService(IMatchService iMatchService) {
		this.iMatchService = iMatchService;
	}

	@Autowired
	public void setiSeasonService(ISeasonService iSeasonService) {
		this.iSeasonService = iSeasonService;
	}

	@RequestMapping("/matchForm")
	String matchForm(Model model) {

		System.out.println("Inside MatchController matchForm()");

		List<Season> seasons = iSeasonService.getAllSeasons();

		System.out.println(seasons);

		model.addAttribute("match", new Match());
		model.addAttribute("seasonList", seasons);

		return "matchForm";
	}

	@RequestMapping("/addMatch")
	String createMatch(Model model, @ModelAttribute("match") Match match) {

		System.out.println("Inside MatchController createMatch()");

		System.out.println(match.getSeason().getSeasonName());
		
		// adding match using MatchService
		iMatchService.createMatch(match);

		// add this object in view to print newly created match id
		model.addAttribute("match", match);

		return "matchAdded";
	}

}
