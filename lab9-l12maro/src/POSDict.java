/**
 * Course:      Data Structures and Algorithms for Language Processing II 2021
 * Assignment:  (lab 9, 1)
 * Author:      (Lorena Martin Rodriguez)
 * Description: (A class to create a Hashing map of a dictionary)
 *
 * Honor Code:  I pledge that this program represents my own work.
 *  I received help from:
 *   (no one)
 *  in designing and debugging my program.
 *
 */
import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

/*
A class to create a Hashing map of a dictionary
 */
public class POSDict {
    //create a HashMap
    private HashMap<String,LinkedList<String>> dictionary= new HashMap<String, LinkedList<String>>(4820);
    /**
     * A constructor which takes the Penn Treebank Tag Set as default value
     */
    public POSDict() throws FileNotFoundException, NullPointerException, IOException{
        this("src/dict.dat");
    }

    /**
     * A constructor for any other dictionaries
     * @param aFilename - the name of the dictionary file
     */
    public POSDict(String aFilename) {
        //read file
        try (BufferedReader dict = new BufferedReader(new FileReader(aFilename))) {
            //Read lines of file
            String line;
            String[] entry;
            LinkedList<String> values;
            //First line is empty so jump it
            dict.readLine();
            line = dict.readLine();
            while(line != null) {
                //split line with space
                entry = line.split("\\s+");
                //check if key is already in HashMap
                if (dictionary.containsKey(entry[0])) {
                    //If yes, retrieve value and add value to LinkedList
                    values = dictionary.get(entry[0]);
                    values.addLast(entry[1]);
                }
                //If no key, create new LinkedList for value
                else {
                    values = new LinkedList<String>();
                    values.add(entry[1]);
                }
                //introduce values in HashMap
                dictionary.put(entry[0], values);
                line = dict.readLine();
            }
        }
        catch (FileNotFoundException e) {
            e.getMessage();
        }
        catch (NullPointerException e) {
            e.getMessage();
        }
        catch (IOException e) {
            e.getMessage();
        }
    }

    /**
     * A method to tell if an element is in the Hashing
     * @param aWord - the word that must be found
     * @param posTag - the tag of the word
     * @return True if word is in the Hashing
     */
    public boolean hasPOS(String aWord, String posTag) {
        //check the values are not null
        if (aWord == null || posTag == null) return false;
        LinkedList<String> values;
        //check if the word given is among the keys
        if (dictionary.containsKey(aWord)) {
            //if yes, iterate through the values to find posTag
            values = dictionary.get(aWord);
            for (String value : values) {
                if (value.equalsIgnoreCase(posTag)) return true;
            }
            //if inner iteration is done, then posTag is not in values
            return false;
        }
        //if aWord is not in keys, return false
        else
            return false;
    }
}
