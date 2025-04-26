package stacks;

import java.util.Stack;

class MaxStack1{
    private Stack<int[]> st;

    public MaxStack1() {
        st=new Stack<>();
    }

    public void push(int val) {
        if(st.isEmpty()){
            st.push(new int[]{val,val});
            return;
        }
        int maxi=Math.max(val,getMax());
        st.push(new int[]{val,maxi});

    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek()[0];

    }

    public int getMax() {
        return st.peek()[1];
    }
}
class MaxStack2{
    Stack<Integer> st;
    Stack<Integer> maxStack;

    public MaxStack2() {
        st=new Stack<>();
        maxStack=new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        if(maxStack.isEmpty() || val>maxStack.peek())
            maxStack.push(val);
    }

    public void pop()
    {
        if(st.pop().equals(maxStack.peek()))
            maxStack.pop();
    }

    public int top() {
        return st.peek();

    }

    public int getMax() {
        return maxStack.peek();
    }
}
class MaxStack3{
    Stack<Integer> st=new Stack<>();
    int max;

    public MaxStack3() {
        st=new Stack<>();
    }

    public void push(int val) {
        if(st.isEmpty()){
            max=val;
            st.push(0);
        }
        else{
            int diff= val-max;
            st.push(diff);
            if(val>max)
                max=val;
        }

    }

    public void pop()
    {
        int diff= st.pop();
        if(diff>0)
        {
            max=max-diff;
        }
    }

    public int top() {
        int diff = st.peek();
        if (diff > 0) {
            return (max);
        } else {
            return (max+diff);
        }
    }

    public int getMax() {
        return  max;

    }
}
public class MaxStacks {
    public static void main(String[] args) {
        MaxStack3 maxSt=new MaxStack3();
        maxSt.push(5);
        maxSt.push(6);
        maxSt.push(2);
        System.out.println(maxSt.getMax());
        maxSt.pop();
        System.out.println(maxSt.getMax());
        maxSt.pop();
        System.out.println(maxSt.getMax());
        maxSt.pop();



    }
}
