package aug9stacks;

import java.util.Stack;
class MinStackBrute {
    Stack<Integer> stack;

    public MinStackBrute() {
        stack=new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        if(!stack.isEmpty())
            stack.pop();
    }

    public int top() {
        if(!stack.isEmpty())
            return stack.peek();

        return 0;
    }

    public int getMin() {
        int size=stack.size();
        Stack<Integer> temp=new Stack<>();
        int minValue=Integer.MAX_VALUE;
        for(int i=0;i<size;i++){
            minValue=Math.min(minValue,stack.peek());
            temp.push(stack.pop());
        }
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        return minValue;
    }
}

class MinStack1{
    Stack<int[]> stack;
    public MinStack1() {
        stack=new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new int[]{val,val});
        }
        else{
            int minValue=Math.min(val,stack.peek()[1]);
            stack.push(new int[]{val,minValue});
        }
    }

    public void pop() {
        if(!stack.isEmpty())
            stack.pop();
    }

    public int top() {
        if(!stack.isEmpty())
            return stack.peek()[0];
        else
            return 0;
    }

    public int getMin() {
        if(!stack.isEmpty()){
            return stack.peek()[1];
        }
        else
            return 0;
    }
}
class MinStack2 {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack2() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val<=minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            int topElement=stack.pop();
            if(!minStack.isEmpty() && topElement==minStack.peek()){
                minStack.pop();
            }
        }

    }

    public int top() {
        if(!stack.isEmpty())
            return stack.peek();

        return 0;
    }

    public int getMin() {
        if(!minStack.isEmpty())
            return minStack.peek();

        return 0;

    }
}

class MinStackOptimal {
    Stack<Long> st;
    long mini;

    public MinStackOptimal() {
        st=new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push((long) val);
            mini = val;
        } else if (val < mini) {
            st.push(2L * val - mini); // store encoded value
            mini = val;
        } else {
            st.push((long) val);
        }
    }

    public void pop() {
        if (st.isEmpty()) return;
        long top = st.pop();
        if (top < mini) { // encoded value
            mini = 2L * mini - top;
        }
    }

    public int top() {
        long top = st.peek();
        if (top < mini) {
            return (int) mini;
        } else {
            return (int) top;
        }
    }

    public int getMin() {
        return (int)mini;

    }
}

public class MinStack {
    public static void main(String[] args) {

    }
}
