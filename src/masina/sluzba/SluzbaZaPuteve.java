package masina.sluzba;

import java.io.FileWriter;
import java.io.PrintWriter;

import masina.apstr.MasinaZaCiscenjeSnega;
import masina.Ratrak;
import masina.Grtalica;

public class SluzbaZaPuteve {
	
	private MasinaZaCiscenjeSnega[] masine;
	
	public SluzbaZaPuteve(int kapacitet){
		if (kapacitet>0)
			masine = new MasinaZaCiscenjeSnega[kapacitet];
		else
			masine = new MasinaZaCiscenjeSnega[35];
	}
	
	public void unesiMasinu(MasinaZaCiscenjeSnega m) throws Exception{
		for (int i=0;i<masine.length;i++) {
			if (masine[i]==null){
				masine[i]=m;
				return;
			}
		}
		
		throw new Exception("U nizu nema mesta");
	}
	
	public void servisirajSveMasine(){
		try{
			PrintWriter out = new PrintWriter(new FileWriter("servis.txt"));
			
			//Prolazi se kroz niz i za svaku masinu koja nije null
			//i koja je servisirana (metoda servisiraj vraca tad true)
			//njeni podaci se upisuju u tekstualni fajl.
			for (int i = 0; i < masine.length; i++) {
				if (masine[i]!=null && masine[i].servisiraj())
					out.println(masine[i]);
			}
			
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public MasinaZaCiscenjeSnega[] vratiMasine(){
		//Prvo treba prebrojati koliko u nizu masina ima
		//elemenata koji nisu null (brojac). To ce biti kapacitet
		//novog niza.
		int brojac = 0;
		for (int i = 0; i < masine.length; i++)
			if (masine[i]!=null) brojac++;
		
		//Inicijalizuje se novi niz ali tako da njegov kapacitet
		//bude jednak broju elemenata iz niza masina koji nisu null.
		//Brojac elemenata novog niza se postavlja na 0.
		MasinaZaCiscenjeSnega[] noviNiz = new MasinaZaCiscenjeSnega[brojac];
		int brojElemenata = 0;
		
		//Unosenje svih ratraka u niz od pocetka niza pa dokle se popuni
		for (int i = 0; i < masine.length; i++) 
			if (masine[i]!=null && (masine[i] instanceof Ratrak)){
				noviNiz[brojac]=masine[i];
				brojac++;
			}

		//Unosenje svih grtalica u niz na sva preostala mesta sve do kraja
		for (int i = 0; i < masine.length; i++) 
			if (masine[i]!=null && (masine[i] instanceof Grtalica)){
				noviNiz[brojac]=masine[i];
				brojac++;
			}
		
		return noviNiz;
	}
	

}