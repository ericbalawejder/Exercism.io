import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class IsbnVerifierTest {
    private IsbnVerifier isbnVerifier;

    @Before
    public void setUp() {
        isbnVerifier = new IsbnVerifier();
    }

    @Test
    public void validIsbnNumber() {
        assertTrue(isbnVerifier.isValid("3-598-21508-8"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void invalidIsbnCheckDigit() {
        assertFalse(isbnVerifier.isValid("3-598-21508-9"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void validIsbnNumberWithCheckDigitOfTen() {
        assertTrue(isbnVerifier.isValid("3-598-21507-X"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void checkDigitIsACharacterOtherThanX() {
        assertFalse(isbnVerifier.isValid("3-598-21507-A"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void invalidCharacterInIsbn() {
        assertFalse(isbnVerifier.isValid("3-598-P1581-X"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void xIsOnlyValidAsACheckDigit() {
        assertFalse(isbnVerifier.isValid("3-598-2X507-9"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void validIsbnWithoutSeparatingDashes() {
        assertTrue(isbnVerifier.isValid("3598215088"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void isbnWithoutSeparatingDashesAndXAsCheckDigit() {
        assertTrue(isbnVerifier.isValid("359821507X"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void isbnWithoutCheckDigitAndDashes() {
        assertFalse(isbnVerifier.isValid("359821507"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void tooLongIsbnAndNoDashes() {
        assertFalse(isbnVerifier.isValid("3598215078X"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void tooShortIsbn() {
        assertFalse(isbnVerifier.isValid("00"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void isbnWithoutCheckDigit() {
        assertFalse(isbnVerifier.isValid("3-598-21507"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void checkDigitOfXShouldNotBeUsedForZero() {
        assertFalse(isbnVerifier.isValid("3-598-21515-X"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void emptyIsbn() {
        assertFalse(isbnVerifier.isValid(""));
    }

    //@Ignore("Remove to run test")
    @Test
    public void inputIsNineCharacters() {
        assertFalse(isbnVerifier.isValid("134456729"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void invalidCharactersAreNotIgnored() {
        assertFalse(isbnVerifier.isValid("3132P34035"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void inputIsTooLongButContainsAValidIsbn() {
        assertFalse(isbnVerifier.isValid("98245726788"));
    }

    @Test
    public void validIsbnNumberSurroundedWithLettersIsInvalid() {
        assertFalse(isbnVerifier.isValid("ABCDEFG3-598-21507-XQWERTYUI"));
    }

    // Added tests
    //-------------------------------------------------------------------
    //@Ignore("Remove to run test")
    @Test
    public void testIsValidIsbn13WithPrefix978() {
        assertTrue(isbnVerifier.isValidIsbn13("978-0-123456-47-2"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void testIsValidIsbn13WithPrefix979() {
        assertTrue(isbnVerifier.isValidIsbn13("979-0759313797"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void testIsValidIsbn13WithWrongPrefix() {
        assertFalse(isbnVerifier.isValidIsbn13("179-0759313797"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void testIsValidIsbn13IsTooShort() {
        assertFalse(isbnVerifier.isValidIsbn13("979-075931797"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void testIsValidIsbn13ContainsExtraDigit() {
        assertFalse(isbnVerifier.isValidIsbn13("978-0-123456-47-21"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void testIsValidIsbn13ContainsInvalidCharacter() {
        assertFalse(isbnVerifier.isValidIsbn13("979-0759E13797"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void testIsValidIsbn13IsInvalid() {
        assertFalse(isbnVerifier.isValidIsbn13("979-0-759113-79-7"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void testConvertIsbn10ToIsbn13() {
        String expected = "9783598215087";
        assertEquals(expected, isbnVerifier.convertIsbn10ToIsbn13("3-598-21508-8"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void testConvertIsbn10ToIsbn13ContainsCheckDigit() {
        String expected = "9783598215070";
        assertEquals(expected, isbnVerifier.convertIsbn10ToIsbn13("359821507X"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void testConvertIsbn10ToIsbn13HasInvalidIsbn10Input() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> isbnVerifier.convertIsbn10ToIsbn13("159821507X"));

        String expectedMessage = "Not a valid isbn-10 number.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    //@Ignore("Remove to run test")
    @Test
    public void testConvertIsbn13ToIsbn10() {
        String expected = "0123456472";
        assertEquals(expected, isbnVerifier.convertIsbn13ToIsbn10("978-0-123456-47-2"));
    }

    //@Ignore("Remove to run test")
    @Test
    public void testConvertIsbn13ToIsbn10WithInvalidIsbn13() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> isbnVerifier.convertIsbn13ToIsbn10("979-0-759113-79-7"));

        String expectedMessage = "Not a valid ISBN-13 number.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    //@Ignore("Remove to run test")
    @Test
    public void testConvertIsbn13ToIsbn10WithCheckDigitX() {
        String expected = "000117115X";
        assertEquals(expected, isbnVerifier.convertIsbn13ToIsbn10("9780001171152"));
    }
}
