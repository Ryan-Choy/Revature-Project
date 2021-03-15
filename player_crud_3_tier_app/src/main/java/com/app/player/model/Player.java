package com.app.player.model;

public class Player {

	private int id;
	private String name;
	private String city;
	private int age;
	private String gender;
	private Team team;

	public Player() {
		// TODO Auto-generated constructor stub
	}

	public Player(int id, String name, String city, int age, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.age = age;
		this.gender = gender;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", city=" + city + ", age=" + age + ", gender=" + gender
				+ ", team=" + team + "]";
	}

}
