public class LinkedQueue<T> implements QueueADT<T>
{
    private int count;
    private LinearNode<T> head, tail;

    /**
     * Creates an empty queue.
     */
    public LinkedQueue()
    {
        count = 0;
        head = tail = null;
    }

    /**
     * Adds the specified element to the tail of this queue.
     * @param element the element to be added to the tail of the queue
     */
    public void enqueue (T element)
    {
        // Create a new LinearNode to store it in the liked list
        LinearNode<T> node = new LinearNode<T>(element);
        // If the queue is empty, set the head reference to the new element
        if (isEmpty())
            head = node;
        // If not, set the next reference of the current last element to the new element
        else
            tail.setNext (node);
        // Reset the tail reference to the new last element
        tail = node;
        // Update the counter
        count++;
    }

    /**
     * Removes the element at the front of this queue and returns a reference to it.
     * @return a reference to the element at the head of this queue
     * @throws NullPointerException if the stack is empty
     */
    public T dequeue() throws NullPointerException
    {
        // Check that the queue is not empty
        if (isEmpty())
            throw new NullPointerException ("The queue is empty");
        // Get the first element of the list
        T result = head.getElement();
        // Update the head reference to the next element
        head = head.getNext();
        // Update the counter
        count--;
        // If after removal of the first element, the queue is empty, set tail to null
        if (isEmpty())
            tail = null;
        // Return the first element
        return result;
    }

    /**
     * Returns a reference to the element at the front of this queue.
     * The element is not removed from the queue.
     * @return the element at the front of this queue
     * @throws NullPointerException if the queue is empty
     */
    public T first() throws NullPointerException
    {
        // Check that the queue is not empty
        if (isEmpty())
            throw new NullPointerException ("The queue is empty");
        // Get the first element of the list
        return head.getElement();
    }

    /**
     * Check if the queue is empty
     * @return true if this queue is empty and false otherwise.
     */
    public boolean isEmpty()
    {
        return count==0;
    }

    /**
     * Get the size of the queue
     * @return the number of elements currently in this queue.
     */
    public int size()
    {
        return count;
    }

}
