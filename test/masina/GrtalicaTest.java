package masina;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import masina.Grtalica;

public class GrtalicaTest {
	Grtalica instance;

	@Before
	public void setUp() throws Exception {
		instance = new Grtalica();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public void metoda_servisiraj_datumProsao() {
		Field f1 = null;
		try {
			f1 = instance.getClass().getSuperclass().getDeclaredField("vremeServisa");
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f1.setAccessible(true);
		LocalDate vremeServisa = LocalDate.now().minusDays(3);
		try {
			f1.set(instance, vremeServisa);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean result = instance.servisiraj();
		assertTrue("Metoda servisiraj vraca " + result + " iako je vrednost atributa vremeServisa "
				+ vremeServisa, result);
		LocalDate novoVremeServisa = instance.getVremeServisa();

		assertTrue("Nakon izvrsenja metode servisiraj vreme servisa je promenjeno sa "
				+ vremeServisa + " na " + novoVremeServisa
				+ " umesto na " + vremeServisa.plusYears(1),
				novoVremeServisa.minusYears(1).equals(vremeServisa));

	}

	@Test
	public void metoda_servisiraj_datumUBuducnosti() {
		LocalDate vremeServisa = LocalDate.now().plusYears(1);
		instance.setVremeServisa(vremeServisa);
		boolean result = instance.servisiraj();
		assertTrue("Metoda servisiraj vraca " + result + " iako je vrednost atributa vremeServisa "
				+ vremeServisa.toString(), !result);
		assertTrue(
				"Nakon izvrsenja metode servisiraj vreme servisa je greskom promenjeno sa " + vremeServisa
						+ " na " + instance.getVremeServisa().toString(),
				vremeServisa.equals(instance.getVremeServisa()));
	}
}
