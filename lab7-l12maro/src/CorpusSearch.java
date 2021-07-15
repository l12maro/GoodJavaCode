/**
 * Course:      Data Structures and Algorithms for Computational Linguistics II SS2021
 * Assignment:  (7, 2)
 * Author:      (Lorena Martin Rodriguez)
 * Description: (Different methods to search a corpus)
 *
 * Honor Code:  I pledge that this program represents my own work.
 *  I received help from:
 *   (no one)
 *  in designing and debugging my program.
 */
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * The class provides timer methods to compare the runtime of a Stream and a
 * loop search of a corpus.
 *
 * @author saile
 */
public class CorpusSearch {

    // The corpus
    private ArrayList<ArrayList<Word>> corpus;

    /**
     * Create a CorpusSearch from a Negra export file in the current directory
     *
     * @throws FileNotFoundException When export file is not found.
     */
    public CorpusSearch() throws FileNotFoundException {
        this("tuebadz_1-50-utf8.export");
    }

    /**
     * Create a CorpusSearch from from a Negra export file in {@code filename}
     *
     * @param fileName Path to NEGRA export file
     * @throws FileNotFoundException When export file is not found.
     */
    public CorpusSearch(String fileName) throws FileNotFoundException {
        corpus = new ArrayList<ArrayList<Word>>();
        SentenceBuilder build = new SentenceBuilder(fileName);

        while (build.hasNext()) {
            ArrayList<Word> sentence = build.next();
            corpus.add(sentence);
        }

    }

    /**
     * Search for {@code Predicate needle} in corpus. Return a {@code List} of {@code Word} elements matching the
     * {@code Predicate}
     *
     * @param needle {@code Predicate} to search for
     * @return Return a {@code List} of {@code Word} elements matching the {@code Predicate}
     */
    public  List<Word> search(Predicate<Word> needle) {
        List<Word> result = new ArrayList<Word>();

        return result = corpus.stream()
                    .flatMap((i) -> i.stream())
                    .filter((i) -> {return needle.test(i);})
                    .collect(Collectors.toList());
    }
}
