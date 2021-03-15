package com.app.player.team.dao;

import java.util.List;

import com.app.player.exception.BusinessException;
import com.app.player.model.Team;

public interface TeamDAO {
	public int addTeam(Team team) throws BusinessException;
	public List<Team> getAllTeams() throws BusinessException;
}
