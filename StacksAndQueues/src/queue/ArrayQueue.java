package queue;
public class ArrayQueue {
    private final int[] arr;
    private int front,rear,size;
    private final int capacity;
    public ArrayQueue(){
        this(10);
    }
    public ArrayQueue(int capacity){
        this.capacity=capacity;
        arr=new int[capacity];
        size=0;
        front=rear=-1;
    }
    public void enqueue(int x){
        if((rear+1)%capacity==front)
            throw new RuntimeException("Over flow");
        if(front==-1)
            front=rear=0;
        else
            rear=(rear+1)%capacity;
        size++;
        arr[rear]=x;
    }
    public int dequeue(){
        if(front==-1)
            throw new RuntimeException("Queue UnderfLow");
        int val=arr[front];
        if(front==rear)
            front=rear=-1;
        else{
            front= (front+1)%capacity;
        }
        size--;
        return val;
    }
    public int peek(){
        if(front==-1)
            throw new RuntimeException("Queue is Empty");
        return arr[front];
    }
    public boolean isEmpty(){
        return front==-1;
    }
    public boolean isFull(){
        return (rear+1)%capacity==front;
    }
    public int size(){
        return size;
    }
    public void display(){
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int i=front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) break;
            i = (i + 1) % capacity;
        }

    }


}
class Test3{
    public static void main(String[] args) {
        ArrayQueue queue=new ArrayQueue();
        for(int i=0;i<10;i++){
            queue.enqueue(i);
        }
        for (int i=0;i<6;i++)
            System.out.println(queue.dequeue());
        queue.display();
    }
}
