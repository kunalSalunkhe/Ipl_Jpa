package com.entlogics.iplapp.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.entlogics.iplapp.models.Award;

@Repository
@Component
public class AwardRepository implements IAwardRepository {

	public AwardRepository() {
		super();
	}

	// Adding a new award in database
	@Override
	public void addAward(Award award) {

		System.out.println("Inside AwardRepository addAwards()");

	}

}
