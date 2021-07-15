/**
 * Course:      Data Structures and Algorithms for Computational Linguistics II SS2021
 * Assignment:  (7, 1)
 * Author:      (Lorena Martin Rodriguez)
 * Description: (A test case for FilenameFinder)
 *
 * Honor Code:  I pledge that this program represents my own work.
 *  I received help from:
 *   (no one)
 *  in designing and debugging my program.
 */

import junit.framework.TestCase;
import java.util.List;
import java.util.function.Predicate;

public class FilenameFinderTest extends TestCase {
    FilenameFinder e = new FilenameFinder();

    public void testFindEntryAtPath1() {
        Predicate<String> matcher = Predicate.isEqual("file1.txt");
        List<String> result = e.findEntryAtPath("src/test/resources/", matcher);
        assertEquals(1, result.size());
    }
    public void testFindEntryAtPath2() {
        Predicate<String> matcher = (m) -> m.endsWith(".txt");
        List<String> result = e.findEntryAtPath("src/test/resources/", matcher);
        assertEquals(3, result.size());
    }
    public void testFindEntryAtPath3() {
        Predicate<String> matcher = (m) -> m.contains("ile");
        List<String> result = e.findEntryAtPath("src/test/resources/", matcher);
        assertEquals(3, result.size());
    }
    public void testFindEntryAtPath4() {
        Predicate<String> matcher = (m) -> m.startsWith("f");
        List<String> result = e.findEntryAtPath("src/test/resources/", matcher);
        assertEquals(3, result.size());
    }
}