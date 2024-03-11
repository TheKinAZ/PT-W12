package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	public int addPositive(int a, int b) {
		
		int sum;
		if (a > 0 && b > 0) {
			sum = a + b;
		} 
		
		else {
			throw new IllegalArgumentException(" Both Parameters must be positive! ");
		}
		return sum;
	} // end of method

	public int randomNumberSquared() {
		int newInt = getRandomInt();
		return newInt * newInt;
	} // end of method
	
	public int getRandomInt() {
		Random random = new Random();
		
		return random.nextInt(10) + 1;
	} // end of method
	
	public int multiplyPositive(int a, int b) {
		int product;
		if (a > 0 && b > 0) {
			product = a * b;
		} 
		
		else {
			throw new IllegalArgumentException(" Both Parameters must be positive! ");
		}
		return product;
	} // end of method


} // end of class
