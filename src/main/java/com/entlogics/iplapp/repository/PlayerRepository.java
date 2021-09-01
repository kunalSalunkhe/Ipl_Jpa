package com.entlogics.iplapp.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.models.Player;
import com.entlogics.iplapp.models.PlayerMatch;

//This class will fetch data of Player object from database
@Repository
@Component
public class PlayerRepository implements IPlayerRepository {

	public PlayerRepository() {
		super();
	}

	// adding a new player in database
	@Override
	public void addPlayer(Player player) {

		System.out.println("Inside PlayerRepository addPlayer()");

	}

	//// for finding the details of a team
	@Override
	public Player findPlayer(int playerId) {

		System.out.println("Inside PlayerRepository findPlayer()");
		return null;
	}

	// gettting all awards of player
	@Override
	public List<Award> findAwardsOfPlayer(int playerId) {

		System.out.println("Inside PlayerRepository findAwardsOfPlayer()");

		return null;
	}

	// getting matches of player
	@Override
	public List<PlayerMatch> findMatchesOfPlayer(int playerId) {

		System.out.println("Inside PlayerRepository findAwardsOfPlayer()");

		return null;
	}

}
