import static org.junit.jupiter.api.Assertions.*;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class WordTest extends TestCase {
    public void testGetMethod1() {
        Word testWord = new Word();
        String expected = "Default";
        assertEquals(testWord.getForm(), expected);
        assertEquals(testWord.getTag(), expected);
    }
    public void testGetMethod2() {
        Word testWord = new Word("Hi");
        String formExpected = "Hi";
        String expected = "Default";
        assertEquals(testWord.getForm(), formExpected);
        assertEquals(testWord.getTag(), expected);
    }
    public void testGetMethod3() {
        Word testWord = new Word("Hi", "NN");
        String formExpected = "Hi";
        String tagExpected = "NN";
        assertEquals(testWord.getForm(), formExpected);
        assertEquals(testWord.getTag(), tagExpected);
    }
    public void testToString() {
        Word testWord = new Word("Hi", "NN");
        String expected = "Hi | NN";
        assertEquals(testWord.toString(), expected);
    }
    public void testEquals1() {
        Word testWord = new Word("Hi", "NN");
        Object testObj = new Object();
        assertFalse(testWord.equals(testObj));
    }
    public void testEquals2() {
        Word testWord = new Word("Hi", "NN");
        Object testObj = null;
        assertFalse(testWord.equals(testObj));
    }
    public void testEquals3() {
        Word testWord = new Word("Hi", "NN");
        Object testObj = new Word("Hi", "ADJ");
        assertFalse(testWord.equals(testObj));
    }
    public void testEquals() {
        Word testWord = new Word("Hi", "NN");
        Object testObj = new Word("Hi", "NN");
        assertTrue(testWord.equals(testObj));
    }
}