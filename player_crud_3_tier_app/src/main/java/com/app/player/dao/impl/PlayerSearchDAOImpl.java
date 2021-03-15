package com.app.player.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.player.dao.PlayerSearchDAO;
import com.app.player.dao.dbutil.PostgresConnection;
import com.app.player.exception.BusinessException;
import com.app.player.model.Player;


public class PlayerSearchDAOImpl implements PlayerSearchDAO {

	@Override
	public Player getPlayerById(int id) throws BusinessException {
		Player player=null;
		try(Connection connection=PostgresConnection.getConnection()){
			String sql = "select name,age,gender,city from player_schema.player where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				player=new Player();
				player.setId(id);
				player.setAge(resultSet.getInt("age"));
				player.setCity(resultSet.getString("city"));
				player.setGender(resultSet.getString("gender"));
				player.setName(resultSet.getString("name"));
			}
			if(player==null) {
				throw new BusinessException("No player found with id : "+id);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error");
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
		List<Player> playerList=new ArrayList<>();
		try(Connection connection=PostgresConnection.getConnection()){
			String sql = "select id,name,age,gender,city from player_schema.player p join player_schema.team t on p.teamid=t.teamid where t.teamname=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, teamname);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Player player=new Player();
				player.setId(resultSet.getInt("id"));
				player.setAge(resultSet.getInt("age"));
				player.setCity(resultSet.getString("city"));
				player.setGender(resultSet.getString("gender"));
				player.setName(resultSet.getString("name"));
				playerList.add(player);
			}
			if(playerList.size()==0) {
				throw new BusinessException("No Players found for the teamName "+teamname);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error");
		}
		return playerList;
	}

}
