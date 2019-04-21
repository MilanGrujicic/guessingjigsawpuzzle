package guessing_jigsaw_puzzle;

import java.util.Random;
import java.util.Scanner;

public class GuessingJigsawPuzzle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int cifra1 = rand.nextInt(9) + 1;
		int cifra2 = rand.nextInt(9) + 1;
		int cifra3 = rand.nextInt(9) + 1;

		// CHECKS WHETHER THE GENERATED NUMBERS ARE DISTINCT
		while (cifra1 == cifra2 || cifra2 == cifra3 || cifra1 == cifra3) {
			cifra1 = rand.nextInt(9) + 1;
			cifra2 = rand.nextInt(9) + 1;
			cifra3 = rand.nextInt(9) + 1;
		}
		System.out.println("=======================================");
		System.out.println("»»»»»»»»»»»»» MASTER MIND «««««««««««««");
		System.out.println("=======================================");
		System.out.println("> ? NUMBER IN THE RIGHT PLACE");
		System.out.println("> ? NUMBER IN THE WRONG PLACE");
		System.out.println("> _ NUMBER IS OUT OF THE COMBINATION");
		// INPUT NUMBERS BY USER
		System.out.println("\nINSERT 3 DISTINCT NUMBERS FROM 1 TO 9: ");
		System.out.print("\nFIRST: ");
		int a = scan.nextInt();
		System.out.print("SECOND: ");
		int b = scan.nextInt();
		System.out.print("THIRD: ");
		int c = scan.nextInt();

		// COMPARES USER'S INPUT WITH GENERATED RANDOM INTEGERS
		check(a, b, c, cifra1, cifra2, cifra3);

		// FOR LOOP THAT ALLOWS 5 TRIES
		for (int i = 5; i >= 1; i--) {
			System.out.println("\nYOU STILL HAVE" + i + " TRIES");
			System.out.println("-----------------------------");
			System.out.print("\nFIRST: ");
			a = scan.nextInt();
			System.out.print("SECOND: ");
			b = scan.nextInt();
			System.out.print("THIRD: ");
			c = scan.nextInt();
			check(a, b, c, cifra1, cifra2, cifra3);

			// IF USER GUESS ALL THREE INTEGERS, THE LOOP STOPS
			if (a == cifra1 && b == cifra2 && c == cifra3) {
				break;
			}
		}

		// END OF PROGRAM
		scan.close();
		System.out.println("\nRACUNARSKA KOMBINACIJA: [" + cifra1 + " " + cifra2 + " " + cifra3 + "]");
		System.out.println("TVOJA KOMBINACIJA:      [" + a + " " + b + " " + c + "]");
	}

	// METHOD WHICH COMPARES INTEGERS
	public static void check(int a, int b, int c, int cifra1, int cifra2, int cifra3) {
		if (a == cifra1) {
			System.out.print("?");
		} else if (a == cifra2 || a == cifra3) {
			System.out.print("?");
		} else {
			System.out.print(" _ ");
		}
		if (b == cifra2) {
			System.out.print("?");
		} else if (b == cifra1 || b == cifra3) {
			System.out.print("?");
		} else {
			System.out.print(" _ ");
		}
		if (c == cifra3) {
			System.out.print("?");
		} else if (c == cifra1 || c == cifra2) {
			System.out.print("?");
		} else {
			System.out.print(" _ ");
		}
		if (a == cifra1 && b == cifra2 && c == cifra3) {
			System.out.println("\nYOU HAVE GUESSED ALL THREE NUMBERS!!");
		}
	}
}
