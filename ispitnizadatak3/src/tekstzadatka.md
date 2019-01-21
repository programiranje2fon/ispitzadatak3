#Zadatak 1 – februar 2012
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

