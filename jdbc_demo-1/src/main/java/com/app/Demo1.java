package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) {

		Connection connection = null;

		try {
			// Step 1: Load Driver
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded successfully.");

			// Step 2: Open Connection
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String username = "postgres";
			String password = "R3v@Ture"; // DB user name and password.
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection opened.");

			// Step 3: Create statement
			Statement statement = connection.createStatement();
			// String sql = "select p.id,p.name,p.age,p.city,p.gender from
			// player_schema.player p";

			String sql = "select p.id, p.name, p.city, p.gender,p.age, t.teamname, t.location from player_schema.player p join player_schema.team t on p.teamid = t.teamid order by age desc;";

			// Step 4: Execute query
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println("Query executed.");

			// Step 5: Process results
			System.out.println("Printing all players.");
			while (resultSet.next()) {
				System.out.print("Player Details id : " + resultSet.getInt("id"));
				System.out.print(" Name : " + resultSet.getString("name"));
				System.out.print(" City : " + resultSet.getString("city"));
				System.out.print(" Gender : " + resultSet.getString("gender"));
				System.out.print(" Age : " + resultSet.getInt("age"));
				System.out.print(" Team name : " + resultSet.getString("teamname"));
				System.out.println(" Location : " + resultSet.getString("Location"));
			}
			System.out.println("Results processed successfully.");

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				// Step 6: Release connection
				connection.close();
				System.out.println("Connection closed.");
			} catch (SQLException e) {
				System.out.println(e);
			}
		}

	}

}
