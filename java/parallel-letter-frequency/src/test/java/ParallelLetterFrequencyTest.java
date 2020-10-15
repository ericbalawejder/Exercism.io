import org.junit.*;

import static org.junit.Assert.*;

import java.util.concurrent.*;
import java.util.stream.*;
import java.util.*;

public class ParallelLetterFrequencyTest {

    // American national anthem
    private String starSpangledBanner =
            "O say can you see by the dawn's early light,\n" +
                    "What so proudly we hailed at the twilight's last gleaming,\n" +
                    "Whose broad stripes and bright stars through the perilous fight,\n" +
                    "O'er the ramparts we watched, were so gallantly streaming?\n" +
                    "And the rockets' red glare, the bombs bursting in air,\n" +
                    "Gave proof through the night that our flag was still there;\n" +
                    "O say does that star-spangled banner yet wave,\n" +
                    "O'er the land of the free and the home of the brave?\n";

    private String diacriticText =
            "a b c d e f g h i j k l m n o p q r s t u v w x y z à á â ã ä å æ ç è é ê ë ì" +
                    " í î ï ð ñ ò ó ô õ ö ø ù ú û ü ý þ ÿ ā ă ą ć ĉ ċ č ď đ ē ĕ ė ę ě ĝ ğ ġ" +
                    " ģ ĥ ħ ĩ ī ĭ į ı ĳ ĵ ķ ĺ ļ ľ ŀ ł ń ņ ň ŋ ō ŏ ő œ ŕ ŗ ř ś ŝ ş š ţ ť ŧ ũ ū" +
                    " ŭ ů ű ų ŵ ŷ ź ż ž ơ ư ǎ ǐ ǒ ǔ ǖ ǘ ǚ ǜ ḍ ḏ ḑ ḓ ḕ ḗ ḙ ḛ ḝ ḟ ḡ ḣ ḥ ḧ ḩ ḫ ḭ" +
                    " ḯ ḱ ḳ ḵ ḷ ḹ ḻ ḽ ḿ ṁ ṃ ṅ ṇ ṉ ṋ ṍ ṏ ṑ ṓ ṕ ṗ ṙ ṛ ṝ ṟ ṡ ṣ ṥ ṧ ṩ ṫ ṭ ṯ ṱ ṳ ṵ" +
                    " ṷ ṹ ṻ ṽ ṿ ẁ ẃ ẅ ẇ ẉ ẋ ẍ ẏ ẑ ẓ ẕ ạ ả ấ ầ ẩ ẫ ậ ắ ằ ẳ ẵ ặ ẹ ẻ ẽ ế ề ể ễ ệ ỉ" +
                    " ị ọ ỏ ố ồ ổ ỗ ộ ớ ờ ở ỡ ợ ụ ủ ứ ừ ử ữ ự ỳ ỵ ỷ ǻ ǽ ǿ α β γ δ ε ζ η θ ι κ λ" +
                    " μ ν ξ ο π ρ σ τ υ φ χ ψ ω ";

    @Test
    public void noTextsMeansNoLetters() {
        String input = "";
        Map<Integer, Integer> expectedOutput = new HashMap<>();
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertEquals(expectedOutput, p.letterCounts());
    }

    //@Ignore("Remove to run test")
    @Test
    public void oneLetterIsCorrectlyCounted() {
        String input = "a";
        Map<Integer, Integer> expectedOutput = new HashMap<>() {
            {
                put((int) 'a', 1);
            }
        };
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertEquals(expectedOutput, p.letterCounts());
    }

    //@Ignore("Remove to run test")
    @Test
    public void resultsAreCaseInsensitive() {
        String input = "Aa";
        Map<Integer, Integer> expectedOutput = new HashMap<>() {
            {
                put((int) 'a', 2);
            }
        };
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertEquals(expectedOutput, p.letterCounts());
    }


    //@Ignore("Remove to run test")
    @Test
    public void biggerEmptyTextsStillReturnNoResults() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            b.append(" ");
        }

        Map<Integer, Integer> expectedOutput = new HashMap<>();
        ParallelLetterFrequency p = new ParallelLetterFrequency(b.toString());

        assertEquals(expectedOutput, p.letterCounts());
    }

    //@Ignore("Remove to run test")
    @Test
    public void manyRepetitionsOfTheSameTextGiveAPredictableResult() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            b.append("abc");
        }

        Map<Integer, Integer> expectedOutput = new HashMap<>() {
            {
                put((int) 'a', 10000);
                put((int) 'b', 10000);
                put((int) 'c', 10000);
            }
        };
        ParallelLetterFrequency p = new ParallelLetterFrequency(b.toString());

        assertEquals(expectedOutput, p.letterCounts());
    }

    //@Ignore("Remove to run test")
    @Test
    public void punctuationDoesntCount() {
        ParallelLetterFrequency p = new ParallelLetterFrequency(starSpangledBanner);

        assertFalse(p.letterCounts().containsKey((int) ','));
    }

    //@Ignore("Remove to run test")
    @Test
    public void numbersDontCount() {
        ParallelLetterFrequency p = new ParallelLetterFrequency("Testing, 1, 2, 3");

        assertFalse(p.letterCounts().containsKey((int) '1'));
    }

    //@Ignore("Remove to run test")
    @Test
    public void testDiacriticCharacter() {
        ParallelLetterFrequency p = new ParallelLetterFrequency(diacriticText);

        assertTrue(p.letterCounts().containsKey((int) 'ṻ'));
    }

    //@Ignore("Remove to run test")
    @Test
    public void testDiacriticCharacterNotIncluded() {
        ParallelLetterFrequency p = new ParallelLetterFrequency(diacriticText);

        assertFalse(p.letterCounts().containsKey((int) 'β'));
    }
}
