package stacks;

public class LinkedListStack {
    private class Node {
        int data;
        Node next;
        Node(int val) {
            this.data = val;
        }
    }
    private Node top;
    int size;
    public LinkedListStack() {

        this.top = null;
        this.size = 0;
    }
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() {
        if(top==null)
            throw new RuntimeException("Underflow");
        int val = top.data;
        top = top.next;
        size--;
        return val;
    }

    public int peek() {
        if(top==null)
            throw new RuntimeException("Empty Stack");
        return top.data;
    }

    public boolean isEmpty() {
        return top==null;
    }
    public int size(){
        return size;
    }
    public void printStack(){
        Node curr=top;
        while(curr!=null) {
            System.out.print(curr.data + "-");
            curr = curr.next;
        }
    }

}
class Test2{
    public static void main(String[] args) {
        LinkedListStack stack=new LinkedListStack();
        for(int i=0;i<10;i++)
            stack.push(i);
        stack.printStack();
    }
}
