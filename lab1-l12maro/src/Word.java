/**(
 * Course:      Data Structures and Algorithms for Language Processing II 2021
 * Assignment:  (lab 1)
 * Author:      (Lorena Martin Rodriguez)
 * Description: (This program represents word information in a TuBaTreeBank export file.)
 *
 * Honor Code:  I pledge that this program represents my own work.
 *  I received help from:
 *   (no one)
 *  in designing and debugging my program.
 *
 */
/*
Class to represent the Word information in a TuBaTreeBank export file
 */
public class Word{
    //declare variables common to several methods
    private String form = "";
    private String posTag = "";

    /**
     * Default constructor
     */
    public Word(){
        this("Default", "Default");
    }

    /**
     * Construct a Word object with just a form
     * @param aForm -the Word form
     */
    public Word(String aForm){
        this(aForm,"Default");
    }

    /**
     * Construct a Word with form and tag values
     * @param aForm -the Word form
     * @param aPOSTag -the tag for the Word
     */
    public Word(String aForm, String aPOSTag){
        form = aForm;
        posTag = aPOSTag;
    }

    /**
     * Two Words are equal if the forms and pos tag values are equal, ignoring case
     * @Override equals in class Object
     * @param otherObj - other object to check for equality
     * @return true if the Words have the same form and tags; false otherwise
     */
    public boolean equals(Object otherObj){
        // check for null
        if (otherObj == null)
        {
            return false;
        }

        // check if same class
        if (getClass() != otherObj.getClass())
        {
            return false;
        }

        // if same class, cast type
        Word otherWord = (Word) otherObj;

        // compare form and tag
        if (getForm().equalsIgnoreCase(otherWord.getForm())
                && getTag().equalsIgnoreCase(otherWord.getTag())) {
            return true;
        }

        return false;
    }

    /**
     * Get the word form.
     * @return the word form
     */
    public String getForm(){
        return form;
    }

    /**
     * Get the tag.
     * @return the POS tag
     */
    public String getTag(){
        return posTag;
    }

    /**
     * Generate a String representation of the Word. Concatenates form and tag.
     * @Override toString in class Object
     * @return a concatination of the word and tag values.
     */
    public String toString(){
        return getForm() + " | " + getTag();
    }
}