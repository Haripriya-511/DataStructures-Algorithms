package stacks;

import java.util.Stack;

class MinStack1{
    private Stack<int[]> st;

    public MinStack1() {
        st=new Stack<>();
    }

    public void push(int val) {
        if(st.isEmpty()){
            st.push(new int[]{val,val});
            return;
        }
        int mini=Math.min(val,getMin());
        st.push(new int[]{val,mini});

    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek()[0];

    }

    public int getMin() {
        return st.peek()[1];
    }
}
class MinStack2{
    Stack<Integer> st;
    Stack<Integer> minStack;

    public MinStack2() {
        st=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        if(minStack.isEmpty() || val<minStack.peek())
            minStack.push(val);
    }

    public void pop()
    {
        if(st.pop().equals(minStack.peek()))
            minStack.pop();
    }

    public int top() {
        return st.peek();

    }

    public int getMin() {
        return minStack.peek();
    }
    }
class MinStack3{
    Stack<Integer> st=new Stack<>();
    int min;

    public MinStack3() {
        st=new Stack<>();
    }

    public void push(int val) {
        if(st.isEmpty()){
            min=val;
            st.push(0);
        }
        else{
            int diff= val-min;
            st.push(diff);
            if(diff<0)
                min=val;
        }

    }

    public void pop()
    {
        int diff= st.pop();
        if(diff<0)
        {
            min=min-diff;
        }
    }

    public int top() {
        int diff = st.peek();
        if (diff >0) {
            return (min + diff);
        } else {
            return (min);
        }
    }

    public int getMin() {
        return  min;

    }
}
public class MinstackTest {

}
