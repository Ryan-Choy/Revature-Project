package com.app.player.service.impl;

import java.util.List;

import com.app.player.dao.PlayerSearchDAO;
import com.app.player.dao.impl.PlayerSearchDAOImpl;
import com.app.player.exception.BusinessException;
import com.app.player.model.Player;
import com.app.player.service.PlayerSearchService;

public class PlayerSearchServiceImpl implements PlayerSearchService{

	private PlayerSearchDAO searchDAO=new PlayerSearchDAOImpl();
	@Override
	public Player getPlayerById(int id) throws BusinessException {
		Player player=null;
		if(PlayerValidations.isValidId(id)) {
			//code here to DAO
			player=searchDAO.getPlayerById(id);
		}else {
			throw new BusinessException("Entered Player id "+id+" is INVALID" );
		}
		return player;
	}

	@Override
	public List<Player> getPlayersByAge(int age) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayersByCity(String city) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayersByGender(String gender) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayersByTeamName(String teamname) throws BusinessException {
		//validate teamName
		return searchDAO.getPlayersByTeamName(teamname);
	}

}
