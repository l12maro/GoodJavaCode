# Lab 2

After cloning the repo to your machine, make sure to create a new IntelliJ project by choosing ```File``` » ```New``` » ```Project from Existing Sources``` and select the lab2-username folder.

When you are finished with this exercise, please push your repository (only the **.java** files) from your local machine to the automatically created remote repository. This will be possible until **14:00 on Friday, May 7**. Late submissions will not be graded.

As always, do not forget to add the honor code and flow/javadoc comments.

### Again, please
- watch the [home repository](https://github.com/ISCL-Java2-SS2021/home) (little eye icon on the top)
- add the honor code to every file you upload
- comment your code! Comments describing your program &ne; javadoc comments
- use the [issues page](https://github.com/ISCL-Java2-SS2021/home/issues) to ask questions until Friday! You might also benefit from other questions!
- submit on time! Late submissions will not be graded - Deadline: **Friday, May 7 - 2pm**
- make sure your code compiles - not compiling labs get 0 points
- this time copying code results in 0 points for BOTH people (copier and copied)!

## Exercise 1

Write a linked list class `SLinkedList.java` which implements the `SimpleList` interface. The `SimpleList` interface is a simple subset of the [Sun Microsystems](http://docs.oracle.com/javase/6/docs/api/java/util/List.html) `List` interface. Please read the documentation **carefully** before you start writing your own list class. You can access the documentation by cloning this repository and opening `doc/SimpleList.html` locally on your computer. In addition to the methods required by the interface, your class needs a simple default constructor that creates an empty list.

**Important: Since the whole point of this exercise is to build an own list you are obviously not allowed to use any built in lists of Java. Instead you have to work with ListNode**


### Files you need:

You can find the definition for the `SimpleList` interface in `src/SimpleList.java`. The `src` folder contains starter code for you to work on.

### Demo
You can use `SLLDemo.java` to make sure that your class does what we expect it to do. Feel free to write your own JUnit tests, but you do not need to push them to the remote repository. They will not be graded.

**10 Points**

## Bonus Question: Iterators
If you have time left, you can complete the inner class `LinkedListIterator` that is called in the method `iterator()`. The method `iterator()` should return an object `Iterator`. This object is used to provide sequential access to the elements in a collection.

**1 Point**
