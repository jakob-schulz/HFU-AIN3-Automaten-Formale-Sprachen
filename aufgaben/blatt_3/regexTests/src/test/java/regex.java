import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class regex {

    @Test
    public void testTask52() {
        String task52 = "(b|c|aa*c|aa*b(aa*b)*(b|aa*c))*aa*b(aa*b)*c";
        assertTrue(Pattern.matches(task52, "abc"));
        assertTrue(Pattern.matches(task52, "cabc"));
        assertFalse(Pattern.matches(task52, "abcabc"));
        assertTrue(Pattern.matches(task52, "aabbccaabbccabc"));
        assertFalse(Pattern.matches(task52, "aabbccaabccabc"));
        assertFalse(Pattern.matches(task52, "ababcaaaabc"));
        assertFalse(Pattern.matches(task52, "abababcacacabc"));
        assertFalse(Pattern.matches(task52, "ababab"));
        assertFalse(Pattern.matches(task52, "aaaaaaa"));
        assertFalse(Pattern.matches(task52, "cccc"));
        assertFalse(Pattern.matches(task52, "abbacacbaaaaab"));
        assertFalse(Pattern.matches(task52, "abababab"));
        assertFalse(Pattern.matches(task52, "babab"));
        assertTrue(Pattern.matches(task52, "aaaaabc"));
    }

    @Test
    public void testTask53() {
        String task53 = "(b|c|aa*c|aa*b(aa*b)*(b|aa*c))*(aa*b)*a*";
        assertFalse(Pattern.matches(task53, "abc"));
        assertFalse(Pattern.matches(task53, "cabc"));
        assertFalse(Pattern.matches(task53, "abcabc"));
        assertFalse(Pattern.matches(task53, "aabbccaabbccabc"));
        assertFalse(Pattern.matches(task53, "aabbccaabccabc"));
        assertFalse(Pattern.matches(task53, "ababcaaaabc"));
        assertFalse(Pattern.matches(task53, "abababcacacabc"));
        assertTrue(Pattern.matches(task53, "ababab"));
        assertTrue(Pattern.matches(task53, "aaaaaaa"));
        assertTrue(Pattern.matches(task53, "cccc"));
        assertTrue(Pattern.matches(task53, "abbacacbaaaaab"));
        assertTrue(Pattern.matches(task53, "abababab"));
        assertTrue(Pattern.matches(task53, "babab"));
    }
}
