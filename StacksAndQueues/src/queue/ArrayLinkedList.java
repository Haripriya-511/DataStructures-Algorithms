package queue;

public class ArrayLinkedList {
    private static class Node {
        int data;
        Node next;
        Node(int val) { data = val; }
    }

    private Node front, rear;

    public ArrayLinkedList(){
        rear=front=null;
    }
    public void enqueue(int x) {
        Node newNode = new Node(x);
        if (rear != null)
        {
            rear.next = newNode;
            rear = newNode;
        }

        if (front == null) {
            rear=front = newNode;
        }
    }
    public int dequeue(){
        if (front == null) {
            throw new RuntimeException("Queue Underflow");
        }

        int val = front.data;
        front = front.next;

        if (front == null) rear = null; // Queue becomes empty
        return val;
    }
    public int peek() {
        if (front == null) {
            throw new RuntimeException("Queue is Empty");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Node curr = front;
        System.out.print("Queue: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

}
class Main {
    public static void main(String[] args) {
        ArrayLinkedList queue = new ArrayLinkedList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display(); // Queue: 10 20 30

        System.out.println("Dequeued: " + queue.dequeue()); // 10
        queue.display(); // Queue: 20 30

        System.out.println("Peek: " + queue.peek()); // 20
    }
}
