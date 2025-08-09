package aug9stacks;

import java.util.LinkedList;
import java.util.Queue;
// Push Costly
class MyStack1 {
    Queue<Integer> dq;

    public MyStack1() {
        dq=new LinkedList<>();
    }

    public void push(int x) {
        int size=dq.size();
        dq.offer(x);
        for(int i=0;i<size;i++){
            dq.offer(dq.peek());
            dq.poll();
        }
    }

    public int pop() {
        return dq.poll();
    }

    public int top() {
        return dq.peek();
    }

    public boolean empty() {
        return dq.size()==0;
    }
}
// Pop Costly
class MyStack2{
    Queue<Integer> dq;

    public MyStack2() {
        dq=new LinkedList<>();
    }

    public void push(int x) {
        dq.offer(x);
    }

    public int pop() {
        int size=dq.size();
        for(int i=0;i<size-1;i++){
            dq.offer(dq.poll());
        }
        return dq.poll();
    }

    public int top() {
        int size=dq.size();
        for(int i=0;i<size-1;i++){
            dq.offer(dq.poll());
        }
        int top= dq.peek();
        dq.offer(dq.poll());
        return top;
    }

    public boolean empty() {
        return dq.size()==0;
    }
}


public class StackUsingQueue {
    public static void main(String[] args) {

    }
}
