/**
 * Course:      Data Structures and Algorithms for Language Processing II 2021
 * Assignment:  (lab 9, 2)
 * Author:      (Lorena Martin Rodriguez)
 * Description: (This TestCase checks if POSDict works correctly.)
 *
 * Honor Code:  I pledge that this program represents my own work.
 *  I received help from:
 *   (no one)
 *  in designing and debugging my program.
 *
 */
import junit.framework.TestCase;
import java.io.FileNotFoundException;
import java.io.IOException;

public class POSDictTest extends TestCase {
    //test the default constructor
    //test if method returns false for null value in word
    public void testHasPOSNull1() {
        try {
            POSDict test = new POSDict();
            assertFalse(test.hasPOS(null,"nn"));
        }
        //if an exception is triggered, then there is a problem
            catch(FileNotFoundException e){
            fail();
        }
            catch(NullPointerException e){
            fail();
        }
            catch(IOException e){
            fail();
        }
    }
    //test if method returns false for null values
    public void testHasPOSNull2() {
        try {
            POSDict test = new POSDict();
            assertFalse(test.hasPOS("abgemacht",null));
        }
        //if an exception is triggered, then there is a problem
        catch(FileNotFoundException e){
            fail();
        }
        catch(NullPointerException e){
            fail();
        }
        catch(IOException e){
            fail();
        }
    }
    //test if method returns false for null values
    public void testHasPOSNull3() {
        try {
            POSDict test = new POSDict();
            assertFalse(test.hasPOS(null,null));
        }
        //if an exception is triggered, then there is a problem
        catch(FileNotFoundException e){
            fail();
        }
        catch(NullPointerException e){
            fail();
        }
        catch(IOException e){
            fail();
        }
    }
    //test hasPOS method with a word which is not in dict
    public void testHasPOS1() {
        try {
            POSDict test = new POSDict();
            assertFalse(test.hasPOS("supercalifragilisticexpialidocious", "nn"));
        }
        //if an exception is triggered, then there is a problem
        catch(FileNotFoundException e){
            fail();
        }
        catch(NullPointerException e){
            fail();
        }
        catch(IOException e){
            fail();
        }
    }
    //test hasPOS method with a word which is in dict but with the incorrect POS
    public void testHasPOS2() {
        try {
            POSDict test = new POSDict();
            assertFalse(test.hasPOS("adequately", "nn"));
        }
        //if an exception is triggered, then there is a problem
        catch(FileNotFoundException e){
            fail();
        }
        catch(NullPointerException e){
            fail();
        }
        catch(IOException e){
            fail();
        }
    }
    //test hasPOS method with a word which is in dict but with the incorrect POS
    public void testHasPOS3() {
        try {
            POSDict test = new POSDict();
            assertFalse(test.hasPOS("adequately", "nn"));
        }
        //if an exception is triggered, then there is a problem
        catch(FileNotFoundException e){
            fail();
        }
        catch(NullPointerException e){
            fail();
        }
        catch(IOException e){
            fail();
        }
    }
    //test hasPOS method with a word which is in dict but with multiple POS
    public void testHasPOS4() {
        try {
            POSDict test = new POSDict();
            assertTrue(test.hasPOS("agree", "vbp"));
        }
        //if an exception is triggered, then there is a problem
        catch(FileNotFoundException e){
            fail();
        }
        catch(NullPointerException e){
            fail();
        }
        catch(IOException e){
            fail();
        }
    }
    //test hasPOS method with a word which is in dict but with multiple POS (false)
    public void testHasPOS5() {
        try {
            POSDict test = new POSDict();
            assertFalse(test.hasPOS("agree", "nn"));
        }
        //if an exception is triggered, then there is a problem
        catch(FileNotFoundException e){
            fail();
        }
        catch(NullPointerException e){
            fail();
        }
        catch(IOException e){
            fail();
        }
    }
    //test hasPOS method with a word which is in dict but uppercase
    public void testHasPOS6() {
        try {
            POSDict test = new POSDict();
            assertFalse(test.hasPOS("Agree", "vb"));
        }
        //if an exception is triggered, then there is a problem
        catch(FileNotFoundException e){
            fail();
        }
        catch(NullPointerException e){
            fail();
        }
        catch(IOException e){
            fail();
        }
    }
    //test hasPOS method with a word which is in dict but which POS is uppercase
    public void testHasPOS7() {
        try {
            POSDict test = new POSDict();
            assertTrue(test.hasPOS("agree", "VB"));
        }
        //if an exception is triggered, then there is a problem
        catch(FileNotFoundException e){
            fail();
        }
        catch(NullPointerException e){
            fail();
        }
        catch(IOException e){
            fail();
        }
    }
}