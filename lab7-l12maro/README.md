# Lab 7

### Main contents
- [the Java Stream API](http://tutorials.jenkov.com/java-functional-programming/streams.html)
- **the corresponding lecture from Wednesday, 7th of June 2021** (Java 8 Features)

**The deadline is at 14:00 on Friday, June 19.**

### General Reminders
- watch the [home repository](https://github.com/ISCL-Java2-SS2021/home) (little eye icon on the top)
- add the honor code to every file you upload
- comment your code
- you can ask questions on the [issues page](https://github.com/ISCL-Java2-SS2021/home/issues) or come to the lab session on Friday
- late submissions will not be graded
- not compiling labs or labs with the wrong JDK get 0 points
- use `JDK 8 (jdk1.8)` and `JUnit3`

### Honor Code
```
/**
 * Course:      Data Structures and Algorithms for Computational Linguistics II SS2021
 * Assignment:  (lab, exercise)
 * Author:      (Your Name)
 * Description: (What does the program do?)
 *
 * Honor Code:  I pledge that this program represents my own work.
 *  I received help from:
 *   (enter the names of others that helped with the assignment, or
 *   no one if you received no help)
 *  in designing and debugging my program.
 */
 
```

## Exercise 1: Lambda expressions - filename finder using properties

In the current version of your `FilenameFinder`, you used `equals()` to decide when a file name matches the parameter `entryName`. Please rewrite your `FilenameFinder` and use a 
`Predicate` as a criteria for file name selection. If you do not trust your own version of `FilenameFinder`, you may use the provided class.

Change the signature of the `findEntryAtPath` method to:

~~~java
public static List<String> findEntryAtPath(String path, Predicate<String> matcher)
~~~

and replace the `equals()` method call with a `Predicate`.

Add a JUnit test class and assess the `findEntryAtPath` method with at least the 
following searches:

* Number of entries named "file1.txt" in directory "src/test/resources/"
* Number of entries which end in ".txt" in directory "src/test/resources/"
* Number of entries in "src/test/resources/" which contain "ile"
* Number of entries in "src/test/resources/" which have an 'f' in the beginning

## Exercise 2: Stream filter using predicates

Complete the method `public List<Word> search(Predicate<Word> needle)` in class `CorpusSearch`.

Add a JUnit test class and assess the `search` method with at least the 
following searches:

* Search number of all words representing word form "in" 
* Search number of all words representing POS tag "APPR" and form "für"
* Search number of all words where the POS tag begins with "VV"
* Search number of all words where the POS tag is "APPR" and the form is either "für" or "in"

## Notes:
We will only accept solutions that use lambda expressions (exercise 1) and lambda expressions and streams (exercise 2). 
Don't forget to comment and add/update JavaDoc (tests do not require JavaDoc)

