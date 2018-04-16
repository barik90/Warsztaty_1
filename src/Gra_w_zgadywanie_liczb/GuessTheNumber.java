package Gra_w_zgadywanie_liczb;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

	public static void main(String[] args) {

		Random r = new Random();
		int a = r.nextInt(100) + 1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Zgadnij liczbę:");
		while (true) {
			while (!scanner.hasNextInt()) {
				scanner.next();
				System.out.println("To nie jest liczba. Zgadnij liczbę:");
			}
			int number = scanner.nextInt();
			if (a < number) {
				System.out.println("Za dużo");
			} else if (a > number) {
				System.out.println("Za mało");
			} else {
				System.out.println("Zgadłeś!");
				break;
			}
		}

	}

}
