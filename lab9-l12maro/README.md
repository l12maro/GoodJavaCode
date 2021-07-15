# Lab 9 - HashMap
The deadline is **14:00 on Friday, July 2**. Submissions later than this time will be 
ignored. Be sure to push your commits before the deadline.

**Note**: This time you will have to create a new project from scratch, rather than from existing sources. If you forgot how to do that and are struggling, consult the IntelliJ intro from lab0.


### Penn Treebank Tag Set
The file <a href="dict.dat">dict.dat</a> is a dictionary of words and their 
Part of Speech (POS) tags annotated according to the Penn Treebank Tag set (you can find a short description of every tag in the file <a href="postags.pdf">postags.pdf</a>). The format of the file is rather simple - each line contains a word followed by the corresponding POS tag, separated by a white space. Here is a quick example:

### Example
|Word|POS|
|-|-|
|airplane | nn|
airport | nn|
|airports | nns|
|. | .|
|. | .|
|cost  |   nn|
|cost  |   vb|
|cost  |   vbp|


From the example you can see that we have different entries for the singular and plural forms of the same word - `airport  nn` means that airport is a singular noun, 
whereas `airports  nns` is a plural noun. Also note that a word can appear multiple times in the dictionary with different POS tags. In our example, the word `cost` appears three times, once as a singular noun (`nn`), once as an infinitive (`vb`), and once as a non-3rd person singular present tense form (`vbp`). 

## Exercise

Write a class `POSDict`, that loads the words from <a href="dict.dat">dict.dat</a> into a Map and 
provides the method: 

`public boolean hasPOS(String aWord, String posTag)` 

which returns 
<strong>`true`</strong> or <strong>`false`</strong>, depending on
whether `aWord` is of type `posTag`. The case of `posTag` should not matter, so `nn` and `NN` should be treated as the same POS tags. For words, however, case does matter: `airport` and `Airport` should be considered as separate cases.

The default constructor should load a file `dict.dat` which is located in the current directory.

**Note**: The constructor should pass the exception(s). You should already be familiar with file IO in Java, thus you should also know which exceptions make sense here. You are relatively free with your choice, as long as you manage to cover some basic cases such as an incorrect file name or a null value.

#### (8 points)

## Tests

Write JUnit tests for your implementation of the `POSDict` class. Your tests will be assessed. You should have at least 5 tests, each for a unique case. All your tests should
handle (not just throw!) the exception from the constructor. As a reminder, you should stick to the correct project structure, so your test files should be placed in <code>lab9-yourName/test</code> directory.

**Note**: Don't forget to consider null inputs!

#### (2 points)
