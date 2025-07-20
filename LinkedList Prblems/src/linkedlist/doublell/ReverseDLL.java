package linkedlist.doublell;

import linkedlist.singlell.Node;
import linkedlist.singlell.SingleLinkedListImpl;

public class ReverseDLL
{
    public static DoublyNode reverseLinkedListIterative(DoublyNode head){
        DoublyNode curr=head;
        DoublyNode temp=null;

        while(curr!=null){
           temp=curr.prev;
           curr.prev=curr.next;
           curr.next=temp;
           curr=curr.prev;
        }
        return temp.prev;
    }

    public static void main(String[] args) {
        DoubleLinkedListImpl doubleLinkedList = new DoubleLinkedListImpl();
        DoublyNode head= doubleLinkedList.arrayToLinkedList(new int[]{1,2,3,4,5});
        System.out.println("Before reversal:");
        doubleLinkedList.printLinkedList(head);
        head= reverseLinkedListIterative(head) ;
        System.out.println("after reversal:");
        doubleLinkedList.printLinkedList(head);
    }
}
