# Lab 1

### Main contents
- **Savitch, Ch12**
- **Lewis & Chase, Ch3.1**
- **the corresponding lecture from Monday, 26th of April 2021 on ADTs/ArrayLists/LinkedLists**

**The deadline is at 14:00 on Friday, April 30.**

### General Reminders
- watch the [home repository](https://github.com/ISCL-Java2-SS2021/home) (little eye icon on the top)
- add the honor code to every file you upload
- comment your code
- you can ask questions on the [issues page](https://github.com/ISCL-Java2-SS2021/home/issues) or come to the lab session on Friday
- late submissions will not be graded
- not compiling labs get 0 points

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

### Note
Last semester we told you only to use the stuff you have learnt in class in order to learn basics. Now you know the basics so this doesn't apply anymore (only exception is if we tell you explicitly what to use). Please note that this does not give you licence to copy code from Stack Overflow. Please make sure you understand what you are using.

### Steps To Follow
1) Navigate to the directory in which you want to save the repository. 
2) Clone the repository in the terminal: ```git clone repo-link``` 
3) Open Intellij
4) Click on `File`- `New` - `Project from existing sources`
5) Select the directory that contains the cloned repo
6) Keep pressing `Next`, press `Finish`


## Negra export format

The negra export format is a column based data format to represent annotated 
treebanks.
Here are the first few lines from a sample negra export file: 

<table style="width:80%">
  <tr>
    <td>%% word</td>
    <td>tag</td>
    <td>morph</td>
    <td>edge</td>
    <td>parent</td>
    <td>secedge</td>
    <td>comment</td>
  </tr>
  <tr>
    <td>#BOS 1 26 1068105868 475 %% HEADLINE</td>
  </tr>
  <tr>
    <td>Veruntreute</td>
    <td>VVFIN</td>
    <td>3sit</td>
    <td>HD</td>
    <td>500</td>
  </tr>
  <tr>
    <td>die</td>
    <td>ART</td>
    <td>nsf</td>
    <td>-</td>
    <td>504</td>
  </tr>
  <tr>
    <td>AWO</td>
    <td>NN</td>
    <td>nsf</td>
    <td>-</td>
    <td>501</td>
  </tr>
  <tr>
    <td>Spendengeld</td>
    <td>NN</td>
    <td>asn</td>
    <td>-</td>
    <td>HD</td>
  </tr>
  <tr>
    <td>?</td>
    <td>$.</td>
    <td>--</td>
    <td>--</td>
    <td>0</td>
  </tr>
</table>

If you are curious about what the tags mean and to make better sense of the format, 
you can find its documentation `tuebadz_1-50-utf8.export`
However in order to do today's exercise, you will only need the hint given below.

Section 3 of `exformat3.pdf` can help you detect sentence boundaries

## Exercise 1
Implement **ALL** public methods of your classes (both `SentenceBuilder` and `Word`) as defined in the documentation 
(`doc/index.html`).
When you open index.html on GitHub, you will see html code, which will be pretty hard to read. 
That is why you should open it locally. Once you've cloned the repo to your local machine, navigate to the doc folder and click on index.html. The file will be 
opened in your browser.

The SentenceBuilder class builds word lists from the sentences in a negra export file. 
The name of the export file is given as a parameter to the constructor. Successive calls to the next() 
method read the next sentence from the file and return the ArrayList of Word objects. 
The hasNext() method determines if there are more sentences in the export file. You are allowed to use Scanner to read in the file. 

Also add another public method `public void close()` which closes the input stream.

Before you start programming make a plan, and write JUnit tests to test your classes (the tests won't be graded).
<br>For tests, please use data from this `tuebadz_1-50-utf8.export` negra export file.


**(10 points)**
