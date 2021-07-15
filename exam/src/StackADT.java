// Stack abstract interface
public interface StackADT<T> {
    // Adds one element to the top
    public void push(T element);
    // Remove and return top element
    public T pop();
    // Return without removing top element
    public T peek();
    // Return true if stack is empty
    public boolean isEmpty();
    // Return the number of elements
    public int size();
    // Return a string representation of the stack
    public String toString();
}