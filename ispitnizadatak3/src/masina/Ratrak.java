package masina;

import java.util.GregorianCalendar;

import masina.apstr.MasinaZaCiscenjeSnega;

public class Ratrak extends MasinaZaCiscenjeSnega {

	public boolean servisiraj() {
		if (getVremeServisa().before(new GregorianCalendar())){
			GregorianCalendar vremeServisa = getVremeServisa();
			
			//Novo vreme servisa se postavlja na godinu dana kasnije
			GregorianCalendar novoVremeServisa=new GregorianCalendar();
			novoVremeServisa.set(vremeServisa.get(GregorianCalendar.YEAR)+1,
								 vremeServisa.get(GregorianCalendar.MONTH),
								 vremeServisa.get(GregorianCalendar.DAY_OF_MONTH));
			
			setVremeServisa(novoVremeServisa);
			return true;
		}
		else return false;
	}

}