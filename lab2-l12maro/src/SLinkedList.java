/**
 * Course:      Data Structures and Algorithms for Computational Linguistics II SS2021
 * Assignment:  Lab2
 * Author:      Lorena Martin Rodriguez
 * Description: Implement SimpleList interface.
 *
 * Honor Code:  I pledge that this program represents my own work.
 *  I received help from:
 *   no one
 *  in designing and debugging my program.
 */

/**
 *
 * This class is a linked list implementation of the SimpleList interface.
 *
 */
 
import java.util.*;

public class SLinkedList<T> implements SimpleList<T> {
 	// Variables
	private ListNode head;
	private int numberOfElements;

	public SLinkedList() {
		head = null;
		numberOfElements = 0;
	}
	// Methods
	/**
	* Appends the specified element to the end of this list
	* @param element element to add to the list
	* @return true
	* @throws NullPointerException when element is null
	*/ 
	public boolean add(T element) {
		//check if element is null
		if (element == null){
			throw new NullPointerException("element is null");
		}
		//if list is empty, create
		if (isEmpty()) {
			head = new ListNode(element, head);
			numberOfElements++;
			return true;
		}
		ListNode addElement = new ListNode(element, null);
		//if list only has head, then add first element
		if (numberOfElements == 1) {
			head.next = addElement;
			numberOfElements++;
			return true;
		}
		//if there are several elements, then connect with previous
		else {
			ListNode previous = head;
			//go until the end of the list
			for (int i = 0; i < numberOfElements - 1; i++) {
				previous = previous.next;
			}
			//connect with new element
			previous.next = addElement;
			numberOfElements++;
			return true;
		}
	}
	
	/**
	* Returns the element at the specified position in this list.
	* @param index retrieve position
	* @throws IndexOutOfBoundsException when index is out of bounds (index < 0 || index >= size()) 
	*/
	public T get(int index) {
		//check if index is out of bounds
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException(index + " out of bounds");
		}
		//iterate through the list until reaching index
		ListNode position = head;
		for (int i = 0; i < index; i++) {
			position = position.next;
		}
		return position.data;
	}
	
	/**
	* Returns the index in this list of the first occurrence of the specified element, 
	* or -1 if this list does not contain this element. 
	* @param o Object to search in list
	* @return position of o or -1 if not found
	* @throws NullPointerException when o is null  
	*/ 
	public int indexOf(Object o) {
		//check if object is null
		if (o == null) {
			throw new NullPointerException("element is null");
		}
		//check for empty list
		if(isEmpty()) {
			System.out.println("Empty list");
			return -1;
		}
		//iterate through elements until found or end of list
		ListNode position = head;
		for (int i = 0; i < numberOfElements; i++) {
			if (position.data.equals(o)) {
				return i;
			}
			position = position.next;
		}
		return -1;
	}
	
	/**
	* Returns true if this list contains no elements.       
	* @return true if list contains no elements, false otherwise
	*/       
	public boolean isEmpty() {
		//if head is null, then list is empty
		if (head == null) {
			return true;
		}
		return false;
	}
	
	/**
	* Removes the element at the specified position from this list.
	* @return  element.
	* @throws IndexOutOfBoundsException when index is out of bounds (index < 0 || index >= size())  
	*/
	public T remove(int index) {
		//check if index is out of bounds
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException(index + " out of bounds");
		}
		T removedElement;
		//if index = head then change head
		if (index == 0) {
			//head goes to next if list has more elements
			if (size() > 1) {
				removedElement = head.data;
				head = head.next;
				numberOfElements--;
				return removedElement;
			}
			//if list has only head, remove element
			else {
				removedElement = head.data;
				head = null;
				numberOfElements--;
				return removedElement;
			}
		}
		ListNode position;
		ListNode newLink;
		//if it's in the middle or end iterate through the list until the previous element
		position = head;
		//iterate until the element previous to the removed one
		for (int i = 0; i < index - 1; i++) {
			position = position.next;
		}
		newLink = position;
		//advance newLink to the element to be removed, then store it in a variable
		newLink = newLink.next;
		removedElement = newLink.data;
		if (index != size() - 1) {
			//advance newLink to the element after, then connect position with it
			newLink = newLink.next;
			position.next = newLink;
			numberOfElements--;
			return removedElement;
		}
		//if not, then the element to delete is the last element
		//unlink element
		newLink.next = null;
		numberOfElements--;
		return removedElement;
	}
	
	/**
	* Returns the number of elements in this list.
	* @return number of elements in this list
	*/
	public int size() {
		return numberOfElements;
	}
	
	/** 
	* Return a String representing the SLinkedList<T> The result String consists of a '[' 
	* then the elements of the list separated by a comma and then a ']' character. A list
	* with the elements "Hello" and "World" should return a String "[Hello,World]"
	* @return String representing the list
	*/
	public String toString() {
		ListNode position = head;
		String rval = "[";
		//iterate through the list and add elements to the string
		for (int i = 0; i < size(); i++) {
			rval += position.data;
			if (i != size() - 1) {
				rval += ",";
			}
			position = position.next;
		}
		rval += "]";
		return rval;
	}
	
	public Iterator<T> iterator()
	{
		return new LinkedListIterator();
	}
	
		
	/**
	* This class implements a node in a linked list data structure
	*/
	private class ListNode {
		private T data;
		private ListNode next;
	
		public ListNode()  {
			data = null;
			next = null;
		}
	
		public ListNode(T element, ListNode link)  {
			data = element;
			next = link;
		}
	}
	
	private class LinkedListIterator implements Iterator<T>
	{
		//add variable
		private ListNode position;
		//constructor
		public LinkedListIterator(){
			position = head;
		}
		
		//methods
		public T next(){
			T el = null
			//check if list has next
			if (hasNext()) {
				el = position.data
				position = position.next;
			}
			return el;
		}
		
		public boolean hasNext(){
			if (position == null) {
				return false;
			}
			return true;
		}
		
		
	}
}
