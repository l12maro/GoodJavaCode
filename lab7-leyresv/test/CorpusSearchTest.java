import junit.framework.TestCase;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Course:      Data Structures and Algorithms for Language Processing SS 2021
 * Assignment:	Lab 7 - exercise 2
 * Author:		Leyre Sanchez Vinuela
 * Description: A program to test the CorpusSearch class
 *
 * Honor Code:  I pledge that this program represents my own work.
 * I received help from nobody in designing and debugging my program.
 */

public class CorpusSearchTest extends TestCase {

    // Search number of all words representing word form "in" in the short file
    public void testSearchShort1() throws FileNotFoundException{
        CorpusSearch corpus = new CorpusSearch("src/tuebadz_1-2-utf8.export");
        List<Word> words = corpus.search(w -> w.getForm().equalsIgnoreCase("in"));
        assertEquals(2, words.size());
    }

    // Search number of all words representing word form "in" in the long file
    public void testSearchLong1() throws FileNotFoundException{
        CorpusSearch corpus = new CorpusSearch();
        List<Word> words = corpus.search(w -> w.getForm().equalsIgnoreCase("in"));
        assertEquals(18, words.size());
    }

    // Search number of all words representing POS tag "APPR" and form "für" in the short file
    public void testSearchShort2() throws FileNotFoundException{
        CorpusSearch corpus = new CorpusSearch("src/tuebadz_1-2-utf8.export");
        List<Word> words = corpus.search(w -> {
            return w.getTag().equals("APPR") && w.getForm().equalsIgnoreCase("für");
        });
        assertEquals(1, words.size());
    }

    // Search number of all words representing word form "in" in the long file
    public void testSearchLong2() throws FileNotFoundException{
        CorpusSearch corpus = new CorpusSearch();
        List<Word> words = corpus.search(w -> {
            return w.getTag().equals("APPR") && w.getForm().equalsIgnoreCase("für");
        });
        assertEquals(13, words.size());
    }

    // Search number of all words where the POS tag begins with "VV" in the short file
    public void testSearchShort3() throws FileNotFoundException{
        CorpusSearch corpus = new CorpusSearch("src/tuebadz_1-2-utf8.export");
        List<Word> words = corpus.search(w -> w.getTag().startsWith("VV"));
        assertEquals(3, words.size());
    }

    // Search number of all words where the POS tag begins with "VV" in the long file
    public void testSearchLong3() throws FileNotFoundException{
        CorpusSearch corpus = new CorpusSearch();
        List<Word> words = corpus.search(w -> w.getTag().startsWith("VV"));
        assertEquals(73, words.size());
    }

    // Search number of all words where the POS tag is "APPR" and the form is either "für" or "in" in the short file
    public void testSearchShort4() throws FileNotFoundException{
        CorpusSearch corpus = new CorpusSearch("src/tuebadz_1-2-utf8.export");
        List<Word> words = corpus.search(w -> {
            return w.getTag().equals("APPR") &&
                    (w.getForm().equalsIgnoreCase("für") || w.getForm().equalsIgnoreCase("in"));
        });
        assertEquals(3, words.size());
    }

    // Search number of all words where the POS tag is "APPR" and the form is either "für" or "in" in the long file
    public void testSearchLong4() throws FileNotFoundException{
        CorpusSearch corpus = new CorpusSearch();
        List<Word> words = corpus.search(w -> {
            return w.getTag().equals("APPR") &&
                    (w.getForm().equalsIgnoreCase("für") || w.getForm().equalsIgnoreCase("in"));
        });
        assertEquals(31, words.size());
    }



}
