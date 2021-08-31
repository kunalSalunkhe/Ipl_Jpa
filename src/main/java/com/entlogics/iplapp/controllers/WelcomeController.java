package com.entlogics.iplapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entlogics.iplapp.services.ISeasonService;

@Controller
@RequestMapping("/")
public class WelcomeController {

	public ISeasonService iSeasonService;
	
	@Autowired
	public void setiSeasonService(ISeasonService iSeasonService) {
		this.iSeasonService = iSeasonService;
	}

	@RequestMapping("/")
	public String welcome() {
		System.out.println("Inside welcome method");
		//iSeasonService.createDatabase();
		return "welcome";
	}
}
