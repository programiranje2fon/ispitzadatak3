#Zadatak 3 
Napraviti javnu apstraktnu klasu **MasinaZaCiscenjeSnega** u paketu **masina.apstr** koja ima:
* Privatni atribut **markaIModel** koji predstavlja naziv marke i modela mašine.
* Privatni atribut **vremeServisa** koji predstavlja datum posle kojeg je potrebno servisirati mašinu
(klasa GregorianCalendar)
* Odgovarajuće javne get i set metode za ove atribute. Nedozvoljene vrednosti za atribut
markaIModel su null i __svaki String koji ne sadrži blanko znak__ (znak za prazno mesto). Vreme
servisa mora da bude neki datum u budućnosti i ne sme da bude null. U slučaju unosa ovih
nedozvoljenih vrednosti potrebno je baciti izuzetak sa odgovarajućom porukom.
* Redefinisanu metodu toString klase Object koja koja vraća jedan String u kome se nalaze svi podaci
o mašini uz odgovarajući tekst.
* Javnu apstraktnu metodu servisiraj koja nema ulaznih argumenata a vraća boolean vrednost.

Napraviti javnu klasu **Ratrak** u paketu **masina** koja nasleđuje apstraktnu klasu **MasinaZaCiscenjeSnega** i sadrži:
* Implementiranu javnu apstraktnu metodu servisiraj koja proverava da li je datum servisa prošao. Ako
jeste, metoda zaista “servisira” mašinu tj. postavlja vrednost atributa vremeServisa na datum koji je
__godinu dana kasnije u odnosu na datum servisa koji je tu trenutno upisan__ i vraća true. Ako
nije, metoda samo vraća false.

Napraviti javnu klasu **Grtalica** u paketu **masina** koja nasleđuje apstraktnu klasu  **MasinaZaCiscenjeSnega** i sadrži:
* Implementiranu javnu apstraktnu metodu servisiraj koja proverava da li je datum servisa prošao. Ako
jeste, metoda zaista “servisira” mašinu tj. postavlja vrednost atributa vremeServisa na datum koji je
__godinu dana kasnije u odnosu na trenutni datum__ i vraća true. Ako nije, metoda samo vraća false.

Napraviti javnu klasu **SluzbaZaPuteve** u paketu **masina.sluzba** koja ima:
* Privatni atribut **masine** koji predstavlja niz objekata klase MasinaZaCiscenjeSnega.
* Javni konstruktor koji kao ulazni argument prima broj mašina i inicijalizuje niz mašina na taj kapacitet
ako je uneti broj veći od nule. U suprotnom, kapacitet se postavlja na 35.
* Javnu metodu **unesiMasinu** koja kao ulazni parametar prima objekat klase MasinaZaCiscenjeSnega i unosi ga u
niz na prvo slobodno mesto. Mesto u nizu je slobodno ako element na tom mestu ima NULL vredost.
Ako u nizu više nema mesta, metoda samo baca PROVERAVANI izuzetak.
* Javnu metodu **servisirajSveMasine** koja nema ulaznih argumenata a servisira sve mašine pozivanjem metode servisiraj. Takođe, potrebno je u
tekstualni fajl “servis.txt” upisati podatke samo onih mašina koje su tom prilikom __zaista “servisirane”__.
* Javnu metodu **vratiMasine** koja nema ulaznih argumenata a vraća niz objekata klase
MasinaZaCiscenjeSnega. Ovaj novi niz se formira tako što se kopiraju svi elementi iz postojećeg
niza mašina ali tako da prvo budu uneti svi objekti klase Ratrak, a onda i svi objekti klase Grtalica.
Uz to, ovaj novi niz ne sme da ima praznih mesta tj. elemenata koji imaju NULL vrednost.

#Zadatak 3 - ispravka koda
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