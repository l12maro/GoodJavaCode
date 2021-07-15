# Lab 3
The deadline for this assignment is **14:00** on Friday, May 14th.

As always, do not forget the honor code and flow/javadoc comments (you will not get partial credit if you don't describe your workflow!).

## Before you start:
[Extensible Markup Language](https://www.w3schools.com/xml/xml_whatis.asp) (XML) is a framework for structuring data. Tags are used to label and encapsulate information, and they can be nested to delineate the hierarchical structure of certain relationships.

One of the most basic requirements of an XML document is wellformedness. An XML document is wellformed when none of the following requirements are violated:

- The document contains a **single** root element that contains all other elements. The closing root tag is the last element of the file.
- Every element of a document that has content needs a begin and an end tag, e.g. `<name>Bart Simpson</name>`
- An element without content may consist of the tag name and a terminating `/` character, e.g. `<name/>`
- Begin and end tags are nested as pairs on the same nesting level, e.g.
~~~xml
<tag>
    This is a test
    <name>test</name> 
</tag>
~~~

Keep in mind that `>`, `<` and `/` are reserved characters and shouldn't appear in unexpected locations such as `<a<b>>` or `<a/b>`.

**Great friendly hints from your tutors:**

- For the purpose of this exercise, you do not need to consider whether a tag contains stray whitespace, e.g. `< tag>`.
- You can assume that the XMLs do not contain an XML declaration (e.g. `<?xml version="1.0" encoding="UTF-8"?>`).
- For an empty tag, both `<tag/>` and `<tag></tag>` are valid.
- XML is case sensitive, so `<tag>` and `</Tag>` are distinct.
- Be aware that there is only one root tag in the document, so a document that looks like `<tags><tag></tag><tag></tag></tags>` is valid while `<tag></tag><tag></tag>` is not.
- Some examples of malformed XML:
	* `<tag><tag>>` (should not have an extra `>`)
	* `<tag><ta/g>` (`/` should be in the begining of the closed tag)
	* `</tag>` (`/` should be in the end for empty tags)


## Exercise 1
Write the [pseudocode](http://www.cburch.com/csbsju/cs/150/sched/pseudo.pdf) for a method that takes a string as an argument and tests whether the string is wellformed XML. Your answer to this should be written in a .txt file and added to the repository. In case you prefer writing your pseudocode on paper, an image file or .pdf is also fine.

The above link can be understood as an example. You are relatively free in how you want to design your pseudocode as long as the algorithm you come up with is clearly communicated and can be understood without reading the actual code you write in exercise 2.  
Try to keep it short and precise.

**(2 Points)**

## Exercise 2
Write a class `XMLChecker` that contains a single method `public static boolean wellformedXML(String xml)` which implements the algorithm you have developed.

Do not throw exceptions when the document is malformed!

We provided a .txt file `examples.txt` with example XMLs your code should be able to handle.

**Note:** Do **NOT** use Regex or any XML Parsing libraries or similar for this exercise.

**(5 Points)**

## Exercise 3
Write JUnit tests to verify that your `XMLChecker` works as expected. Make sure to test different cases, including but not limited to:

- tag names
- missing closing tags
- nesting
- empty tags

You should include at least **10** different test cases (ideally at least every example XML provided in `examples.txt`), checking for distinct situations.

**(3 points)**

## Bonus
If you have time, you can extend your code to handle [attributes](https://www.w3schools.com/xml/xml_attributes.asp). To get the bonus point it is enough if your code is capable of handling tags with one attribute.

**(1 Point)**
