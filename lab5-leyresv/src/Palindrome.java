/**
 * Course:      Data Structures and Algorithms for Language Processing SS 2019
 * Assignment:	Lab 5 - exercise 1 and 2
 * Author:		Leyre Sanchez Vinuela
 * Description: A program to check if a String is a palindrome
 *
 * Honor Code:  I pledge that this program represents my own work.
 * I received help from nobody in designing and debugging my program.
 */

public class Palindrome {

    /**
     * Recursive method to test if String is a palindrome
     * @param text - the String to test
     * @return True if String is palindrome, False otherwise
     */
    public static boolean isPalindromeRecursive(String text) {

        // If the argument is null: throw exception
        if (text == null){
            throw new NullPointerException("Error: null argument");
        }

        // Remove everything from the input text that are not letters or digits
        text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // If the text has 0 or 1 characters: it's a palindrome
        if (text.length() == 0 || text.length() == 1) {
            return true;
        }

        // If the first and last characters of the string are the same:
        if (text.charAt(0) == text.charAt(text.length()-1)) {
            // repeat the process on string removing its first and last characters
            return isPalindromeRecursive(text.substring(1, text.length() - 1));
        }
        // If the first and last characters are not the same, it's not a palindrome
        return false;
    }

    /**
     * Iterative method to test if String is a palindrome
     * @param text - the String to test
     * @return True if String is palindrome, False otherwise
     */
    public static boolean isPalindromeIterative(String text) {

        // If the argument is null: throw exception
        if (text == null){
            throw new NullPointerException("Error: null argument");
        }

        // Remove everything from the input text that are not letters or digits
        text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // If the text has 0 or 1 characters: it's a palindrome
        if (text.length() == 0 || text.length() == 1) {
            return true;
        }

        // For each character from the first half of the text string
        for (int i=0; i<=text.length()/2; i++){
            // If it's not the same as its corresponding one from the end of the string, it's not a palindrome
            if (text.charAt(i) != text.charAt(text.length() - 1 - i) ){
                return false;
            }
        }
        // Else: it is a palindrome
        return true;
    }
}
