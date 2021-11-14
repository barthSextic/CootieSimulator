package edu.mtc.egr281.project12;

// each player gets an instance of this class

public class Body {

	private boolean[] parts;
	private boolean isTrue;
	private final String[] partNames = {"Body", "Head", "Antennae", "Eyes", "Mouth", "Legs"};
	private int legCounter;
	private String name;
	public static final int NUMBER_OF_PARTS = 6;
	public static final int NUMBER_OF_LEGS = 6;
	
	public Body(String newName) {
		parts = new boolean[Body.NUMBER_OF_PARTS];
		for (int i = 0; i < parts.length; ++i) {
			parts[i] = false;
		} // end for
		name = newName;
		legCounter = 0;
	} // end constructor

	public void partReturn() {
		System.out.println("Parts >> ");
		for (int i = 0; i < parts.length - 1; ++i) {
			if (parts[i]) {
				System.out.println(partNames[i]);
			} // end if
		} // end for
		if (legCounter > 0) {
			System.out.println("Legs: " + legCounter);
		} // end if
	} // end part return method
	
	public boolean isWin() {
		isTrue = true;
			for (boolean index : parts) {
				if (!index) {
					isTrue = false;
					break;
				} // end if
		} // end for each
		return isTrue;
	} // end is win method
	
	public void diceToPart(int dice) {
		if (dice == 1) {
			parts[0] = true;
		} // end if
		if (dice == 2 && parts[0]) {
			parts[1] = true;
		} // end if
		if (parts[0] && parts[1]) {
			if (dice == 6) {
				++ legCounter;
				if (legCounter >= Body.NUMBER_OF_LEGS) {
					parts[5] = true;
				} // end if
			} // end if
			if (dice == 3) {
				parts[2] = true;
			} // end if
			if (dice == 4) {
				parts[3] = true;
			} // end if
			if (dice == 5) {
				parts[4] = true;
			} // end if
		} // end outer if
	} // end dice to part method
	
	public String getName() {
		return this.name;
	} // end get name
	
	public boolean[] getPartValues() {
		return this.parts;
	} // end method
	
	public int getLegs() {
		return this.legCounter;
	}
	
} // end Body class
