import java.util.Stack;

public class ArrayStackRun {
    public static void main(String[] args){
        ArrayStack<String> arrayStack = new ArrayStack<>(10);
        arrayStack.push("First");
        System.out.println(arrayStack.peek());
        arrayStack.push("Second");
        System.out.println(arrayStack.peek());
        System.out.println("Expected false: " + arrayStack.isEmpty() + ", Expected 2: " + arrayStack.size());
        System.out.println(arrayStack.pop());
        System.out.println("Expected false: " + arrayStack.isEmpty() + ", Expected 1: " + arrayStack.size());
        System.out.println(arrayStack.pop());
        System.out.println("Expected true: " + arrayStack.isEmpty() + ", Expected 0: " + arrayStack.size());

        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        System.out.println(stack.peek());
    }
}
