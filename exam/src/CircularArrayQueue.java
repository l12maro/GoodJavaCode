public class CircularArrayQueue<T> implements QueueADT<T>
{
    private final int DEFAULT_CAPACITY = 100;
    private int front, rear, count;
    private T[] queue;

    /**
     * Creates an empty queue using the default capacity.
     */
    public CircularArrayQueue()
    {
        front = rear = count = 0;
        queue = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Creates an empty queue using the specified capacity.
     * @param initialCapacity the initial size of the circular array queue
     */
    public CircularArrayQueue (int initialCapacity)
    {
        front = rear = count = 0;
        queue = (T[]) (new Object[initialCapacity]);
    }

    /**
     * Adds the specified element to the rear of this queue, expanding
     * the capacity of the queue array if necessary.
     * @param element the element to add to the rear of the queue
     */
    public void enqueue (T element)
    {
        // If the array is full, enlarge it
        if (size() == queue.length){
            expandCapacity();
        }
        // Add the element to the queue
        queue[rear] = element;
        // Update the value of rear
        rear = (rear+1) % queue.length;
        // Update the count
        count++;
    }

    /**
     * Removes the element at the front of this queue and returns a reference to it.
     * @return the element removed from the front of the queue
     * @throws NullPointerException if the queue is empty
     */
    public T dequeue() throws NullPointerException
    {
        if (isEmpty()){
            throw new NullPointerException("The queue is empty");
        }
        T result = queue[front];
        queue[front] = null;
        front = (front+1) % queue.length;
        count--;
        return result;
    }

    /**
     * Returns a reference to the element at the front of this queue.
     * The element is not removed from the queue.
     * @return element at the front of the queue
     * @throws NullPointerException if the queue is empty
     */
    public T first() throws NullPointerException
    {
        if (isEmpty()){
            throw new NullPointerException("The queue is empty");
        }
        return queue[front];
    }

    /**
     * Check if the list is empty
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


    /**
     * Creates a new array to store the contents of this queue with
     * twice the capacity of the old one.
     */
    public void expandCapacity()
    {
        T[] larger = (T[]) (new Object[queue.length * 2]);
        for (int scan=0; scan<count; scan++){
            larger[scan] = queue[front];
            front = (front + 1) % queue.length;
        }
        front = 0;
        rear = count;
        queue = larger;
    }
}
