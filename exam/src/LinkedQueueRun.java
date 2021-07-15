public class LinkedQueueRun {
    public static void main(String[] args){
        LinkedQueue<String> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue("first");
        linkedQueue.enqueue("second");
        System.out.println("Expected: first, Result: " + linkedQueue.first());
        System.out.println("Expected: first, Result: " + linkedQueue.dequeue());
        System.out.println("Expected: false1, Result: " + linkedQueue.isEmpty() + linkedQueue.size());
        System.out.println("Expected: second, Result: " + linkedQueue.first());
    }
}
