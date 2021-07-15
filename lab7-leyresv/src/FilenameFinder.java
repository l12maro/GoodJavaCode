import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Course:      Data Structures and Algorithms for Language Processing SS 2021
 * Assignment:	Lab 7 - exercise 1
 * Author:		Leyre Sanchez Vinuela
 * Description: A program to find files and directories matching the defined criteria
 *
 * Honor Code:  I pledge that this program represents my own work.
 * I received help from nobody in designing and debugging my program.
 */

public class FilenameFinder {
    /**
     * Collect file or directory that match with {@code Predicate matcher} and store the absolute pathname to the found entry
     * in a List. Start the collection at path {@code path}. If {@code path} is a directory continue collection
     * in its sub directories.
     * @param path root of search
     * @param matcher Predicate that defines the string to be matched
     * @return List with found items or empty list if nothing was found.
     */
    public static List<String> findEntryAtPath(String path, Predicate<String> matcher) {
        List<String> entryList = new ArrayList<>();

        File fileOrDir = new File(path);

        // Collect all entries into entryList
        realFind(entryList, matcher, fileOrDir);

        return entryList;
    }

    // Private helper class to do the recursion
    private static void realFind(List<String> entryList, Predicate<String> matcher, File fileOrDir) {
        // If filename matches the predicate, add absolute path to list
        if (matcher.test(fileOrDir.getName())) {
            entryList.add(fileOrDir.getAbsolutePath());
        }

        // if entry is a directory search all directory members for entryName
        if (fileOrDir.isDirectory()) {
            File[] directoryList = fileOrDir.listFiles();

            if (directoryList == null) {
                return;
            }

            for (File currentFile : directoryList) {
                realFind(entryList, matcher, currentFile);
            }
        }
    }
}
