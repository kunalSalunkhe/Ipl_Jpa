package com.entlogics.iplapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.repository.IAwardRepository;

@Service
public class AwardService implements IAwardService {

	IAwardRepository awardRepo;

	@Autowired
	public void setAwardRepo(IAwardRepository awardRepo) {
		this.awardRepo = awardRepo;
	}

	@Override
	public void createAward(Award award) {

		System.out.println("Inside AwardService createAward()");

		awardRepo.addAward(award);
	}

}
