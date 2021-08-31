package com.entlogics.iplapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.services.IAwardService;

@Controller
public class AwardController {

	IAwardService iAwardService;

	@Autowired
	public void setAwardService(IAwardService iAwardService) {
		this.iAwardService = iAwardService;
	}

	// get new award form
	@RequestMapping("/awardForm")
	String awardForm(Model model) {

		System.out.println("Inside AwardController awardForm()");

		model.addAttribute("award", new Award());

		return "awardForm";
	}

	// adding new award in database using Award Service
	@RequestMapping("/addAward")
	String createAward(Model model, @ModelAttribute("award") Award award) {

		// adding award by using AwardService
		iAwardService.createAward(award);

		// adding this award in view page to print new award id
		model.addAttribute("award", award);

		return "awardAdded";
	}

}
