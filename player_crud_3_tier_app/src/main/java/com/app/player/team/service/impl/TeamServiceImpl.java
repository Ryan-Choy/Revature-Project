package com.app.player.team.service.impl;

import java.util.List;

import com.app.player.exception.BusinessException;
import com.app.player.model.Team;
import com.app.player.team.dao.TeamDAO;
import com.app.player.team.dao.impl.TeamDAOImpl;
import com.app.player.team.service.TeamService;

public class TeamServiceImpl implements TeamService {

	private TeamDAO teamDAO=new TeamDAOImpl();
	@Override
	public int addTeam(Team team) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Team> getAllTeams() throws BusinessException{
		// TODO Auto-generated method stub
		return teamDAO.getAllTeams();
	}

}
