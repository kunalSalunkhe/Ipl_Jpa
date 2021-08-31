package com.entlogics.iplapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.models.Player;
import com.entlogics.iplapp.models.PlayerMatch;
import com.entlogics.iplapp.repository.IPlayerRepository;

@Service
public class PlayerService implements IPlayerService {

	IPlayerRepository playerRepo;

	@Autowired
	public void setPlayerRepo(IPlayerRepository playerRepo) {
		this.playerRepo = playerRepo;
	}

	public void createPlayer(Player player) {
		System.out.println("Inside PlayerService createPlayer()");
		playerRepo.addPlayer(player);

	}

	@Override
	public Player getPlayer(int playerId) {
		System.out.println("Inside PlayerService getPlayer()");
		return playerRepo.findPlayer(playerId);
	}

	@Override
	public List<Award> getAwardsOfPlayer(int playerId) {
		System.out.println("Inside PlayerService getAwardsOfPlayer()");
		return playerRepo.findAwardsOfPlayer(playerId);
	}

	@Override
	public List<PlayerMatch> getMatchesOfPlayer(int playerId) {
		System.out.println("Inside PlayerService getMatchesOfPlayer()");
		return playerRepo.findMatchesOfPlayer(playerId);
	}

}
