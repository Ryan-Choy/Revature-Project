package com.app.player.service.impl;

import java.util.List;

import com.app.player.dao.PlayerCRUDDAO;
import com.app.player.dao.impl.PlayerCRUDDAOImpl;
import com.app.player.exception.BusinessException;
import com.app.player.model.Player;
import com.app.player.service.PlayerCRUDService;

public class PlayerCRUDServiceImpl implements PlayerCRUDService {

	private PlayerCRUDDAO playercruddao=new PlayerCRUDDAOImpl();
	@Override
	public int createPlayer(Player player) throws BusinessException {
		if(!PlayerValidations.isValidId(player.getId())) {
			throw new BusinessException("Entered player id "+player.getId()+" is invalid");
		}
		if(!PlayerValidations.isValidPlayerAge(player.getAge())) {
			throw new BusinessException("Entered player age "+player.getAge()+" is invalid");
		}
		
		if(!PlayerValidations.isValidPlayerName(player.getName())) {
			throw new BusinessException("Entered player name "+player.getName()+" is invalid");
		}
		if(!PlayerValidations.isValidPlayerCity(player.getCity())) {
			throw new BusinessException("Entered player city "+player.getCity()+" is invalid");
		}
		if(!PlayerValidations.isValidPlayerGender(player.getGender())) {
			throw new BusinessException("Entered player gender "+player.getGender()+" is invalid");
		}
		
		//do the handshake with DAO
		return playercruddao.createPlayer(player);
	}
	
	
	

	@Override
	public int updatePlayer(int id, String city) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePlayer(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Player> getAllPlayers() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
