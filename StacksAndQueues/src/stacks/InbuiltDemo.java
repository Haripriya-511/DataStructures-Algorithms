package stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class InbuiltDemo {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(10);
        st.push(30);
        st.push(40);
        st.push(50);
        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.search(10));
        System.out.println(st.empty());
        System.out.println(st);

        Deque<Integer> stack=new ArrayDeque<>();
        stack.push(5);
        stack.pop();
        System.out.println(stack);

    }
}
