package stacks;

public class ArrayStack {
    private int top;
    private int[] arr;
    public ArrayStack(){
        this(10);
    }
    public ArrayStack(int capacity){

        arr=new int[capacity];
        top=-1;

    }
    public void push(int x){
        if(top==arr.length-1)
            throw  new RuntimeException("Stack overflow...");
        arr[++top]=x;

    }
    public int pop(){
        if(top==-1)
            throw new RuntimeException("Stack underflow...");
        return arr[top--];
    }
    public int peek(){
        if(top==-1)
            throw new RuntimeException("Empty Stack");
        return arr[top];
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public int currSize(){
        return top+1;
    }
    public void printStack(){
if(isEmpty())
    return;
       for(int i=top;i>=0;i--)
           System.out.println(arr[i]);
    }
}
class Test{
    public static void main(String[] args) {
        ArrayStack stack=new ArrayStack();
        for(int i=0;i<10;i++)
            stack.push(i);
        stack.printStack();
    }
}
