package com.entlogics.iplapp.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.entlogics.iplapp.models.Award;

@Repository
@Component
public class AwardRepository implements IAwardRepository {

	// create entityManagerFactory to connect with database
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPADemo");

	public AwardRepository() {
		super();
	}

	// Adding a new award in database
	@Override
	public void addAward(Award award) {

		System.out.println("Inside AwardRepository addAwards()");

		// get entityManager from factory
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		// saving team in database
		entityManager.persist(award);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

}
