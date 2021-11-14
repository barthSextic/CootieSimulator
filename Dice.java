package edu.mtc.egr281.project12;

import java.util.Random;

public class Dice {
private static final int FACES = 6;
	
	Random rng = new Random();
	int value = 0;
	
	// We can use a default constructor here
	
	public void roll() {
		this.setValue(rng.nextInt(FACES) + 1);
	} // end roll method
	
	private void setValue(int newValue) {
		this.value = newValue;
	} // end set value method
	
	public int getValue() {
		return this.value;
	} // end method
	
} // end die class
