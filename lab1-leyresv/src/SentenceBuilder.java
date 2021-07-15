import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Course:      Data Structures and Algorithms for Language Processing II 2021
 * Assignment:  Lab 1 - Exercise 1
 * Author:      Leyre Sanchez Vinuela
 * Description: Class that builds word lists from the sentences in a negra export file
 *
 * Honor Code:  I pledge that this program represents my own work.
 *  I received help from nobody in designing and debugging my program.
 *
 * A class that builds word lists from the sentences in a negra export file
 */
public class SentenceBuilder
{
    private Scanner myScanner; //File scanner
    private Scanner lineScan;  //Line scanner
    private String line; // The current line

    /**
     * Create a SentenceBuilder for the TuBa export file filename. Throws FileNotFoundException when filename does not refer to a file
     * @param fileName - the fileName to read the Words from
     * @throws FileNotFoundException if filename does not refer to a file
     */
    public SentenceBuilder(String fileName) throws FileNotFoundException
    {
        // Open input stream
        myScanner = new Scanner(new File(fileName));
    }

    /**
     * Check if there is another sentence to process in the file associated with this SentenceBuilder
     * @return true if there is another sentence to process in the file associated with this SentenceBuilder, false otherwise
     */
    public boolean hasNext()
    {
        // Check every remaining line of the string until we find one that starts with "#BOS"
        while(myScanner.hasNextLine())
        {
            line = myScanner.nextLine();
            if (line.startsWith("#BOS"))
            {
                return true;
            }
        }
        // If none of the remaining lines start with "#BOS", return false
        return false;
    }

    /**
     * Return the next sentence in the corpus as an ArrayList of Words
     * @return The next sentence in the corpus as an ArrayList of Words
     */
    public ArrayList<Word> next()
    {
        // Create an empty ArrayList of Words
        ArrayList<Word> sentence = new ArrayList<Word>();
        // Check if there's a remaining sentence to process
        if(hasNext()) {
            while (true) {
                // Create a new line scanner
                lineScan = new Scanner(line);
                // Get the first word of the next line
                String first = lineScan.next();

                // If the first word of the line indicates the end of the sentence, break
                if (first.equals("#EOS")) {
                    break;
                }

                // If the first word of the line is a word of a sentence (form):
                else if (!first.startsWith("#")) {
                    // get the next word of the line (pos tag)
                    String second = lineScan.next();
                    // create a new Word with the collected form and pos tag
                    Word word = new Word(first, second);
                    // add the Word to the ArrayList
                    sentence.add(word);
                }
                // Advance the scanner past the current line
                line = myScanner.nextLine();
            }
        }
        else{
            System.out.println("End of the file");
        }
        return sentence;
    }

    /**
     * Close the input stream
     */
    public void close()
    {
        myScanner.close();
    }
}