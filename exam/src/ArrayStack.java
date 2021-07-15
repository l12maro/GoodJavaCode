import java.util.Arrays;

// Array implementation using a stack
public class ArrayStack<T> implements StackADT<T>{
    private final static int DEFAULT_CAPACITY = 100;
    private int top;
    private T[] stack;

    /**
     * Creates an empty stack using the default capacity
     */
    public ArrayStack(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty stack using the specified capacity
     * @param initialCapacity the initial size of the array
     */
    public ArrayStack(int initialCapacity){
        top = 0;
        stack = (T[])(new Object[initialCapacity]);
    }

    /**
     * Adds the specified element to the top of this stack, expanding
     * the capacity of the array if necessary
     * @param element generic element to be pushed onto the stack
     */
    public void push(T element){
        // If the array is full, expand it
        if (size() == stack.length){
            expandCapacity();
        }
        // Set the reference in the top of the array to the object being added to the stack
        stack[top] =  element;
        // Increment the value of top
        top++;
    }

    /**
     * Creates a new array to store the contents of this stack with
     * twice the capacity of the old one
     */
    private void expandCapacity(){
        stack = Arrays.copyOf(stack, stack.length*2);
    }

    /**
     * Removes the element at the top of this stack and returns a reference to it
     * @return the element removed from the top of the stack
     * @throws NullPointerException if stack is empty
     */
    public T pop() throws NullPointerException{
        // Check that the stack is not empty
        if (isEmpty()){
            throw new NullPointerException();
        }
        // Decrement the top counter
        top--;
        // Set a temporary reference equal to the element in the top of the stack
        T result = stack[top];
        // Set the reference in the top of the stack to null
        stack[top] = null;
        // Return the temporary reference
        return result;
    }

    /**
     * Returns a reference to the element at the top of the stack without removing it
     * @return element on the top of the stack
     * @throws NullPointerException if stack is empty
     */
    public T peek() throws NullPointerException{
        // Check that the stack is not empty
        if (isEmpty()){
            throw new NullPointerException();
        }
        // Return a reference to the element at position top-1
        return stack[top-1];
    }

    // Check if the stack is empty
    public boolean isEmpty(){
        return top==0;
    }

    // Return the size of the stack
    public int size(){
        return top;
    }
}
