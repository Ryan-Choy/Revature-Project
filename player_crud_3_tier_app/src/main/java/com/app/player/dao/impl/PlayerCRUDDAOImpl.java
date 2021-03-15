package com.app.player.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.app.player.dao.PlayerCRUDDAO;
import com.app.player.dao.dbutil.PostgresConnection;
import com.app.player.exception.BusinessException;
import com.app.player.model.Player;

public class PlayerCRUDDAOImpl implements PlayerCRUDDAO{

	@Override
	public int createPlayer(Player player) throws BusinessException {
		int c=0;
		try(Connection connection=PostgresConnection.getConnection()){
			String sql = "insert into player_schema.player(id,name,age,city,gender,teamid) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, player.getId());
			preparedStatement.setString(2, player.getName());
			preparedStatement.setInt(3, player.getAge());
			preparedStatement.setString(4, player.getCity());
			preparedStatement.setString(5, player.getGender());
			preparedStatement.setString(6, player.getTeam().getTeamid());
			c=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); //only at development not at production/live
			throw new BusinessException("Internal error occured... Please contact SYSSADMIN");
		}
		
		return c;
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
