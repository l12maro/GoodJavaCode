import junit.framework.TestCase;

/**
 * Course:      Data Structures and Algorithms for Language Processing SS 2019
 * Assignment:	Lab 5 - exercise 1
 * Author:		Leyre Sanchez Vinuela
 * Description: A program to test the method isPalindromeRecursive() from the Palindrome class
 *
 * Honor Code:  I pledge that this program represents my own work.
 * I received help from nobody in designing and debugging my program.
 */

public class PalindromeTest extends TestCase {

    // Test empty string (is a palindrome)
    public void testIsPalindrome_empty(){
        assertTrue(Palindrome.isPalindromeRecursive(""));
    }

    // Test 1 character string (is a palindrome)
    public void testIsPalindrome_length1(){
        assertTrue(Palindrome.isPalindromeRecursive("a"));
    }

    // Test short palindrome
    public void testIsPalindrome_shortPalindrome(){
        assertTrue(Palindrome.isPalindromeRecursive("Anna"));
    }

    // Test short string (not palindrome)
    public void testIsPalindrome_shortNonPalindrome(){
        assertFalse(Palindrome.isPalindromeRecursive("Foo"));
    }

    // Test long palindrome
    public void testIsPalindrome_longPalindrome(){
        assertTrue(Palindrome.isPalindromeRecursive("Able was i ere i saw Elba"));
    }

    // Test long string (not palindrome)
    public void testIsPalindrome_longNonPalindrome(){
        assertFalse(Palindrome.isPalindromeRecursive("Able was i here i saw Elba"));
    }

    // Test palindrome with punctuation
    public void testIsPalindrome_punctuation(){
        assertTrue(Palindrome.isPalindromeRecursive("Red roses run no risk, sir, on nurses order."));
    }

    // Test string with numbers (not palindrome)
    public void testIsPalindrome_numbers(){
        assertFalse(Palindrome.isPalindromeRecursive("I was 1 or Ro 2 saw I"));
    }

    // Test palindrome with numbers
    public void testIsPalindrome_numbers2(){
        assertTrue(Palindrome.isPalindromeRecursive("I was 1 or Ro 1 saw I"));
    }

    // Test palindrome with only numbers
    public void testIsPalindrome_numbers3(){
        assertTrue(Palindrome.isPalindromeRecursive("19591"));
    }

    // Test null argument
    public void testIsPalindrome_null(){
        try {
            Palindrome.isPalindromeRecursive(null);
            fail();
        } catch (NullPointerException e) {}
    }

    // Test palindrome with whitespaces
    public void testIsPalindrome_whitespace(){
        assertTrue(Palindrome.isPalindromeRecursive("  I was 1 or       Ro 1 saw I    "));
    }
}

