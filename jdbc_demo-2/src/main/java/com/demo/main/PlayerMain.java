package com.demo.main;

import java.util.List;
import com.demo.model.Player;
import com.demo.playerdao.PlayerDAO;
import com.demo.playerdao.impl.PlayerDAOImpl;

public class PlayerMain {

	public static void main(String[] args) {
		PlayerDAO dao = new PlayerDAOImpl();
//		Player p = new Player(110, "Raj", "Bangalore", 23, "M");

//		int c = dao.addPlayer(p);
//		if (c > 0) {
//			System.out.println("Player registered with below details");
//			System.out.println(p);
//		} else {
//			System.out.println("Failure in registration");
//		}
		
//		int id=102;
//		Player player=dao.getPlayerById(id);
//		if(player==null) {
//			System.out.println("No player found with id "+id);
//		}else {
//			System.out.println("Player found with id = "+id+" and the details are below :");
//			System.out.println(player);
//		}

//		List<Player> playerList = dao.getAllPlayers();
//		if (playerList.size() == 0) {
//			System.out.println("No players as of now in DB");
//		} else {
//			System.out.println("Total there are " + playerList.size() + " no of player/s in DB");
//			System.out.println("Printing their details");
//			for (Player p : playerList) {
//				System.out.println(p);
//			}
//		}
		
//		int id = 106;
//		String newCity = "Test";
//		int x = dao.updatePlayerCity(id, newCity);
//		if (x > 0 ) {
//			System.out.println("Updated.");
//			
//		} else {
//			System.out.println("Update failed.");
//		}
		
//		int id = 106;
//		int c = dao.deletePlayerById(id);
//		if (c > 0) {
//			System.out.println("Deleted");
//		} else {
//			System.out.println("Deletion failed.");
//		}
		
//		int age = 34;
//		List<Player> playerList = dao.getAllPlayersByAge(age);
//	
//		if(playerList.size() == 0) {
//			System.out.println("No players are at that age.");
//		} else {
//			System.out.println("There are a total of "+ playerList.size() + " players that are at age "+ age);
//			System.out.println("Printing their details...");
//			for(Player p : playerList) {
//				System.out.println(p);
//			}
//		}
		
//		String teamName="ABC Riders";
//		List<Player> playerList = dao.getAllPlayersByTeamName(teamName);
//		if (playerList.size() == 0) {
//			System.out.println("No players as of now from the teamName "+teamName);
//		} else {
//			System.out.println("Total there are " + playerList.size() + " no of player/s in DB from team : "+teamName);
//			System.out.println("Printing their details");
//			for (Player p : playerList) {
//				System.out.println(p);
//			}
//		}
		
//		String location = "Bangalore";
//		List<Player> playerList = dao.getAllPlayersByTeamLocation(location);
//		if (playerList.size() == 0) {
//			System.out.println("No players as of now from the teamName "+ location);
//		} else {
//			System.out.println("Total there are " + playerList.size() + " no of player/s in DB from team location: "+location);
//			System.out.println("Printing their details");
//			for (Player p : playerList) {
//				System.out.println(p);
//			}
//		}
		
//		String teamid = "T0001";
//		List<Player> playerList = dao.getAllPlayersByTeamId(teamid);
//		if (playerList.size() == 0) {
//			System.out.println("No players as of now from the teamName "+ teamid);
//		} else {
//			System.out.println("Total there are " + playerList.size() + " no of player/s in DB from team id: "+teamid);
//			System.out.println("Printing their details");
//			for (Player p : playerList) {
//				System.out.println(p);
//			}
//		}
		
		String city = "Bangalore";
		List<Player> playerList = dao.getAllPlayersByCity(city);
		if (playerList.size() == 0) {
			System.out.println("No players as of now from the teamName "+ city);
		} else {
			System.out.println("Total there are " + playerList.size() + " no of player/s in DB from city: "+city);
			System.out.println("Printing their details");
			for (Player p : playerList) {
				System.out.println(p);
			}
		}
		
		
		
//main ends here		
	}

}
