package com.promineotech;

import java.util.Random;

public class TestDemo {

	// This method adds two positive integers
	int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	
	// This method checks if password is > 6 characters
	boolean isPasswordSixCharactersOrMore(String password) {
		return password != null && password.length() > 6;
	}
	
	// This method squares a random number
	int randomNumberSquared() {
		int numberSquared = getRandomInt();
		return numberSquared * numberSquared;
	}

	// This method generates random number
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}