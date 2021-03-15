package com.app.player.team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.player.dao.dbutil.PostgresConnection;
import com.app.player.exception.BusinessException;
import com.app.player.model.Team;
import com.app.player.team.dao.TeamDAO;

public class TeamDAOImpl implements TeamDAO{

	@Override
	public int addTeam(Team team) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Team> getAllTeams() throws BusinessException {
		List<Team> teamList=new ArrayList<>();
		try(Connection connection=PostgresConnection.getConnection()){
			String sql="select teamid,teamname,location from player_schema.team";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Team team=new Team();
				team.setTeamid(resultSet.getString("teamid"));
				team.setTeamName(resultSet.getString("teamname"));
				team.setLocation(resultSet.getString("location"));
				teamList.add(team);
			}
			if(teamList.size()==0) {
				throw new BusinessException("No teams registered so far...Please use Add Team option to add a team");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error");
		}
		return teamList;
	}

}
