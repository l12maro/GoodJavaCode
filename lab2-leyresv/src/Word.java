public class Word
{
    private String form;
    private String posTag;

    /**
     * Default constructor
     */
    public Word()
    {
        form = "";
        posTag = "";
    }

    /**
     * Construct a Word object with just a form
     * @param aForm - the Word form
     */
    public Word(String aForm)
    {
        form = aForm;
        posTag = "";
    }

    /**
     * Construct a Word with form and tag values
     * @param aForm - the Word form
     * @param aPOSTag - the tag for the Word
     */
    public Word(String aForm, String aPOSTag)
    {
        form = aForm;
        posTag = aPOSTag;
    }

    /**
     * Get the word form
     * @return the word form
     */
    public String getForm()
    {
        return form;
    }

    /**
     * Get the tag
     * @return the POS tag
     */
    public String getTag()
    {
        return posTag;
    }

    /**
     * Generate a String representation of the Word. Concatinates form and tag
     * @override toString in class Object
     * @return a concatination of the word and tag values
     */
    public String toString()
    {
        return form+" "+posTag;
    }

    /**
     * Two Words are equal if the forms and pos tag values are equal, ignoring case
     * @override equals in class Object
     * @param otherObj - other object to check for equality
     * @return true if the Words have the same form and tags; false otherwise
     */
    public boolean equals(Object otherObj)
    {
        // Check if otherObj is null
        if (otherObj == null)
        {
            return false;
        }

        // Check if otherObj is a Word
        if (! (otherObj instanceof Word))
        {
            return false;
        }

        // Type cast otherObj as a Word
        Word otherWord = (Word) otherObj;

        // Check that otherObj and this Word's form and posTag are the same
        return this.form.equalsIgnoreCase(otherWord.getForm()) && this.posTag.equalsIgnoreCase(otherWord.getTag());
    }

}