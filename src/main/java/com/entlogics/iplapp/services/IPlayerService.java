package com.entlogics.iplapp.services;

import java.util.List;

import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.models.Player;
import com.entlogics.iplapp.models.PlayerMatch;

public interface IPlayerService {

	public void createPlayer(Player player);

	public Player getPlayer(int playerId);

	public List<Award> getAwardsOfPlayer(int playerId);

	public List<PlayerMatch> getMatchesOfPlayer(int playerId);
}
