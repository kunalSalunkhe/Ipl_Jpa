package com.entlogics.iplapp.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.models.Player;
import com.entlogics.iplapp.models.PlayerMatch;

//This class will fetch data of Player object from database
@Repository
@Component
public class PlayerRepository implements IPlayerRepository {

	SessionFactory factory;

	public PlayerRepository() {
		super();
	}

	// Injecting SessionFactory by setter injection
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	// adding a new player in database
	@Override
	public void addPlayer(Player player) {

		System.out.println("Inside PlayerRepository addPlayer()");
		Session session = factory.openSession();

		session.beginTransaction();

		session.save(player);

		session.getTransaction().commit();
	}

	//// for finding the details of a team
	@Override
	public Player findPlayer(int playerId) {

		System.out.println("Inside PlayerRepository findPlayer()");
		Session session = factory.openSession();

		Player player = session.get(Player.class, playerId);

		return player;
	}

	// gettting all awards of player
	@Override
	public List<Award> findAwardsOfPlayer(int playerId) {

		System.out.println("Inside PlayerRepository findAwardsOfPlayer()");
		Session session = factory.openSession();

		List<Award> awards = session.createQuery("from Award a where a.winner.playerId = " + playerId + "")
				.getResultList();

		return awards;
	}

	// getting matches of player
	@Override
	public List<PlayerMatch> findMatchesOfPlayer(int playerId) {

		System.out.println("Inside PlayerRepository findAwardsOfPlayer()");
		Session session = factory.openSession();

		List<PlayerMatch> playerMatches = session
				.createQuery("from PlayerMatch p where p.player.playerId = " + playerId + "").getResultList();

		return playerMatches;
	}

}
