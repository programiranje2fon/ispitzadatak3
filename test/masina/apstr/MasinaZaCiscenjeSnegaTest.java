package masina.apstr;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import masina.Grtalica;
import masina.apstr.MasinaZaCiscenjeSnega;
import test.TestUtil;

public class MasinaZaCiscenjeSnegaTest {
	MasinaZaCiscenjeSnega instance;

	// Radjeno pod pretpostavkom da se u klasama koje nasledjuju
	// MasinuZaCiscenje snega nece overajdovati metode
	// koje su vec implementirane
	@Before
	public void setUp() throws Exception {
		instance = new Grtalica();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public void atribut_markaIModel() {
		assertTrue("Nije definisan atribut markaIModel",
				TestUtil.doesFieldExist(MasinaZaCiscenjeSnega.class, "markaIModel"));
	}

	@Test
	public void atribut_markaIModel_vidljivost() {
		assertTrue("Atribut markaIModel nije privatan",
				TestUtil.hasFieldModifier(MasinaZaCiscenjeSnega.class, "markaIModel", Modifier.PRIVATE));
	}

	@Test
	public void atribut_vremeServisa() {
		assertTrue("Nije definisan atribut vremeServisa",
				TestUtil.doesFieldExist(MasinaZaCiscenjeSnega.class, "vremeServisa"));
	}

	@Test
	public void atribut_vremeServisa_vidljivost() {
		assertTrue("Atribut vremeServisa nije privatan",
				TestUtil.hasFieldModifier(MasinaZaCiscenjeSnega.class, "vremeServisa", Modifier.PRIVATE));
	}

	@Test
	public void metoda_setMarkaIModel_vidljivost() {
		assertTrue("Metoda setMarkaIModel nije javna", TestUtil.hasMethodModifier(MasinaZaCiscenjeSnega.class,
				"setMarkaIModel", new Class<?>[] { String.class }, Modifier.PUBLIC));
	}

	@Test(expected = RuntimeException.class)
	public void metoda_setMarkaIModel_null() {
		String markaIModel = null;
		instance.setMarkaIModel(markaIModel);
		assertTrue("Za prosledjeni argument null metoda setMarkaIModel ne baca neproveravani izuzetak", false);
	}

	@Test(expected = RuntimeException.class)
	public void metoda_setMarkaIModel_bezBlankoZnaka() {
		String markaIModel = "CAT32";
		instance.setMarkaIModel(markaIModel);
		assertTrue("Za prosledjeni argument " + markaIModel + " metoda setMarkaIModel ne baca neproveravani izuzetak",
				false);
	}

	@Test
	public void metoda_setMarkaIModel_SaBlankoZnakom() {
		String markaIModel = "CAT 32";
		try {
			instance.setMarkaIModel(markaIModel);
		} catch (RuntimeException e) {
			assertTrue("Za prosledjeni argument " + markaIModel + " metoda setMarkaIModel baca neproveravani izuzetak",
					false);
			e.printStackTrace();
		}
	}

	@Test
	public void metoda_setVremeServisa_vidljivost() {
		assertTrue("Metoda setVremeServisa nije javna", TestUtil.hasMethodModifier(MasinaZaCiscenjeSnega.class,
				"setVremeServisa", new Class<?>[] { GregorianCalendar.class }, Modifier.PUBLIC));
	}

	@Test(expected = RuntimeException.class)
	public void metoda_setVremeServisa_null() {
		GregorianCalendar vremeServisa = null;
		instance.setVremeServisa(vremeServisa);
		assertTrue("Za prosledjeni argument null metoda setVremeServisa ne baca neproveravani izuzetak", false);
	}

	@Test(expected = RuntimeException.class)
	public void metoda_setVremeServisa_prosliDatum() {
		GregorianCalendar temp = new GregorianCalendar();
		GregorianCalendar vremeServisa = new GregorianCalendar(temp.get(GregorianCalendar.YEAR) - 1,
				temp.get(GregorianCalendar.MONTH), temp.get(GregorianCalendar.DAY_OF_MONTH));
		instance.setVremeServisa(vremeServisa);
		assertTrue("Za prosledjeni argument " + vremeServisa.getTime().toString()
				+ " metoda setVremeServisa ne baca neproveravani izuzetak", false);
	}

	@Test(expected = RuntimeException.class)
	public void metoda_setVremeServisa_trenutniDatum() {
		GregorianCalendar vremeServisa = new GregorianCalendar();
		instance.setVremeServisa(vremeServisa);
		assertTrue("Za prosledjeni argument " + vremeServisa.getTime().toString()
				+ " metoda setVremeServisa ne baca neproveravani izuzetak", false);
	}

	@Test
	public void metoda_setVremeServisa_bubuciDatum() {
		GregorianCalendar temp = new GregorianCalendar();
		GregorianCalendar vremeServisa = new GregorianCalendar(temp.get(GregorianCalendar.YEAR) + 1,
				temp.get(GregorianCalendar.MONTH), temp.get(GregorianCalendar.DAY_OF_MONTH));
		try {
			instance.setVremeServisa(vremeServisa);
		} catch (RuntimeException e) {
			assertTrue("Za prosledjeni argument " + vremeServisa.getTime().toString()
					+ " metoda setVremeServisa baca neproveravani izuzetak", false);
			e.printStackTrace();
		}
	}

	@Test
	public void metoda_toString() {
		String markaIModel = "CAT 32";
		GregorianCalendar vremeServisa = new GregorianCalendar(new GregorianCalendar().get(GregorianCalendar.YEAR) + 1,
				1, 1);
		instance.setMarkaIModel(markaIModel);
		instance.setVremeServisa(vremeServisa);
		String result = instance.toString();
		assertTrue("String koji vraca metoda to String ne sadrzi vrednost atributa markaIModel",
				result.indexOf(instance.getMarkaIModel()) != -1);
		assertTrue("String koji vraca metoda to String ne sadrzi godinu servisa",
				result.indexOf(((Integer) instance.getVremeServisa().get(GregorianCalendar.YEAR)).toString()) != -1);
		assertTrue("String koji vraca metoda to String ne sadrzi dan servisa", result
				.indexOf(((Integer) instance.getVremeServisa().get(GregorianCalendar.DAY_OF_MONTH)).toString()) != -1);
	}

	@Test
	public void metoda_servisiraj() {
		assertTrue("Metoda servisiraj nije javna",
				TestUtil.hasMethodModifier(MasinaZaCiscenjeSnega.class, "servisiraj", null, Modifier.PUBLIC));
	}

}
