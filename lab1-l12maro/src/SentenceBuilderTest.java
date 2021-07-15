import static org.junit.jupiter.api.Assertions.*;
import junit.framework.TestCase;
import org.junit.Assert;
import java.util.*;

import java.io.FileNotFoundException;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class SentenceBuilderTest extends TestCase {
    public void testHasNext() {
        try {
            SentenceBuilder test = new SentenceBuilder("tuebadz_1-50-utf8.export");
            assertTrue(test.hasNext());
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public void testNext() {
        try {
            SentenceBuilder test = new SentenceBuilder("tuebadz_1-50-utf8.export");
            ArrayList<Word> expected = new ArrayList<Word>(50);
            expected.add(new Word("Veruntreute", "VVFIN"));
            expected.add(new Word("die", "ART"));
            expected.add(new Word("AWO", "NN"));
            expected.add(new Word("Spendengeld", "NN"));
            expected.add(new Word("?", "$."));
            ArrayList<Word> result = test.next();
            for (int i = 0; i < result.size(); i++) {
                assertEquals(result.get(i), expected.get(i));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}