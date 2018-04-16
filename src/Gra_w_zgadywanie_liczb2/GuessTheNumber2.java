package Gra_w_zgadywanie_liczb2;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Pomyśl liczbę od 0 do 1000, a ja zgadnę ją w max 10 ruchach");
		int min = 0;
		int max = 1000;
		int guess = ((max - min) / 2) + min;
		String toMuch = "za dużo";
		String toLow = "za mało";
		String ok = "zgadłeś";
		int i = 0;

		while (true) {
			System.out.println("Zgaduję :" + guess);
			i++;
			String str = scanner.nextLine();
			if (i > 10) {
				System.out.println("Nie oszukuj");
				guess = 500;
				i = 0;
			} else if (str.equals(toMuch)) {
				max = guess;
				guess = ((max - min) / 2) + min;
			} else if (str.equals(toLow)) {
				min = guess;
				guess = ((max - min) / 2) + min;
			} else {
				System.out.println("Wygrałem!");
				break;
			}
		}

	}

}
