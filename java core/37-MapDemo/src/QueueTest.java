import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Apple");
        queue.offer("Mango");
        queue.offer("Orange");
        queue.offer("Mango");
        

        System.out.println("Queue elements: " + queue);

        System.out.println("Peeked element: " + queue.peek());

        System.out.println("Removed element: " + queue.poll());

        System.out.println("Updated queue elements: " + queue);

        System.out.println("Contains 'Banana': " + queue.contains("Banana"));

        System.out.println("Size of the queue: " + queue.size());

        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
