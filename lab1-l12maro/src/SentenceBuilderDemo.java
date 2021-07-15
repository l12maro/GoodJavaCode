import java.util.*;
import java.io.*;

public class SentenceBuilderDemo {
    public static void main(String[] args) throws FileNotFoundException{
        SentenceBuilder test = new SentenceBuilder("tuebadz_1-50-utf8.export");
        System.out.println(test.next());
        System.out.println(test.next());
        test.close();
    }
}
