package Kostka_do_gry;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import org.apache.commons.lang3.StringUtils;

public class Dice {

	public static void main(String[] args) {
		Random r = new Random();
		int x = 0;
		int y = 0;
		int z = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj skrócony kod polecenia rzutu:");

		String str = scanner.nextLine();
		String str2 = "+";
		boolean check = false;
		check = str.contains(str2);
		System.out.println(check);

		String str3 = "2D10+20";
		int[] tab = new int[3];
		int i = 0;
		int good = 0;
		int[] tabDice = { 3, 4, 6, 8, 10, 12, 20, 100 };
		StringTokenizer strToken = new StringTokenizer(str, "D+");
		while (strToken.hasMoreTokens()) {
			try {
				tab[i] = Integer.parseInt(strToken.nextToken());
				System.out.println(tab[i]);
				i++;
			} catch (Exception e) {
				System.out.println("Podałeś zły kod");
				break;
			}
		}

		System.out.println("iteracji:" + i);
		System.out.println(Arrays.toString(tab));
		System.out.println(good);

		if (i == 3) {
			x = tab[0];
			y = tab[1];
			z = tab[2];
			for (int j = 0; j < tabDice.length; j++) {
				if (tabDice[j] == y) {
					good = 1;
				}
			}
		} else if (i == 2 && check == true) {
			x = 1;
			y = tab[0];
			z = tab[1];
			for (int j = 0; j < tabDice.length; j++) {
				if (tabDice[j] == y) {
					good = 1;
				}
			}
		} else if (check == false && i == 2) {
			x = tab[0];
			y = tab[1];
			z = 0;
			for (int j = 0; j < tabDice.length; j++) {
				if (tabDice[j] == y) {
					good = 1;
				}
			}
		} else {
			x = 1;
			y = tab[0];
			for (int j = 0; j < tabDice.length; j++) {
				if (tabDice[j] == y) {
					good = 1;
				}
			}
		}

		if (good == 0) {
			System.out.println("Nie ma takiej kostki!");
		} else if (good == 1) {
			int a = 0;
			for (int j = 0; j < x; j++) {
				int b = r.nextInt(y) + 1;
				System.out.println("random:" + b);
				a += b;
				System.out.println(a);
			}
			int result = a + z;
			System.out.println("Wynik " + result);
		}

	}
}
