import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
 
public class Blatt_2_RegexTest {

	@Test
	public void testGleitkommazahlen() {
		String ganzeZahl = "[-+]?(0|[1-9]\\d*)";
		String dezimal = "((\\.(\\d+))?";
		String exponent = "([Ee](0|(-?[1-9]\\d*)))?)?";
		String gleitkomma = ganzeZahl + dezimal + exponent; // Hier Ihren regulaeren Ausdruck eintragen

		assertTrue(Pattern.matches(gleitkomma, "22"));
		assertTrue(Pattern.matches(gleitkomma, "+2"));
		assertTrue(Pattern.matches(gleitkomma, "-10000000"));
		assertTrue(Pattern.matches(gleitkomma, "2244444444"));
		assertTrue(Pattern.matches(gleitkomma, "+2.2"));
		assertTrue(Pattern.matches(gleitkomma, "-23.211111"));
		assertTrue(Pattern.matches(gleitkomma, "-23e1"));
		assertTrue(Pattern.matches(gleitkomma, "23E1"));
		assertTrue(Pattern.matches(gleitkomma, "-23E123456634"));
		assertTrue(Pattern.matches(gleitkomma, "-211113.124566E123456634"));
		assertTrue(Pattern.matches(gleitkomma, "0"));
		assertTrue(Pattern.matches(gleitkomma, "0.0"));

		assertFalse(Pattern.matches(gleitkomma, "00"));
		assertFalse(Pattern.matches(gleitkomma, "1."));
		assertFalse(Pattern.matches(gleitkomma, "|1"));
		assertFalse(Pattern.matches(gleitkomma, "|245"));
		assertFalse(Pattern.matches(gleitkomma, "23e"));
		assertFalse(Pattern.matches(gleitkomma, "23f1"));
		assertFalse(Pattern.matches(gleitkomma, ""));
		assertFalse(Pattern.matches(gleitkomma, ".0"));
		assertFalse(Pattern.matches(gleitkomma, "7..0"));
		assertFalse(Pattern.matches(gleitkomma, "e4"));
		assertFalse(Pattern.matches(gleitkomma, "++e4"));
		assertFalse(Pattern.matches(gleitkomma, "+-12"));
		assertFalse(Pattern.matches(gleitkomma, "+ 12"));
		assertFalse(Pattern.matches(gleitkomma, "1:0"));
		assertFalse(Pattern.matches(gleitkomma, "1.1.0"));

	}

	@Test
	public void testZeitpunkt() {
		String year = "\\d\\d\\d\\d-";
		String time = "T(([01]\\d)|(2[0-3])):[0-5]\\d:[0-5]\\d:\\d\\d\\d";
		String longmonth ="(((0[13578])|(10)|(12))-((0[1-9]|[12]\\d)|(3[01])))";
		String shortmonth ="(((0[469])|(11))-((0[1-9]|[12]\\d)|(30)))";
		String february = "(02-((0[1-9]|1\\d)|2\\d))";
		String zeitpunkt = year + "(" + longmonth + "|"+ shortmonth +"|"+ february +")" + time; // Hier Ihren regulaeren Ausdruck eintragen

		assertTrue(Pattern.matches(zeitpunkt, "2012-09-30T23:28:51:544"));
		assertTrue(Pattern.matches(zeitpunkt, "2012-12-30T12:28:51:544"));
		assertTrue(Pattern.matches(zeitpunkt, "0000-01-01T00:00:00:000"));
		assertTrue(Pattern.matches(zeitpunkt, "2020-12-31T23:59:59:999"));
		
		assertFalse(Pattern.matches(zeitpunkt, "    -  -  T  :  :  :   "));
		assertFalse(Pattern.matches(zeitpunkt, "2012-20-30T23:28:51:544"));
		assertFalse(Pattern.matches(zeitpunkt, "2012-10-32T23:28:51:544"));
		assertFalse(Pattern.matches(zeitpunkt, "012-12-30T22:28:51:544"));
		assertFalse(Pattern.matches(zeitpunkt, " 012-12-30T22:28:51:544"));
		assertFalse(Pattern.matches(zeitpunkt, "2012-00-30T22:28:51:544"));
		assertFalse(Pattern.matches(zeitpunkt, "2012-12-30t5:28:51:544"));
		assertFalse(Pattern.matches(zeitpunkt, "2012-12-30T30:28:51:544"));
		assertFalse(Pattern.matches(zeitpunkt, "2012-12-30T00:8:51:544"));
		assertFalse(Pattern.matches(zeitpunkt, "2012-12-30T21:28:1:544"));
		assertFalse(Pattern.matches(zeitpunkt, "2012-12-30T21:28:511:544"));
		assertFalse(Pattern.matches(zeitpunkt, "2012-12-30T21:28:51:5440"));
	}
	
	@Test
	public void testKFZKennzeichen() {
		String city = "[A-ZÄÜÖ][A-ZÄÜÖ]?[A-ZÄÜÖ]?";
		String letters = "[A-ZÄÜÖ][A-ZÄÜÖ]?";
		String digits = "[1-9]\\d?\\d?\\d?";
		String kennzeichen = city + " " + letters + " " + digits + "( [HE])?"; // Hier Ihren regulaeren Ausdruck eintragen

		assertTrue(Pattern.matches(kennzeichen, "VS HH 1000"));
		assertTrue(Pattern.matches(kennzeichen, "HH HH 1"));
		assertTrue(Pattern.matches(kennzeichen, "H HH 1"));
		assertTrue(Pattern.matches(kennzeichen, "HH HH 1 H"));
		assertTrue(Pattern.matches(kennzeichen, "TÜ HH 1 H"));

		assertFalse(Pattern.matches(kennzeichen, "HH HH 1 "));
		assertFalse(Pattern.matches(kennzeichen, "VS VS 0"));
		assertFalse(Pattern.matches(kennzeichen, "VS VS1 1"));
		assertFalse(Pattern.matches(kennzeichen, "VS 1"));
		assertFalse(Pattern.matches(kennzeichen, "VS ABC 1"));
		assertFalse(Pattern.matches(kennzeichen, "VS HH 0"));
		assertFalse(Pattern.matches(kennzeichen, "VS HH 10000"));
		assertFalse(Pattern.matches(kennzeichen, "VS HH 99 EH"));
		assertFalse(Pattern.matches(kennzeichen, "HVSA HH 1 "));
		assertFalse(Pattern.matches(kennzeichen, "HH HH 01"));
	}
}
