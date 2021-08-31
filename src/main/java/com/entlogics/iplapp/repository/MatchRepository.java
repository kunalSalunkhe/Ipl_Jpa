package com.entlogics.iplapp.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.entlogics.iplapp.models.Match;
import com.entlogics.iplapp.models.Season;

@Repository
@Component
public class MatchRepository implements IMatchRepository {

	SessionFactory factory;

	public MatchRepository() {
		super();

	}

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	// add a match in a season
	public void addMatch(Match match) {

		System.out.println("Inside MatchRepository addMatch()");

		Session session = factory.openSession();

		session.beginTransaction();

		try {
			// get the season from season Name
			Season season = (Season) session
					.createQuery("from Season s where s.seasonName = :seasonName")
					.setParameter("seasonName", match.getSeason().getSeasonName()).getSingleResult();
	

			System.out.println(season);

			// set this season for match
			match.setSeason(season);

			// save match objetct
			session.save(match);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
