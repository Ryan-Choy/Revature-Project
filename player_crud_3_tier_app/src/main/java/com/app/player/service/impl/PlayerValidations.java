package com.app.player.service.impl;

public class PlayerValidations {
	public static boolean isValidId(int id) {
		if (id < 100 || id > 1000) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isValidPlayerName(String name) {
		if (name != null && name.matches("[a-zA-Z]{3,20}")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidPlayerCity(String city) {
		if (city != null && city.matches("[a-zA-Z]{3,5}")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidPlayerGender(String gender) {
		if (gender != null && gender.matches("[mMfF]{1}")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidPlayerAge(int age) {
		if (age > 18 && age < 41) {
			return true;
		} else {
			return false;
		}
	}

}
