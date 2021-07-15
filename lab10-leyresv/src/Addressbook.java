import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import javax.xml.transform.stream.StreamSource;

/**
 * Course:      Data Structures and Algorithms for Language Processing II 2021
 * Assignment:  Lab 10
 * Author:      Leyre Sanchez Vinuela
 * Description: Class that loads and saves instances of class Address.java to files
 *
 * Honor Code:  I pledge that this program represents my own work.
 * I received help from nobody in designing and debugging my program.
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
     * Read the XML file and load it into the addresses array list
     */
    private void load() throws XMLStreamException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = inputFactory.createXMLEventReader(new StreamSource(new File(addressFileName)));
        Address address = new Address();
        Stack<String> stack = new Stack<>();

        while (eventReader.hasNext()) {

            // Get the next event
            XMLEvent event = eventReader.nextEvent();

            // If the event is an opening tag:
            if (event.isStartElement()){
                StartElement startElement = event.asStartElement();

                // If it's an address tag, create a new address object
                if (startElement.getName().getLocalPart().equals("address")){
                    address = new Address();
                }

                // If the opening tag indicates the beginning of an address variable: push the tag into the stack
                else if (startElement.getName().getLocalPart().equals("forename") ||
                        startElement.getName().getLocalPart().equals("surname") ||
                        startElement.getName().getLocalPart().equals("email")){
                    stack.push(startElement.getName().getLocalPart());
                }
            }

            // If the event is the content of a tag and the stack is not empty:
            else if (event.isCharacters() && !stack.isEmpty()){
                String content = event.asCharacters().getData();

                // Set the value of the address instance variable that matches with the top of the stack
                String tag = stack.pop();
                switch (tag) {
                    case "forename":
                        address.setForename(content);
                        break;
                    case "surname":
                        address.setSurname(content);
                        break;
                    case "email":
                        address.setEmail(content);
                        break;
                }
            }

            // If the event is a closing address tag, append the address instance to the addresses arraylist
            else if (event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("address")){
                addresses.add(address);
            }
        }
    }

    /**
     * Generate an XML object out of the contents from the addresses array list
     * @param w - the writer
     */
    private void generateXML(Writer w) {
        try {
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(w);
            XMLEventFactory eventFactory = XMLEventFactory.newInstance();

            // Indent and new line characters
            Characters indent = eventFactory.createCharacters("    ");
            Characters newLine = eventFactory.createCharacters(("\n"));

            // Start the document
            StartDocument startDocument = eventFactory.createStartDocument();
            eventWriter.add(startDocument);
            eventWriter.add(newLine);

            // Write the root
            StartElement startRoot = eventFactory.createStartElement("", "", "addressbook");
            eventWriter.add(startRoot);

            // Address variables
            String[] variables = {"forename", "surname", "email"};

            // For each address from our array list:
            for (Address address : addresses) {

                // Write the address opening tag
                StartElement currentAddress = eventFactory.createStartElement("", "", "address");
                eventWriter.add(newLine);
                eventWriter.add(indent);
                eventWriter.add(currentAddress);

                // For each variable of the address, write the opening tag, content and closing tag
                for (String variable : variables) {
                    StartElement startVariable = eventFactory.createStartElement("", "", variable);
                    EndElement endVariable = eventFactory.createEndElement("", "", variable);
                    Characters content = null;
                    switch (variable) {
                        case "forename": {
                            content = eventFactory.createCharacters(address.getForename());
                            break;
                        }
                        case "surname": {
                            content = eventFactory.createCharacters(address.getSurname());
                            break;
                        }
                        case "email": {
                            content = eventFactory.createCharacters(address.getEmail());
                            break;
                        }
                    }
                    eventWriter.add(newLine);
                    eventWriter.add(indent);
                    eventWriter.add(indent);
                    eventWriter.add(startVariable);
                    eventWriter.add(content);
                    eventWriter.add(endVariable);

                }
                // Write the address closing tag
                EndElement endCurrentAddress = eventFactory.createEndElement("", "", "address");
                eventWriter.add(newLine);
                eventWriter.add(indent);
                eventWriter.add(endCurrentAddress);

            }
            // Write the root closing tag
            EndElement endRoot = eventFactory.createEndElement("", "", "addressbook");
            eventWriter.add(newLine);
            eventWriter.add(endRoot);

            // End the document and close the writer
            EndDocument endDocument = eventFactory.createEndDocument();
            eventWriter.add(endDocument);
            eventWriter.close();
        }
        catch (XMLStreamException e){
            e.printStackTrace();
        }
    }
}
