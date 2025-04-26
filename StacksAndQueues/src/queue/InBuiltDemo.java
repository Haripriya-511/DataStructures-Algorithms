package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class InBuiltDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);   // Add
        queue.poll();        // Remove head
        queue.peek();        // View head
        queue.isEmpty();
        System.out.println(queue);

//Double ended queue
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerFirst(10); // Add front
        dq.offerLast(20);  // Add back
        dq.pollFirst();    // Remove front
        dq.pollLast();
        System.out.println(dq);

        // Single Ended queue
        Queue<Integer> queue1 = new ArrayDeque<>();

        // Add elements
        queue1.offer(10);
        queue1.offer(20);
        queue1.offer(30);

        // Peek (look at front)
        System.out.println("Front: " + queue1.peek());  // 10

        // Poll (remove front)
        System.out.println("Removed: " + queue1.poll()); // 10
        System.out.println("Now Front: " + queue1.peek()); // 20

        // Traverse the queue
        System.out.print("Remaining: ");
        for (int num : queue1) {
            System.out.print(num + " "); // 20 30
        }
    }
}
