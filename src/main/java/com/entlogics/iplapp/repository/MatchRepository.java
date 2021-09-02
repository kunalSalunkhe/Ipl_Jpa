package com.entlogics.iplapp.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.entlogics.iplapp.models.Match;
import com.entlogics.iplapp.models.Season;

@Repository
@Component
public class MatchRepository implements IMatchRepository {

	// create entityManagerFactory to connect with database
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPADemo");

	public MatchRepository() {
		super();

	}

	// add a match in a season
	public void addMatch(Match match) {

		System.out.println("Inside MatchRepository addMatch()");

		// get entityManager from factory
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		try {
			// get the season from season Name
			Season season = (Season) entityManager.createQuery("from Season s where s.seasonName = :seasonName")
					.setParameter("seasonName", match.getSeason().getSeasonName()).getSingleResult();

			System.out.println(season);

			// set this season for match
			match.setSeason(season);

			// save match objetct
			entityManager.persist(match);

			entityManager.getTransaction().commit();

			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
