/**
 * Course:      Data Structures and Algorithms for Computational Linguistics II SS2021
 * Assignment:  (7, 1)
 * Author:      (Lorena Martin Rodriguez)
 * Description: (Collects the path of the files called as indicated)
 *
 * Honor Code:  I pledge that this program represents my own work.
 *  I received help from:
 *   (no one)
 *  in designing and debugging my program.
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class FilenameFinder {
    /**
     * Collect file or directory names equal to {@code entryName} and store the absolute pathname to the found entry
     * in a List. Start the collection at path {@code path}. If {@code path} is a directory continue collection
     * in its sub directories.
     * @param matcher {@code Predicate} to search for
     * @param path root of search
     * @return List with found items or empty list if nothing was found.
     */
    public static List<String> findEntryAtPath(String path, Predicate<String> matcher) {
        List<String> entryList = new ArrayList<>();

        File fileOrDir = new File(path);
        // Collect all entries into entryList
        realFind(entryList, matcher, fileOrDir);

        return entryList;
    }

    private static void realFind(List<String> entryList, Predicate<String> matcher, File fileOrDir) {
        // If name matches add absolute path to list
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
