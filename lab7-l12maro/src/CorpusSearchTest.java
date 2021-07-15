/**
 * Course:      Data Structures and Algorithms for Computational Linguistics II SS2021
 * Assignment:  (7, 2)
 * Author:      (Lorena Martin Rodriguez)
 * Description: (A test case for Corpus Search)
 *
 * Honor Code:  I pledge that this program represents my own work.
 *  I received help from:
 *   (no one)
 *  in designing and debugging my program.
 */
import junit.framework.TestCase;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.function.Predicate;

public class CorpusSearchTest extends TestCase {
    public void testSearch1() {
        try{
            CorpusSearch test = new CorpusSearch("src/tuebadz_1-50-utf8.export");
            Predicate<Word> matcher = (m) -> m.getForm().equalsIgnoreCase("in");
            List<Word> result = test.search(matcher);
            assertEquals(18, result.size());
        }
        catch (FileNotFoundException e)
        {
            fail();
        }

    }
    public void testSearch2() {
        try{
            CorpusSearch test = new CorpusSearch("src/tuebadz_1-50-utf8.export");
            Predicate<Word> matcher = (m) -> m.getForm().equalsIgnoreCase("für") &&
            m.getTag().equalsIgnoreCase("APPR");

            List<Word> result = test.search(matcher);
            assertEquals(13, result.size());
        }
        catch (FileNotFoundException e)
        {
            fail();
        }
    }
    public void testSearch3() {
        try{
            CorpusSearch test = new CorpusSearch("src/tuebadz_1-50-utf8.export");
            Predicate<Word> matcher = (m) -> m.getTag().startsWith("VV");

            List<Word> result = test.search(matcher);
            assertEquals(73, result.size());
        }
        catch (FileNotFoundException e)
        {
            fail();
        }
    }
    public void testSearch4() {
        try{
            CorpusSearch test = new CorpusSearch("src/tuebadz_1-50-utf8.export");
            Predicate<Word> matcher = (m) -> (m.getForm().equalsIgnoreCase("für") ||
                    m.getForm().equalsIgnoreCase("in")) &&
                    m.getTag().equalsIgnoreCase("APPR");

            List<Word> result = test.search(matcher);
            assertEquals(31, result.size());
        }
        catch (FileNotFoundException e)
        {
            fail();
        }
    }



}