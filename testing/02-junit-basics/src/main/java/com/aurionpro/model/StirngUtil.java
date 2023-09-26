package com.aurionpro.model;

public class StirngUtil {

	public static String trancateInFirst2Position(String str) {

		if (str == null || str.length() < 2) {
			return str;
		} else {
			char firstChar = str.charAt(0);
			char secondChar = str.charAt(1);

			if (firstChar == 'A' && secondChar == 'A') {
				return str.substring(2);
			} else {
				return str;
			}
		}
	}

	public static boolean areFirstAndLastTwoCharactersSame(String input) {
		if (input == null || input.length() < 2) {
			return false;
		}
		String firstTwoChars = input.substring(0, 2);
		String lastTwoChars = input.substring(input.length() - 2);
		return firstTwoChars.equals(lastTwoChars);
	}

}
