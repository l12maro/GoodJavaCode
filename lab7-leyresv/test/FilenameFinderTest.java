import junit.framework.TestCase;

import java.util.List;
import java.util.function.Predicate;

/**
 * Course:      Data Structures and Algorithms for Language Processing SS 2021
 * Assignment:	Lab 7 - exercise 1
 * Author:		Leyre Sanchez Vinuela
 * Description: A program to test the FilenameFinder class
 *
 * Honor Code:  I pledge that this program represents my own work.
 * I received help from nobody in designing and debugging my program.
 */

public class FilenameFinderTest extends TestCase {
    // Test number of entries named "file1.txt" in directory "src/test/resources/"
    public void testFind1() {
        List<String> entries = FilenameFinder.findEntryAtPath("src/test/resources/", s -> s.equals("file1.txt"));
        assertEquals(1,entries.size());
    }

    // Test number of entries which end in ".txt" in directory "src/test/resources/"
    public void testFind2(){
        List<String> entries = FilenameFinder.findEntryAtPath("src/test/resources/", s -> s.endsWith(".txt"));
        assertEquals(3,entries.size());
    }

    // Test number of entries in "src/test/resources/" which contain "ile"
    public void testFind3(){
        List<String> entries = FilenameFinder.findEntryAtPath("src/test/resources/", s -> s.contains("ile"));
        assertEquals(3,entries.size());
    }

    // Number of entries in "src/test/resources/" which have an 'f' in the beginning
    public void testFind4(){
        List<String> entries = FilenameFinder.findEntryAtPath("src/test/resources/", s -> s.startsWith("f"));
        assertEquals(3,entries.size());
    }

    // Number of entries in "src/test/resources/" which start with "dir"
    public void testFind5(){
        List<String> entries = FilenameFinder.findEntryAtPath("src/test/resources/", s -> s.startsWith("dir"));
        assertEquals(4,entries.size());
    }
}
