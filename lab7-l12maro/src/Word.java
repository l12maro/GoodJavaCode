/**
 * Class to represent the Word information in a TuBaTreeBank export file
 * @author Marie Hinrichs
 */
public class Word {
    private String form;
    private String tag;
    
    
    /**
     * Default constructor
     */
    public Word() {
        form = tag = "";    
    }
    
    /**
     * Construct a Word object with just a form
     * @param aForm the Word form
     */
    public Word(String aForm) {
        form = aForm;
        tag = "";
    }
    
    /**
     * Construct a Word with form, tag, morph, edge, parentWord values
     * @param aForm the Word form
     * @param aPOSTag the tag for the Word     
     */
    public Word(String aForm, String aPOSTag) {
        form = aForm;
        tag = aPOSTag;
    }
    
    /**
     * Get the word form.
     * @return the word form
     */
    public String getForm() {
        return form;
    }

    /**
     * Get the tag.
     * @return the POS tag
     */
    public String getTag() {
        return tag;
    }
    
    
    /**
     * Generate a String representation of the Word.
     * Concatinates form, tag, morph, edge
     * @return a concatination of the word, tag, and morph and edge values.
     */
    public String toString() {
        return form; // + " " + tag + " " + morph + " " + edge;
    }
    
    /**
     * Two Words are equal if the forms and pos tag values are equal, ignoring case
     * @param otherObj other object to check for equality
     * @return true if the Words have the same form, tags, and morph; false otherwise
     */
    public boolean equals(Object otherObj) {
        if (otherObj == null)
            return false;
        if (getClass() != otherObj.getClass())
            return false;
        
        Word otherWord = (Word) otherObj;
        return (form.equalsIgnoreCase(otherWord.form) &&
                tag.equalsIgnoreCase(otherWord.tag));
    }
}
