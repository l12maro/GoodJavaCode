import java.util.*;

/**
 * Course:      Data Structures and Algorithms for Language Processing II 2021
 * Assignment:  Lab 2 - Exercise 1
 * Author:      Leyre Sanchez Vinuela
 * Description: Class that is a linked list implementation of the SimpleList interface.
 *
 * Honor Code:  I pledge that this program represents my own work.
 * I received help from nobody in designing and debugging my program.
 *
 * This class is a linked list implementation of the SimpleList interface.
 */

public class SLinkedList<T> implements SimpleList<T> {
	// Variables
	private ListNode head;
	private int numberOfElements;

	// Constructor
	/**
	 * Default constructor: create an empty list
	 */
	public SLinkedList() {
		head = null;
		numberOfElements = 0;
	}

	// Methods

	/**
	 * Appends the specified element to the end of this list
	 *
	 * @param element element to add to the list
	 * @return true
	 * @throws NullPointerException when element is null
	 */
	public boolean add(T element) throws NullPointerException {
		// Check for null arguments
		if (element==null){
			throw new NullPointerException();
		}

		// Create the a new ListNode with the specified element
		ListNode newNode = new ListNode(element, null);
		// If the list is empty, point the head to the new ListNode
		if (head == null) {
			head = newNode;
		}
		// If the list is not empty...
		else {
			// create a node to keep track of the current node in the iteration
			ListNode current = head;
			// iterate the list until its last node (where next == null)
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		numberOfElements++;
		return true;
	}

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param index retrieve position
	 * @return the element at the specified position in this list, or null if the list is empty
	 * @throws IndexOutOfBoundsException when index is out of bounds (index < 0 || index >= size())
	 */
	public T get(int index) throws IndexOutOfBoundsException {
		// Check that index is not out of bounds
		if (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}

		// If the list is empty, print a message and return null
		if (head == null) {
			System.out.println("The list is empty");
			return null;
		}

		// If the list is not empty...
		else {
			// create a node to keep track of the current node in the iteration
			ListNode current = head;
			// iterate through the list until we reach the element in the specified index
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			return current.data;
		}
	}

	/**
	 * Returns the index in this list of the first occurrence of the specified element,
	 * or -1 if this list does not contain this element.
	 *
	 * @param o Object to search in list
	 * @return position of o or -1 if not found
	 * @throws NullPointerException when o is null
	 */
	public int indexOf(Object o) throws NullPointerException {
		// Check for null argument
		if (o==null){
			throw new NullPointerException();
		}

		// If the list is empty, print a message and return -1
		if (head == null) {
			System.out.println("The list is empty");
			return -1;
		}
		// Node to keep track of the current element of the iteration
		ListNode current = head;
		// Iterate the list:
		for (int i = 0; i < numberOfElements; i++) {
			// if the current node equals the object, return its index
			if (current.data.equals(o)) {
				return i;
			}
			// advance to the next node
			current = current.next;
		}
		// If the object is not found in the list, return -1
		return -1;
	}

	/**
	 * Returns true if this list contains no elements.
	 *
	 * @return true if list contains no elements, false otherwise
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Removes the element at the specified position from this list.
	 *
	 * @param index - the position
	 * @return element.
	 * @throws IndexOutOfBoundsException when index is out of bounds (index < 0 || index >= size())
	 */
	public T remove(int index) throws IndexOutOfBoundsException {
		// Check that index is not out of bounds
		if (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		// If the list is empty, print a message and return null
		if (head == null) {
			System.out.println("The list is empty");
			return null;
		}
		// Node to keep track of the current element of the iteration
		ListNode current = head;

		// If the node to remove is in the first position, change the head
		if (index == 0) {
			head = head.next;
		}
		// If not:
		else {
			// create a pNode to keep track of the previous element
			ListNode previous = null;
			// iterate through the rest of the list
			for (int i = 1; i < numberOfElements; i++) {
				previous = current;
				current = current.next;
				// If we reach the desired index or the end of the list, remove the element
				if (i == index || current == null) {
					previous.next = current.next;
					break;
				}
			}
		}
		numberOfElements--;
		return current.data;
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
		// If the list is null, print message
		if (head == null){
			return "The list is empty";
		}

		String result = "[";
		// Node to keep track of the current element of the iteration
		ListNode current = head;
		// Iterate the list and add data of each element to the result
		for(int i=0 ; i < numberOfElements ; i++) {
			result += current.data + ",";
			current = current.next;
		}
		return result.substring(0, result.length()-1) + "]";
	}

	/**
	 * Return a new instance of the inner class Iterator
	 * @return a new instance of Iterator
	 */
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

	// Inner class to iterate through the list
	private class LinkedListIterator implements Iterator <T>
	{
		// Node to keep track of keep track of the iteration
		private ListNode curr;

		// Default constructor: start at head
		public LinkedListIterator(){
			curr = head;
		}
		
		//methods

		// Return the next node in the list
		public T next(){
			// Store the value of the current node
			T node = curr.data;
			// Advance to the current node to prepare the iterator for the next iteration
			curr = curr.next;
			return node;
		}

		// Return true if the list has more elements, false otherwise
		public boolean hasNext(){
			return curr != null;
		}

		// Not implemented method: throw the exception if called
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
}
