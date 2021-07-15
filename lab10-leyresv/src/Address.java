/**
 * A class representing an address book entry
 */
public class Address {

    private String forename;
    private String surname;
    private String email;

    /**
     * Default constructor setting all values to null
     */
    public Address()  {
	forename = surname = email = null;
    }
    
    /**
     * Create a new address book entry
     *
     * @param forename The forename of the entry
     * @param surname The surname of the entry
     * @param email The email address of the entry
     */
    public Address(String forename, String surname, String email) {
        this.forename = forename;
        this.surname = surname;
        this.email = email;
    }

    /**
     * Set the forename of this entry  
     *
     * @param forename The new forename of the entry
     */
    public void setForename(String forename) {
        this.forename = forename;
    }

    /**
     * Set the surname of this entry  
     *
     * @param surname The new surname of the entry
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Set the email address of this entry  
     *
     * @param email The new email address of the entry
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the forename of this entry
     *
     * @return The forename of this entry
     */
    public String getForename() {
        return forename;
    }

    /**
     * Returns the surname of this entry
     *
     * @return The surname of this entry
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Returns the email address of this entry
     *
     * @return The email address of this entry
     */
    public String getEmail() {
        return email;
    }

    public boolean equals(Object anotherObject)  {
        if (getClass().equals(anotherObject.getClass()))  {            

            Address anotherAddress = (Address) anotherObject;            

            return getForename().equalsIgnoreCase(anotherAddress.getForename())
		&& getSurname().equalsIgnoreCase(anotherAddress.getSurname());
	}
        
        return false;
    }

    public String toString() {
        return String.format("[ Forename: %s, Surname: %s, Email: %s ]", forename, surname, email);
    }
}
