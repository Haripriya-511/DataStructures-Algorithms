package aug9stacks;

import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
    Deque<Integer> st1,st2;
    public MyQueue() {
        st1=new ArrayDeque<>();
        st2=new ArrayDeque<>();
    }

    public void push(int x) {
        while(st1.size()>0){
            st2.push(st1.peek());
            st1.pop();
        }
        st1.push(x);
        while(st2.size()>0){
            st1.push(st2.peek());
            st2.pop();
        }
    }

    public int pop() {
        return st1.pop();
    }

    public int peek() {
        return st1.peek();
    }

    public boolean empty() {
        return st1.size()==0;
    }
}
class MyQueue2 {
    Deque<Integer> st1,st2;
    public MyQueue2() {
        st1=new ArrayDeque<>();
        st2=new ArrayDeque<>();
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.pop();

    }

    public int peek() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }

    public boolean empty() {
        return st1.size()==0 && st2.size()==0;
    }
}

public class QueueUsingStack {
    public static void main(String[] args) {

    }
}
