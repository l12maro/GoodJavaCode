/**
 * SimpleList Interface
 */

import java.util.*;

/**
 * This interface defines a subset of SUN's <b>List</b> interface
 */
public interface SimpleList<T> {
 
/**
  * Appends the specified element to the end of this list
  * @param element element to add to the list
  * @return true
  * @throws NullPointerException when element is null
  */
 public boolean add(T element);
 
 /**
  * Returns the element at the specified position in this list.
  * @param index retrieve position
  * @throws IndexOutOfBoundsException when index is out of bounds (i < 0 || i>=size)  
  */
 public T get(int index);
 
 /**
  * Returns the index in this list of the first occurrence of the specified element, 
  * or -1 if this list does not contain this element. 
  * @param o Object to search in list
  * @return position of o or -1 if not found
  */  
 public int indexOf(Object o);
    
 /**
  * Returns true if this list contains no elements.       
  * @return true if list contains no elements, false otherwise
  */       
 public boolean isEmpty();
 
 /**
  * Returns an iterator over the elements in this list in proper sequence. 
  * @return iterator over the elements in this list
  */
 // This method only has to be uncommented and implemented if you want to complete the bonus exercise
 // public Iterator<T> iterator(); 
    
 /**
  * Removes the element at the specified position from this list.
  * @return  element.
  * @throws IndexOutOfBoundsException when index is out of bounds (i < 0 || i>=size)  
  */
  public T remove(int index);       
 
 /**
  * Returns the number of elements in this list.
  * @return number of elements in this list
  */
 public int size(); 
 
 /** 
  * Return a String representing the SimpleList<T>. The result String consists of a '[' then the toString output of the elements
  * of the list separated by a comma and then a ']' character. A list with the elements "Hello" and "World"
  * should create a String "[Hello,World]".
  * @return String representing the list.
  */  
  public String toString();
           
}
