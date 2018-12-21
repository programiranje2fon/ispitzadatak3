package zadatak.masina.sluzba;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import masina.Grtalica;
import masina.Ratrak;
import masina.apstr.MasinaZaCiscenjeSnega;
import masina.sluzba.SluzbaZaPuteve;
import test.TestUtil;

public class SluzbaZaPuteveTest {
	SluzbaZaPuteve instance;

	@Before
	public void setUp() throws Exception {
		instance = new SluzbaZaPuteve(10);
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public void atribut_masina() {
		assertTrue("U klasi SluzbaZaPuteve nije definisan atribut masine",
				TestUtil.doesFieldExist(SluzbaZaPuteve.class, "masine"));
	}
 
	
	@Test
	public void atribut_masina_vidljivost() {
		assertTrue("Atribut masine nije privatan",
				TestUtil.hasFieldModifier(SluzbaZaPuteve.class, "masine", Modifier.PRIVATE));
	}

	@Test
	public void konstruktor_manjeOdNule() {
		int size = -1;
		int expected = 35;
		instance = new SluzbaZaPuteve(size);
		MasinaZaCiscenjeSnega[] masine = (MasinaZaCiscenjeSnega[]) TestUtil.getFieldValue(instance, "masine");
		int actual = masine.length;
		assertTrue("Za prosledjeni argument " + size + " konstruktor inicijalizuje atribut masine na velicinu " + actual
				+ ", umesto na " + expected, actual == expected);
	}

	@Test
	public void konstruktor_Nula() {
		int size = 0;
		int expected = 35;
		instance = new SluzbaZaPuteve(size);
		MasinaZaCiscenjeSnega[] masine = (MasinaZaCiscenjeSnega[]) TestUtil.getFieldValue(instance, "masine");
		int actual = masine.length;
		assertTrue("Za prosledjeni argument " + size + " konstruktor inicijalizuje atribut masine na velicinu " + actual
				+ ", umesto na " + expected, actual == expected);
	}

	@Test
	public void konstruktor_veceOdNule() {
		int size = 5;
		int expected = 5;
		instance = new SluzbaZaPuteve(size);
		MasinaZaCiscenjeSnega[] masine = (MasinaZaCiscenjeSnega[]) TestUtil.getFieldValue(instance, "masine");
		int actual = masine.length;
		assertTrue("Za prosledjeni argument " + size + " konstruktor inicijalizuje atribut masine na velicinu " + actual
				+ ", umesto na " + expected, actual == expected);
	}

	@Test
	public void metoda_unesiMasinu_vidljivost() {
		assertTrue("Metoda unesiMasinu nije javna", TestUtil.hasMethodModifier(SluzbaZaPuteve.class, "unesiMasinu",
				new Class<?>[] { MasinaZaCiscenjeSnega.class }, Modifier.PUBLIC));
	}

	private void add() {
		MasinaZaCiscenjeSnega[] masine = (MasinaZaCiscenjeSnega[]) TestUtil.getFieldValue(instance, "masine");
		masine[0] = new Grtalica();
		masine[1] = new Ratrak();
		masine[2] = new Grtalica();
	}

	@Test(timeout = 2000)
	public void metoda_unesiMasinu_imaMesta() throws Exception {
		add();
		MasinaZaCiscenjeSnega[] masine = (MasinaZaCiscenjeSnega[]) TestUtil.getFieldValue(instance, "masine");
		int first = Integer.MAX_VALUE;
		for (int i = 0; i < masine.length; i++)
			if (masine[i] == null) {
				first = i;
				break;
			}
		MasinaZaCiscenjeSnega temp = new Ratrak();
		instance.unesiMasinu(temp);
		System.out.println(" " + (masine[first] != null) + " " + masine[first].equals(temp));
		assertTrue("Metoda unesiMasinu ne unosi novu masinu na prvo slobodno mesto",
				masine[first] != null && masine[first].equals(temp));
	}

	@Test(expected = Exception.class)
	public void metoda_unesiMasinu_nemaMesta() throws Exception {
		instance = new SluzbaZaPuteve(3);
		add();
		instance.unesiMasinu(new Ratrak());
		assertTrue("Metoda unesiMasinu ne baca proveravani izuzetak iako u nizu nema vise mesta", false);
	}

	@Test
	public void metoda_servisirajSveMasine_vidljivost() {
		assertTrue("Metoda servisirajSveMasine nije javna",
				TestUtil.hasMethodModifier(SluzbaZaPuteve.class, "servisirajSveMasine", null, Modifier.PUBLIC));
	}

	@Test(timeout = 2000)
	public void metoda_servisirajSveMasine() {
		//Potrebno uraditi
		//Problem je to sto nije navedeno u tekstu
		//u kom formatu je potrebno zapisivati podatke o masinama
	}

	@Test
	public void metoda_vratiMasine_vidljivost() {
		assertTrue("Metoda vratiMasine nije javna",
				TestUtil.hasMethodModifier(SluzbaZaPuteve.class, "vratiMasine", null, Modifier.PUBLIC));
	}

	@Test(timeout = 2000)
	public void metoda_vratiMasine() {
		List<MasinaZaCiscenjeSnega> list = new LinkedList<>();
		MasinaZaCiscenjeSnega[] masine = (MasinaZaCiscenjeSnega[]) TestUtil.getFieldValue(instance, "masine");
		for (int i = 0; i < masine.length; i++) {
			if (masine[i] != null) {
				list.add(masine[i]);
			}
		}
		MasinaZaCiscenjeSnega[] result = instance.vratiMasine();
		assertTrue("Vraceni niz nije odgovarajuce duzine", result.length == list.size());
		// kada prodje prvi deo niza u kome su samo ratraci
		// dobija vrednost false
		boolean ratrak = true;
		for (int i = 0; i < result.length; i++) {
			assertTrue("Niz sadrzi null vrednosti", result[i] != null);
			assertTrue("Niz ne sadrzi sve masine", list.contains(result[i]));

			if (ratrak) {
				if (result[i] instanceof Ratrak)
					continue;
				else {
					ratrak = false;
					continue;
				}
			}
			// ako smo naisli na prvu Grtalicu
			// vise se ne smeju pojavljivati Ratraci
			if (result[i] instanceof Ratrak)
				assertTrue("U nizu se nakon Grtalice pojavljuje Ratrak", false);
		}
	}

}
