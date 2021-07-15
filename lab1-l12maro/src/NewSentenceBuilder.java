
/**
 * Course:      Data Structures and Algorithms for Language Processing II 2021
 * Assignment:  (lab 1)
 * Author:      (Lorena Martin Rodriguez)
 * Description: (This program builds word lists from the sentences in a negra export file.)
 *
 * Honor Code:  I pledge that this program represents my own work.
 *  I received help from:
 *   (no one)
 *  in designing and debugging my program.
 *
 */

        import com.sun.org.apache.xpath.internal.functions.FuncFalse;
        import java.io.*;
        import java.util.*;

public class NewSentenceBuilder
{
    //declare variables used by several methods
    private int index;
    private ArrayList<String> lines;
    private Scanner inputStream;
    /**
     * Create a SentenceBuilder for the TuBa export file filename.
     * Throws FileNotFoundException when filename does not refer to a file.
     * @param fileName - the name of the input file
     * @throws FileNotFoundException when filename does not refer to a file.
     */
    public NewSentenceBuilder(String fileName) throws FileNotFoundException  {
        //initialize variables
        index = 0;
        lines = new ArrayList<String>(50);
        //Open the export file
        inputStream = new Scanner(new File(fileName));
        //readLines
        String line;
        while (inputStream.hasNextLine()){
            //Check if line is null
            line = inputStream.nextLine();
            if (line == null) {
                break;
            }
            else {
                //If line is not null, add to ArrayList
                lines.add(line);
            }
        }
    }
    /**
     * Return true if there is another sentence to process in the file associated with this SentenceBuilder.
     * @return true
     */
    public boolean hasNext(){
        //iterate through lines in ArrayList from index
        for (int i = index; i < lines.size(); i++){
            String l = lines.get(i);
            index++;
            //Check if line starts with #BOS
            if (l.substring(0,4).equalsIgnoreCase("#BOS")) {
                return true;
            }
        }
        //If the end of ArrayList is reached without finding #BOS, hasNext is false
        return false;
    }
    /**
     * Return the next sentence in the corpus as an ArrayList of Words.
     * @return the next sentence in the corpus as an ArrayList of Words.
     */
    public ArrayList<Word> next() {
        //Create ArrayList of Words
        ArrayList<Word> list = new ArrayList<Word>(50);
        String[] wordParts;
        //if there is next, iterate through the lines until end is reached
        if (hasNext()) {
            boolean isEnd = false;
            while (isEnd == false) {
                String l = lines.get(index);
                //Once sentences start with '#', no more words are found in the sentence
                if (l.charAt(0) == '#') {
                    isEnd = true;
                }
                else {
                    //words are separated by at least one tab
                    wordParts = l.split("\\t+");
                    //the Word class only needs the first two elements in the line
                    list.add(new Word(wordParts[0], wordParts[1]));
                    index++;
                }
            }
        }
        //If no more sentences are available, state so and close the file
        else {
            System.out.println("No more sentences available");
            close();
        }
        return list;
    }

    /**
     * Close the input file
     */
    public void close(){
        inputStream.close();
    }
}

