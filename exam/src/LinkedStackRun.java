public class LinkedStackRun {
    public static void main(String[] args){
        LinkedStack<String> linkedStack = new LinkedStack<>();
        linkedStack.push("uno");
        System.out.println(linkedStack.peek());
        System.out.println("Expected false: " + linkedStack.isEmpty() + ", Expected 1: " + linkedStack.size());
        linkedStack.push("dos");
        System.out.println(linkedStack.peek());
        System.out.println("Expected false: " + linkedStack.isEmpty() + ", Expected 2: " + linkedStack.size());
        System.out.println(linkedStack.pop());
        System.out.println("Expected false: " + linkedStack.isEmpty() + ", Expected 1: " + linkedStack.size());
        System.out.println(linkedStack.pop());
        System.out.println("Expected true: " + linkedStack.isEmpty() + ", Expected 0: " + linkedStack.size());
    }
}
