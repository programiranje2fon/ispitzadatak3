package ispravka_koda;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ispravka_koda.UcitavanjeSaTastature3;
import test.TestUtil;

public class UcitavanjeSaTastature3Test {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
	
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
	private String pomocna(int broj) {
		int pomocni = broj;
		int sumaCifara = 0;
		while (broj > 0) {
			sumaCifara = sumaCifara + broj % 10;
			broj = broj / 10;
		}
		if (pomocni % sumaCifara == 0)
			return "Jeste";
		return "Nije";
	}
	
	@Test
	public void metoda_ucitajIProveriNivenov_vidljivost() {
		assertTrue("Metoda ucitajIProveriNivenov nije javna", TestUtil.hasMethodModifier(UcitavanjeSaTastature3.class, "ucitajIProveriNivenov", null, Modifier.PUBLIC));
	}
	
	@Test
	public void metoda_ucitajIProveriNivenov() {
		for(int i = 1; i <= 1000; i++) {
			UcitavanjeSaTastature3.ucitajIProveriNivenov();
			InputStream fakeIn = new ByteArrayInputStream(ByteBuffer.allocate(4).putInt(i).array());
			System.setIn(fakeIn);
			String rezultat = outContent.toString().trim();
			originalOut.println(rezultat);
			String ocekivano = pomocna(i);
			assertTrue("Za uneti argument "+i+" metoda ucitajIProveriNivenov vraca "+rezultat, ocekivano.equalsIgnoreCase(rezultat));
		}
	}
}
