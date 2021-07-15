public class LinkedStack<T> implements StackADT<T>
{
    private int count;  // indicates the next open slot
    private LinearNode<T> top;

    /**
     * Creates an empty stack.
     */
    public LinkedStack()
    {
        count = 0;
        top = null;
    }

    /**
     * Adds the specified element to the top of this stack.
     * @param element element to be pushed on stack
     */
    public void push (T element)
    {
        // Create a new LinearNode to store it in the liked list
        LinearNode<T> temp = new LinearNode<T> (element);
        // Set its next reference to the current top of the stack
        temp.setNext(top);
        // Reset the top reference to point to the new node
        top = temp;
        // Increment the count variable
        count++;
    }

    /**
     * Removes the element at the top of this stack and returns a reference to it.
     * Throws an NullPointerException if the stack is empty.
     * @return element from top of stack
     * @throws NullPointerException
     */
    public T pop() throws NullPointerException
    {
        // Check if the stack is empty
        if (isEmpty())
            throw new NullPointerException("The stack is empty");
        // Set a temporary reference equal to the element on top of the stack
        T result = top.getElement();
        // Set the top reference equal to the next reference of the node at the top of the stack
        top = top.getNext();
        // Decrement the counts of elements in the stack
        count--;
        // Return the element pointed to by the temporary reference
        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.
     * @return a reference to the element at the top of the stack
     * @throws NullPointerException if the stack is empty
     */
    public T peek() throws NullPointerException
    {
        // Check if the stack is empty
        if (isEmpty())
            throw new NullPointerException("The stack is empty");
        // Return the element pointed to by the node pointed by the top pointer
        return top.getElement();
    }

    /**
     * Check if the stack is empty
     * @return true if this stack is empty and false otherwise.
     */
    public boolean isEmpty()
    {
        return count==0;
    }

    /**
     * Count elements in stack
     * @return the number of elements in the stack.
     */
    public int size()
    {
        return count;
    }

}