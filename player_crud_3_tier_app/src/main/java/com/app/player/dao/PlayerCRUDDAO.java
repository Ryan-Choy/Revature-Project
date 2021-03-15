package com.app.player.dao;

import java.util.List;

import com.app.player.exception.BusinessException;
import com.app.player.model.Player;

public interface PlayerCRUDDAO {
	public int createPlayer(Player player)throws BusinessException;
	public int updatePlayer(int id,String city)throws BusinessException;
	public int deletePlayer(int id)throws BusinessException;
	public List<Player> getAllPlayers()throws BusinessException;
}
