package com.entlogics.iplapp.repository;

import java.util.List;

import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.models.Player;
import com.entlogics.iplapp.models.PlayerMatch;

public interface IPlayerRepository {

	public void addPlayer(Player player);

	public Player findPlayer(int playerId);

	public List<Award> findAwardsOfPlayer(int playerId);

	public List<PlayerMatch> findMatchesOfPlayer(int playerId);
}
