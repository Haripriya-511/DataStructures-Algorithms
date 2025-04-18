package linkedlist.doublell;

import linkedlist.base.BaseNode;

public class DoublyNode implements BaseNode {
    int data;
    DoublyNode next,prev;

    public DoublyNode(int data ){
        this.data=data;
        next=null;
        prev=null;
    }

    public DoublyNode(int data, DoublyNode next, DoublyNode back) {
        this.data = data;
        this.next = next;
        this.prev = back;
    }

    @Override
    public int getData() {
        return data;
    }
}
