package ispravka_koda;

import java.util.Scanner;

public class UcitavanjeSaTastature3 {

	public static void ucitajIProveriNivenov() {
		Scanner s = new Scanner(System.in);
		try {
			while (true) {
				System.out.print("Unesite ceo broj:");
				int broj = s.nextInt();
				int pomocni = broj;
				int sumaCifara = 0;
				while (broj > 0) {
					sumaCifara = sumaCifara + broj % 10;
					broj = broj / 10;
				}
				if (pomocni % sumaCifara == 0)
					System.out.println("Jeste");
				else
					System.out.println("Nije");
			}
		} catch (Exception e) {
		}
	}
}