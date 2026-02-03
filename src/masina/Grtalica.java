package masina;

import java.time.LocalDate;

import masina.apstr.MasinaZaCiscenjeSnega;

public class Grtalica extends MasinaZaCiscenjeSnega {

	public boolean servisiraj() {
		if (getVremeServisa().isBefore(LocalDate.now())){
            LocalDate vremeServisa = getVremeServisa();

			//Novo vreme servisa se postavlja na godinu dana kasnije
            LocalDate novoVremeServisa = vremeServisa.plusYears(1);

			setVremeServisa(novoVremeServisa);
			return true;
		}
		else return false;
	}

}