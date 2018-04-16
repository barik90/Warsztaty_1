package Symulator_LOTTO;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Lotto {

	static String[] getNumbers() {

		Scanner scanner = new Scanner(System.in);
		String[] parts = new String[6];
		System.out.println("Podaj 6 liczb od 1 do 49");
		String str = scanner.nextLine();
		parts = str.split(" ");
		return parts;
	}

	static int[] ifNumbers(String[] strTab) {
		int[] tab = new int[strTab.length];
		for (int i = 0; i < strTab.length; i++) {
			try {
				tab[i] = Integer.parseInt(strTab[i]);
			} catch (Exception e) {
				System.out.println("Nie podałeś liczb");
				getNumbers();
			}
		}
		return ifNumberNotRepeate(tab);

	}

	static int[] ifNumberNotRepeate(int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			for (int j = i + 1; j < tab.length; j++) {
				if (tab[i] == tab[j]) {
					System.out.println("Powtórzona liczba. Jeszcze raz");
					getNumbers();
				}
			}
		}
		return ifNumberIsToBig(tab);
	}

	static int[] ifNumberIsToBig(int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] > 49) {
				System.out.println("za duża liczba");
				getNumbers();
			}
		}
		return tab;
	}

	public static void main(String[] args) {

		String[] parts = getNumbers();
		int[] tab = ifNumbers(parts);
		// ifNumberNotRepeate(tab);
		// ifNumberIsToBig(tab);

		Integer[] arr = new Integer[49];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		// System.out.println(Arrays.toString(arr));
		Collections.shuffle(Arrays.asList(arr));
		// System.out.println(Arrays.toString(arr));

		int sum = 0;

		for (int i = 0; i < tab.length; i++) {
			if (arr[i] == tab[i]) {
				sum += 1;
			}
		}

		for (int i = 0; i < 6; i++) {
			System.out.println(arr[i]);
		}
		if (sum < 3) {
			System.out.println("Niestety nie wygrałeś");
		} else if (sum == 3) {
			System.out.println("Trafiłeś trójkę");
		} else if (sum == 4) {
			System.out.println("Trafiłeś czwórkę");
		} else if (sum == 5) {
			System.out.println("Trafiłeś piątkę");
		} else {
			System.out.println("Trafiłeś 6! Jesteś milionerem.");
		}
	}

}
