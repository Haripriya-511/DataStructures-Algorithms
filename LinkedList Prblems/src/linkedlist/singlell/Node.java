package linkedlist.singlell;

import linkedlist.base.BaseNode;

public class Node  implements BaseNode {
    int data;
    Node next;
    //constructors
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
    Node(int data){
        this.data=data;
        this.next=null;
    }

    @Override
    public int getData() {
        return data;
    }
}
