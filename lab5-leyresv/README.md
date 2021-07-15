# Lab 5

**The deadline is 14:00 on Friday, June 4. Submissions later than this time will be ignored. Be sure to push your commits before the deadline.**

## Palindrome

A palindrome is a string that reads the same forwards and backwards. For example: "Anna" and "sfs" are palindromes while "Anne" and "sfb" are not.

### Exercise 1

In `Palindrome.java`, implement a recursive function `public static boolean isPalindromeRecursive(String text)`. This method will `return true` when `text` is a palindrome and 
`false` otherwise.

When you compare characters, make sure you do a case-insensitive comparison.

Do not consider punctuation or white space, eg: "Red roses run no risk, sir, on nurses order." should return true.

Do consider numbers, eg: "I was 1 or Ro 2 saw I" should return false, and "I was 1 or Ro 1 saw I" should return true.

Your code should be able to handle null

To test your method, use `test/PalindromeTest.java` and add at least the following tests:

*   `public void testIsPalindrome_empty()` -- Test if an empty string is a palindrome //return true
*   `public void testIsPalindrome_length1()` -- Test if a string of length 1 is a palindrome //return true
*   `public void testIsPalindrome_shortPalindrome()` -- Test "Anna"
*   `public void testIsPalindrome_shortNonPalindrome()` -- Test "Foo"
*   `public void testIsPalindrome_longPalindrome()` -- Test "Able was i ere i saw Elba"

#### 5 Points

### Exercise 2

Complete `public static boolean isPalindromeIterative(String text)` in your `Palindrome` class which implements an iterative version of `isPalindromeRecursive(String text)`. Use 
`test/PalindromeIterativeTest.java` to test this method and add at least the unit tests from above to verify the method.

#### 5 Points
