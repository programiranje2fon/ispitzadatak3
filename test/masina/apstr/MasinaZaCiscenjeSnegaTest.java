package masina.apstr;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;
import java.time.LocalDate;

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
				"setVremeServisa", new Class<?>[] { LocalDate.class }, Modifier.PUBLIC));
	}

	@Test(expected = RuntimeException.class)
	public void metoda_setVremeServisa_null() {
        LocalDate vremeServisa = null;
		instance.setVremeServisa(vremeServisa);
		assertTrue("Za prosledjeni argument null metoda setVremeServisa ne baca neproveravani izuzetak", false);
	}

	@Test(expected = RuntimeException.class)
	public void metoda_setVremeServisa_prosliDatum() {
        LocalDate vremeServisa = LocalDate.now().minusDays(2);
		instance.setVremeServisa(vremeServisa);
		assertTrue("Za prosledjeni argument " + vremeServisa
				+ " metoda setVremeServisa ne baca neproveravani izuzetak", false);
	}

	@Test(expected = RuntimeException.class)
	public void metoda_setVremeServisa_trenutniDatum() {
        LocalDate vremeServisa = LocalDate.now();
		instance.setVremeServisa(vremeServisa);
		assertTrue("Za prosledjeni argument " + vremeServisa
				+ " metoda setVremeServisa ne baca neproveravani izuzetak", false);
	}

	@Test
	public void metoda_setVremeServisa_bubuciDatum() {
        LocalDate vremeServisa = LocalDate.now().plusDays(2);
		try {
			instance.setVremeServisa(vremeServisa);
		} catch (RuntimeException e) {
			assertTrue("Za prosledjeni argument " + vremeServisa
					+ " metoda setVremeServisa baca neproveravani izuzetak", false);
			e.printStackTrace();
		}
	}

	@Test
	public void metoda_toString() {
		String markaIModel = "CAT 32";
        LocalDate vremeServisa = LocalDate.now().plusDays(3);
		instance.setMarkaIModel(markaIModel);
		instance.setVremeServisa(vremeServisa);
		String result = instance.toString();
		assertTrue("String koji vraca metoda to String ne sadrzi vrednost atributa markaIModel",
				result.indexOf(instance.getMarkaIModel()) != -1);
		assertTrue("String koji vraca metoda to String ne sadrzi godinu servisa",
				result.indexOf(vremeServisa.getYear()+"") != -1);
        assertTrue("String koji vraca metoda to String ne sadrzi mesec servisa", result
                .indexOf(vremeServisa.getMonthValue()+"") != -1);
		assertTrue("String koji vraca metoda to String ne sadrzi dan servisa", result
				.indexOf(vremeServisa.getDayOfMonth()+"") != -1);
	}

	@Test
	public void metoda_servisiraj() {
		assertTrue("Metoda servisiraj nije javna",
				TestUtil.hasMethodModifier(MasinaZaCiscenjeSnega.class, "servisiraj", null, Modifier.PUBLIC));
	}

}
