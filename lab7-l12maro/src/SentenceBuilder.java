/**
 * A class that builds Word lists from the sentences in a TuBa export file.
 * The name of the export file is given as a parameter to the constructor.
 * Successive calls to the next method read the next sentence from the file
 * and return the ArrayList of Word objects.  The hasNext method determines
 * if there are more sentences in the export file.
 * @author Marie Hinrichs
 */
import java.util.*;
import java.io.*;

public class SentenceBuilder {
    private Scanner corpus;
    
    /**
     * Create a SentenceBuilder for the TuBa export file <code>filename</code>.
     * Throws <code>FileNotFoundException</code> when <code>filename</code> does
     * not refer to a file.
     * @param fileName Path to negra export file.
     * @throws FileNotFoundException 
     */ 
    public SentenceBuilder(String fileName) throws FileNotFoundException {
        corpus = new Scanner(new File(fileName));
    }
    
    /**
     * Return the next sentence in the corpus as an ArrayList of Words.
     * 
     * @return The next sentence in the corpus as an ArrayList of Words.
     */ 
    public ArrayList<Word> next() {
        ArrayList<Word> sentence = new ArrayList<Word>();
        Scanner lineScan;
        String line, word, tag;
        
        /*
         Read file line by line, looking for the next #BOS
         Ignore any lines not within #BOS and #EOS
         Create Words from each line within a sentence and store them in a list
         until the #EOS marker is reached
         */
        
        boolean withinSent = false;  // true if we are inside a sentence
        while (corpus.hasNextLine()) {
            line = corpus.nextLine();
            lineScan = new Scanner(line);
            
            if (line.startsWith("#EOS")) {
                withinSent = false;  // stop reading, end of sentence
                break;  // out of the while loop
            }
            
            if (line.startsWith("#BOS")) {
                withinSent = true;  // sentence starts on the next line
                lineScan.next();
                continue;  // go back to top of while loop
            }
            
            if (line.startsWith("#")) {
                continue;
            }
            
            if (!withinSent)  //not within a sentence, continue loop
                continue;
            
            // Get the Word data
            word = lineScan.next();   // get the word
            tag = lineScan.next();    // get the tag
            
            // Create a Word object and add it to the sentence
            sentence.add(new Word(word, tag));
        }
        return sentence;
    } 
    
    /**
     * Return true if there is another sentence to process in the file
     * associated with this SentenceBuilder.
     */
    public boolean hasNext() {
        return corpus.hasNextLine();
    }
}
