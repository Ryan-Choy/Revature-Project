package com.demo.playerdao;

import java.util.List;

import com.demo.model.Player;

public interface PlayerDAO {
	
	public int addPlayer(Player player);
	public int updatePlayerCity(int id,String newCity);
	public int deletePlayerById(int id);
	public Player getPlayerById(int id);
	public List<Player> getAllPlayers();
	public List<Player> getAllPlayersByAge(int age);
	

	public List<Player> getAllPlayersByTeamName(String teamName);
	public List<Player> getAllPlayersByTeamLocation(String location);
	public List<Player> getAllPlayersByTeamId(String teamid);
	public List<Player> getAllPlayersByCity(String city);

}
