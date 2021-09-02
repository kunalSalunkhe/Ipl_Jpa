package com.entlogics.iplapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.models.Player;
import com.entlogics.iplapp.models.PlayerMatch;
import com.entlogics.iplapp.models.Team;

//This class will fetch data of Player object from database
@Repository
@Component
public class PlayerRepository implements IPlayerRepository {

	// create entityManagerFactory to connect with database
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPADemo");

	public PlayerRepository() {
		super();
	}

	// adding a new player in database
	@Override
	public void addPlayer(Player player) {

		System.out.println("Inside PlayerRepository addPlayer()");

		// get entityManager from factory
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		// saving team in database
		entityManager.persist(player);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

	//// for finding the details of a team
	@Override
	public Player findPlayer(int playerId) {

		System.out.println("Inside PlayerRepository findPlayer()");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		// get team from database
		Player player = entityManager.find(Player.class, playerId);

		entityManager.close();

		return player;
	}

	// gettting all awards of player
	@Override
	public List<Award> findAwardsOfPlayer(int playerId) {

		System.out.println("Inside PlayerRepository findAwardsOfPlayer()");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		List<Award> awards = entityManager.createQuery("from Award a where a.winner.playerId = " + playerId + "")
				.getResultList();

		entityManager.close();

		return awards;
	}

	// getting matches of player
	@Override
	public List<PlayerMatch> findMatchesOfPlayer(int playerId) {

		System.out.println("Inside PlayerRepository findAwardsOfPlayer()");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		List<PlayerMatch> playerMatches = entityManager
				.createQuery("from PlayerMatch p where p.player.playerId = " + playerId + "").getResultList();

		entityManager.close();

		return playerMatches;
	}

}
