/**
 * Course:      Data Structures and Algorithms for Language Processing II 2021
 * Assignment:  (lab 10)
 * Author:      (Lorena Martin Rodriguez)
 * Description: (A class to read an XML file)
 *
 * Honor Code:  I pledge that this program represents my own work.
 *  I received help from:
 *   (no one)
 *  in designing and debugging my program.
 *
 */

import java.io.*;
import java.util.ArrayList;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import javax.xml.transform.stream.StreamSource;

/**
 * @author Saile
 */

public class Addressbook {

    private String addressFileName;
    private ArrayList<Address> addresses = new ArrayList<Address>();

    public Addressbook(String addressFileName) throws XMLStreamException, FileNotFoundException {
        this.addressFileName = addressFileName;
        load();
    }
    
    /**
     * Return an ArrayList with the Addresses of this instance
     * @return the addresses
     */
    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    /**
     * Return the name of the file of this Addressbook
     * @return the addressFileName
     */
    public String getAddressFileName() {
        return addressFileName;
    }

    /**
     * Set the name of the file of this Adressbook
     * @param addressFileName the addressFileName to set
     */
    public void setAddressFileName(String addressFileName) {
        this.addressFileName = addressFileName;
    }

    /**
     * Save the content to addressFile
     * @param addressFile path to the file the content is written to
     */
    public void saveToFile(String addressFile) throws IOException {
        FileWriter fw = new FileWriter(new File(addressFile));
        generateXML(fw);
        fw.close();
    }

    /**
     * Save to data file
     */
    public void save() throws IOException {
        saveToFile(addressFileName);
    }

    /**
     * Return a String with the XML representation of this instance
     * @return a String with the XML representation of this instance
     */
    public String toString() {
        StringWriter sw = new StringWriter();
        generateXML(sw);
        return sw.toString();
    }

    /**
     * Reads an XML file
     */
    private void load() throws XMLStreamException, FileNotFoundException {
        if (getAddressFileName() == null) return;
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = inputFactory.createXMLEventReader(
                new StreamSource(new File(getAddressFileName())));
        Address e = new Address();
        boolean isInList = false;
        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            if (event.isStartElement()) { //prevent class cast exception
                StartElement se = event.asStartElement(); //casting
                String nameTag = se.getName().getLocalPart();
                if (nameTag.equals("address")) {
                    //initialize new address instance
                    e = new Address();
                }
                if (nameTag.equals("forename")) {
                    event = eventReader.nextEvent();
                    e.setForename(event.asCharacters().getData());
                } else if (nameTag.equals("surname")) {
                    event = eventReader.nextEvent();
                    e.setSurname(event.asCharacters().getData());
                } else if (nameTag.equals("email")) {
                    event = eventReader.nextEvent();
                    e.setEmail(event.asCharacters().getData());
                }
            } else if (event.isEndElement()) {
                EndElement ee = event.asEndElement();
                String nameTag = ee.getName().getLocalPart();
                if (nameTag.equals("address")) {
                    //check that element is not already in list
                    for (Address a : addresses) {
                        if (a.equals(e)) {
                            isInList = true;
                        }
                    }
                    if (!isInList)
                        addresses.add(e);
                }
            }
        }
        //once iteration is over, close document
        eventReader.close();
    }

    /**
     * generates an XML file with the information provided
     * @param w the Writer of choice
     */
    private void generateXML(Writer w) {
        //check for null
        if (getAddressFileName() == null) return;
        try {
            XMLEventFactory eventFactory = XMLEventFactory.newInstance();
            //start the HTML document
            StartDocument sd = eventFactory.createStartDocument();
            w.write(sd.toString());
            //make it pretty
            Characters indent = eventFactory.createCharacters("\t");
            Characters newLine = eventFactory.createCharacters("\n");
            w.write(newLine.getData());
            StartElement start = eventFactory.createStartElement("", "", "addressbook");
            w.write(start.toString());
            //write each address
            for (Address a : addresses) {
                w.write(newLine.getData());
                w.write(indent.getData());
                StartElement se = eventFactory.createStartElement("", "", "address");
                w.write(se.toString());
                w.write(newLine.getData());
                w.write(indent.getData() + indent.getData());
                //add elements of address
                se = eventFactory.createStartElement("", "", "forename");
                w.write(se.toString());
                Characters c = eventFactory.createCharacters(a.getForename());
                w.write(c.getData());
                EndElement ee = eventFactory.createEndElement("", "", "forename");
                w.write(ee.toString());
                w.write(newLine.getData());
                w.write(indent.getData() + indent.getData());
                se = eventFactory.createStartElement("", "", "surname");
                w.write(se.toString());
                c = eventFactory.createCharacters(a.getSurname());
                w.write(c.getData());
                ee = eventFactory.createEndElement("", "", "surname");
                w.write(ee.toString());
                w.write(newLine.getData());
                w.write(indent.getData() + indent.getData());
                se = eventFactory.createStartElement("", "", "email");
                w.write(se.toString());
                c = eventFactory.createCharacters(a.getEmail());
                w.write(c.getData());
                ee = eventFactory.createEndElement("", "", "email");
                w.write(ee.toString());
                w.write(newLine.getData());
                w.write(indent.getData());
                //end address instance
                ee = eventFactory.createEndElement("", "", "address");
                w.write(ee.toString());
            }
            //end the document
            w.write(newLine.getData());
            EndElement ee = eventFactory.createEndElement("", "", "addressbook");
            w.write(ee.toString());
            //w.write(newLine.getData());
            //EndDocument ed = eventFactory.createEndDocument();
            //w.write(ed.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
