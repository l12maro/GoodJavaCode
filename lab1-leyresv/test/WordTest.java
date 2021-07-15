import junit.framework.TestCase;
public class WordTest extends TestCase{

    public void testDefaultCostructor(){
        Word word = new Word();
        String expectedForm = "";
        String expectedPosTag = "";

        assertEquals(expectedForm, word.getForm());
        assertEquals(expectedPosTag, word.getTag());
    }

    public void testFullConstructor(){
        Word word = new Word("sun", "noun");
        String expectedForm = "sun";
        String expectedPosTag = "noun";

        assertEquals(expectedForm, word.getForm());
        assertEquals(expectedPosTag, word.getTag());
    }

    public void testToString(){
        Word word = new Word("sun", "noun");
        String expectedString = "sun noun";

        assertEquals(expectedString, word.toString());
    }

    public void testEquals(){
        Word word1 = new Word("sun", "noun");
        Word word2 = new Word("SUN", "noun");

        assertFalse(word1.equals(word2));
    }
}
