import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SentenceTest
{
    public static void main(String[] args)
    {
        try
        {
            Word die = new Word("die", "ART");
            SentenceBuilder s = new SentenceBuilder("tuebadz_1-50-utf8.export");
           /* s.next();
            System.out.println();
            s.next();
            System.out.println();
            s.next();*/
            int i = 1;
            while(i<52) {
                s.next();
                System.out.println();
                i++;
            }


        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
