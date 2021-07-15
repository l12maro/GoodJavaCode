public class CircularArrayQueueRun {
    public static void main(String[] args){
        CircularArrayQueue<String> circularArrayQueue = new CircularArrayQueue<>();
        circularArrayQueue.enqueue("first");
        circularArrayQueue.enqueue("second");
        System.out.println("Expected: first, Result: " + circularArrayQueue.first());
        System.out.println("Expected: first, Result: " + circularArrayQueue.dequeue());
        System.out.println("Expected: false1, Result: " + circularArrayQueue.isEmpty() + circularArrayQueue.size());
        System.out.println("Expected: second, Result: " + circularArrayQueue.first());
    }
}
