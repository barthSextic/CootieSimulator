package edu.mtc.egr281.project12;

import java.util.Scanner;
import java.util.Arrays;

/*/
 * Rick Howell
 * Project 12
 * 11/14/21
 * This is a Cootie simulator
 */

public class Cootie {
	static int playerCount;
	static Body[] players;
	static Scanner input;
	static int index;
	static Dice dice;
	static boolean[] start = new boolean[Body.NUMBER_OF_PARTS];
	static boolean[] finish = new boolean[Body.NUMBER_OF_PARTS];
	static int legStart = 0;
	static int legFinish = 0;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);	
		System.out.print("Enter the number of players: ");
		playerCount = input.nextInt();
		players = new Body[playerCount];
		System.out.println();
		// CONSTRUCT PLAYER OBJECTS WITH NAMES
		for(int i = 0; i < players.length; ++i) {
			System.out.print("Enter player number " + (i + 1) + ": ");
			players[i] = new Body(input.next());
		} // end for
		System.out.println("\nPlayers: \n");
		for (Body player : players) {
			System.out.println(player.getName());
		} // end for each
		System.out.println();
		// ========================== GAME ALGORITHM ===============================
		index = 0;
		Body player;
		dice = new Dice();
		do {
			// keep up top to initialize player
			player = players[index % players.length];
			Cootie.startArraySet(player.getPartValues());
			Cootie.startLegSet(player.getLegs());
			dice.roll();
			System.out.println("===========================");
			System.out.println("Player: " + player.getName());
			System.out.println("Roll: " + dice.getValue());
			player.diceToPart(dice.getValue());
			player.partReturn();
			Cootie.endArraySet(player.getPartValues());
			Cootie.endLegSet(player.getLegs());
			if (Arrays.equals(Cootie.startArrayGet(), Cootie.endArrayGet()) 
					&& Cootie.startLegGet() == Cootie.endLegGet()
					&& Cootie.endLegGet() <= Body.NUMBER_OF_LEGS) {
				++index;
				continue;
			} // end if
		} while(!player.isWin());
		
		System.out.println("####XXXX####XXXX####XXXX####XXXX####XXXX####XXXX####");
		System.out.println(player.getName() + " has assembled a cootie and is declared the winner!");
		input.close();
	} // end main method
	
	private static void startArraySet(boolean[] input) {
		for (int i = 0; i < input.length; ++i) {
			start[i] = input[i];
		}
	} // end method
	private static boolean[] startArrayGet() {
		return start;
	} // end method
	
	private static void endArraySet(boolean[] input) {
		for (int i = 0; i < input.length; ++i) {
			finish[i] = input[i];
		}
	} // end method
	private static boolean[] endArrayGet() {
		return finish;
	} // end method

	private static void startLegSet(int input) {
		legStart = input;
	} // end method
	private static int startLegGet() {
		return legStart;
	} // end method
	private static void endLegSet(int input) {
		legFinish = input;
	} // end method
	private static int endLegGet() {
		return legFinish;
	} // end method
} // end cootie class
