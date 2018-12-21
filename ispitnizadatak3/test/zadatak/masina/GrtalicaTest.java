package zadatak.masina;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

	private static boolean uporedi(GregorianCalendar g1, GregorianCalendar g2) {
		return g1.get(GregorianCalendar.YEAR) == g2.get(GregorianCalendar.YEAR)
				&& g1.get(GregorianCalendar.MONTH) == g2.get(GregorianCalendar.MONTH)
				&& g1.get(GregorianCalendar.DAY_OF_MONTH) == g2.get(GregorianCalendar.DAY_OF_MONTH);
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
		GregorianCalendar vremeServisa = new GregorianCalendar();
		vremeServisa.add(Calendar.DATE, -1);
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
				+ vremeServisa.getTime().toString(), result);
		GregorianCalendar novoVremeServisa = new GregorianCalendar();
		novoVremeServisa.set(novoVremeServisa.get(GregorianCalendar.YEAR) + 1,
				novoVremeServisa.get(GregorianCalendar.MONTH), novoVremeServisa.get(GregorianCalendar.DAY_OF_MONTH));
		assertTrue("Nakon izvrsenja metode servisiraj vreme servisa je promenjeno sa "
				+ vremeServisa.getTime().toString() + " na " + instance.getVremeServisa().getTime().toString()
				+ " umesto na " + novoVremeServisa.getTime().toString(),
				uporedi(novoVremeServisa, instance.getVremeServisa()));

	}

	@Test
	public void metoda_servisiraj_datumUBuducnosti() {
		GregorianCalendar vremeServisa = new GregorianCalendar(new GregorianCalendar().get(GregorianCalendar.YEAR) + 1,
				1, 1);
		instance.setVremeServisa(vremeServisa);
		boolean result = instance.servisiraj();
		assertTrue("Metoda servisiraj vraca " + result + " iako je vrednost atributa vremeServisa "
				+ vremeServisa.getTime().toString(), !result);
		assertTrue(
				"Nakon izvrsenja metode servisiraj vreme servisa je promenjeno sa " + vremeServisa.getTime().toString()
						+ " na " + instance.getVremeServisa().getTime().toString(),
				uporedi(vremeServisa, instance.getVremeServisa()));
	}
}
