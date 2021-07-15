import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try{
            Addressbook book = new Addressbook("addresses.xml");
            System.out.println(book.getAddresses());
            System.out.println(book);
            book.saveToFile("savedAddresses.xml");

        }
        catch (XMLStreamException | IOException e ){
            e.printStackTrace();
        }

    }
}
