import junit.framework.TestCase;

/**
 * Course:      Data Structures and Algorithms for Language Processing II 2021
 * Assignment:  Lab 3 - Exercise 3
 * Author:      Leyre Sanchez Vinuela
 * Description: Class that test the XMLChecker class
 *
 * Honor Code:  I pledge that this program represents my own work.
 * I received help from nobody in designing and debugging my program.
 */

public class XMLCheckerTest extends TestCase {

    /**
     * Test the tag names
     */
    public void testWellformedXML1(){
        // Good names
        assertTrue(XMLChecker.wellformedXML("<tag></tag>"));
        assertTrue(XMLChecker.wellformedXML("<tag><Tag/></tag>"));

        // Bad names
        assertFalse(XMLChecker.wellformedXML("<t ag></tag>"));
        assertFalse(XMLChecker.wellformedXML("<tag></t ag>"));
        assertFalse(XMLChecker.wellformedXML("<tag></Tag>"));
        assertFalse(XMLChecker.wellformedXML("<tag>data</Tag>"));
        assertFalse(XMLChecker.wellformedXML("<tag><tag></tag></tag>"));
        assertFalse(XMLChecker.wellformedXML("<tag></tag>data<tag></tag>"));
    }

    /**
     * Test missing closing tags
     */
    public void testWellformedXMLMissing2(){
        // Missing closing tags
        assertFalse(XMLChecker.wellformedXML("<tag>"));
        assertFalse(XMLChecker.wellformedXML("<tag><otherTag></tag>"));
    }

    /**
     * Test the nesting
     */
    public void testWellformedXMLMissing3(){
        // Correct nesting
        assertTrue(XMLChecker.wellformedXML("<tag><otherTag></otherTag></tag>"));
        assertTrue(XMLChecker.wellformedXML("<tag> <otherTag> <emptyTag/> </otherTag> </tag>"));
        assertTrue(XMLChecker.wellformedXML("<tag><otherTag><Tag></Tag></otherTag></tag>"));

        // Incorrect nesting
        assertFalse(XMLChecker.wellformedXML("<tag1> </tag1> <tag2></tag2>"));
        assertFalse(XMLChecker.wellformedXML("<tag> <otherTag> <Tag> </otherTag> </Tag> </tag>"));
        assertFalse(XMLChecker.wellformedXML("<tag><otherTag><Tag></Tag></tag></otherTag>"));
        assertFalse(XMLChecker.wellformedXML("<tags> <something> </something> <tags> </aTag> </aTag>"));
    }

    /**
     * Test empty tag
     */
    public void testWellformedXMLMissing4() {
        // Correct empty tag
        assertTrue(XMLChecker.wellformedXML("<tag> <emptyTag/> </tag>"));

        // Incorrect empty root tag
        assertFalse(XMLChecker.wellformedXML("<tag/>"));
    }

    /**
     * Test incorrect brackets
     */
    public void testWellformedXML5(){
        // Incorrect brackets position
        assertFalse(XMLChecker.wellformedXML("<tag></tag"));
        assertFalse(XMLChecker.wellformedXML("<tag></tag>>"));
        assertFalse(XMLChecker.wellformedXML("<tag<>data</tag>"));
        assertFalse(XMLChecker.wellformedXML("<tag> text>text </tag>"));
    }

    /**
     * Test incorrect slashes
     */
    public void testWellformedXMLcheck6(){
        // Incorrect slash position
        assertFalse(XMLChecker.wellformedXML("<tag>/</tag>"));
        assertFalse(XMLChecker.wellformedXML("<tag></ta/g>"));
        assertFalse(XMLChecker.wellformedXML("<tag/> </tag>"));
    }

    /**
     * Test data position
     */
    public void testWellformedXML7(){
        // Correct data position
        assertTrue(XMLChecker.wellformedXML("<tag>abc</tag>"));
        assertTrue(XMLChecker.wellformedXML("<tag> some data </tag>"));
        assertTrue(XMLChecker.wellformedXML("<rootTag><anotherTag>text text text</anotherTag></rootTag>"));
        assertTrue(XMLChecker.wellformedXML("<aTag>data<anotherTag>text text text</anotherTag></aTag>"));

        // Incorrect data position
        assertFalse(XMLChecker.wellformedXML("abc"));
        assertFalse(XMLChecker.wellformedXML("abc<tag></tag>"));
        assertFalse(XMLChecker.wellformedXML("<tag>abc</tag>abc"));
    }

    /**
     * Test tags without name
     */
    public void testWellformedXMLFail8() {
        assertFalse(XMLChecker.wellformedXML("<>"));
        assertFalse(XMLChecker.wellformedXML("</>"));
    }

    /**
     * Test null argument
     */
    public void testWellformedXMLFail9() {
        assertFalse(XMLChecker.wellformedXML(null));
    }

    /**
     * Test empty argument
     */
    public void testWellformedXMLFail10() {
        assertFalse(XMLChecker.wellformedXML(""));
    }

    /**
     * Test single attribute
     */
    public void testWellformedXMLFail11() {
        assertTrue(XMLChecker.wellformedXML("<tag attribute=\"anAttribute\"> text </tag>"));
        assertTrue(XMLChecker.wellformedXML("<person age=\"54\"> J.K. Rowling </person>"));

        assertFalse(XMLChecker.wellformedXML("<tag anAttribute=\"aValue\"> text </tag anAttribute=\"aValue\">"));
        assertFalse(XMLChecker.wellformedXML("<tag attribute> random data</tag>"));
    }

    /**
     * Test multiple attributes
     */
    public void testWellformedXMLFail12() {
        assertTrue(XMLChecker.wellformedXML("<tag attribute=\"anAttribute\"> <other color=\"blue\"> </other></tag>"));
        assertTrue(XMLChecker.wellformedXML("<person age=\"54\"><other color=\"blue\"> </other> J.K. Rowling </person>"));

        assertFalse(XMLChecker.wellformedXML("<tag attribute=\"anAttribute\"> <other> </other color=\"blue\"></tag>"));
        assertFalse(XMLChecker.wellformedXML("<person age=54><other color=\"blue\"> </other> J.K. Rowling </person>"));
    }
}
