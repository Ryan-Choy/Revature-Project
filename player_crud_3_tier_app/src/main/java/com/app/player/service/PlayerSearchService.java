package com.app.player.service;

import java.util.List;

import com.app.player.exception.BusinessException;
import com.app.player.model.Player;

public interface PlayerSearchService {

	public Player getPlayerById(int id) throws BusinessException;
	public List<Player> getPlayersByAge(int age) throws BusinessException;
	public List<Player> getPlayersByCity(String city) throws BusinessException;
	public List<Player> getPlayersByGender(String gender) throws BusinessException;
	public List<Player> getPlayersByTeamName(String teamname) throws BusinessException;
}
