package com.entlogics.iplapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entlogics.iplapp.models.Match;
import com.entlogics.iplapp.repository.IMatchRepository;

@Service
public class MatchService implements IMatchService {

	IMatchRepository matchRepo;

	@Autowired
	public void setMatchRepo(IMatchRepository matchRepo) {
		this.matchRepo = matchRepo;
	}

	@Override
	public void createMatch(Match match) {

		matchRepo.addMatch(match);
	}

}
