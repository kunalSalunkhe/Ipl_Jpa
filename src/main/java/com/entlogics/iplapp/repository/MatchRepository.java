package com.entlogics.iplapp.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.entlogics.iplapp.models.Match;

@Repository
@Component
public class MatchRepository implements IMatchRepository {

	public MatchRepository() {
		super();

	}

	// add a match in a season
	public void addMatch(Match match) {

		System.out.println("Inside MatchRepository addMatch()");

	}

}
