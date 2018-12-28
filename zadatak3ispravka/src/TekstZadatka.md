#Zadatak 2
U produžetku teksta je dat kod klase sa metodom koja bi trebalo da sa tastature učitava više celih brojeva i
proverava i ispisuje na ekranu (za svaki od njih) da li je u pitanju Nivenov broj. Učitavanje se vrši za svaki
broj u posebnom redu, a kraj je kad se unese nešto što nije broj. Nivenovi brojevi su oni celi brojevi koji su
deljivi sumom svojih cifara. Na primer, suma cifara broja 36 je 3 + 6 = 9. Pošto je 36 deljivo sa 9 (36 / 9 =
4), to znači da je 36 Nivenov broj. Primera radi, i brojevi 12, 100 i 135 su takođe Nivenovi brojevi, ali zato
brojevi 13, 22 i 25 nisu.

Dati kod se kompajlira, ali ne radi to šta treba. Napraviti javnu klasu **UcitavanjeSaTastature3** u paketu
**ispravka_koda**, prekucati u nju kod koji je dat i, __uz minimalne izmene__ ga ispraviti tako da funkcioniše
kako treba. Napraviti test klasu i, koristeći njenu main metodu, pozvati metodu
**UcitajIProveriNivenovBroj()** i proveriti njen rad.

package ispravka_koda;

import java.util.Scanner;

public class UcitavanjeSaTastature3 {

>public static void ucitajIProveriNivenov() {

>>Scanner s = new Scanner(System.in);

>>try {

>>>while (true) {

>>>>System.out.print("Unesite ceo broj:");

>>>>int broj = s.nextInt();

>>>>int sumaCifara = 0;

>>>>while (broj >= 0) {

>>>>>sumaCifara = sumaCifara + broj % 10;

>>>>>broj = broj / 10;

>>>>}

>>>> if (broj%sumaCifara==0)

>>>>>System.out.println("Jeste");

>>>>else System.out.println("Nije");

>>>}

>>} catch (Exception e) {

>>}

>>s.close();

>}

}