package masina;

import java.util.GregorianCalendar;

import masina.apstr.MasinaZaCiscenjeSnega;

public class Ratrak extends MasinaZaCiscenjeSnega {

	public boolean servisiraj() {
		if (getVremeServisa().before(new GregorianCalendar())){
			GregorianCalendar novoVremeServisa = getVremeServisa();
			
			//Novo vreme servisa se postavlja na godinu dana kasnije
			novoVremeServisa.set(novoVremeServisa.get(GregorianCalendar.YEAR)+1,
					novoVremeServisa.get(GregorianCalendar.MONTH),
					novoVremeServisa.get(GregorianCalendar.DAY_OF_MONTH));
			
			setVremeServisa(novoVremeServisa);
			return true;
		}
		else return false;
	}

}