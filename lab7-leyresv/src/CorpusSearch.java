
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Course:      Data Structures and Algorithms for Language Processing SS 2021
 * Assignment:	Lab 7 - exercise 2
 * Author:		Leyre Sanchez Vinuela
 * Description: A program to create a corpus of lists of words and search through them
 *
 * Honor Code:  I pledge that this program represents my own work.
 * I received help from nobody in designing and debugging my program.
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
        this("src/tuebadz_1-50-utf8.export");
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
    public List<Word> search(Predicate<Word> needle) {
        return corpus.stream() // Create a stream of the corpus
                .flatMap(Collection::stream) // Flat map the corpus
                .filter(needle) // Filter the words that match the Predicate needle
                .collect(Collectors.toList()); // Collect the matching words in a list
    }
}

