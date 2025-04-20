package linkedlist.doublell;


import java.util.ArrayList;
import java.util.List;

public class DeleteOccurencesOfTarget 
{
    public static DoublyNode deleteAllOccurrencesBrute(DoublyNode head, int target) {
        List<DoublyNode> l = new ArrayList<>();
        DoublyNode curr = head;
        int cnt=0;

        while (curr != null) {
            cnt++;
            DoublyNode nextDoublyNode = curr.next;
            if (curr.data != target) {

                curr.next = null;
                curr.prev = null;
                l.add(curr);
            }
            curr = nextDoublyNode;
        }

        if(l.size()==cnt) return head;
        if (l.isEmpty()) return null;

        DoublyNode newHead = l.get(0);
        DoublyNode temp = newHead;

        for (int i = 1; i < l.size(); i++) {
            DoublyNode DoublyNode = l.get(i);
            temp.next = DoublyNode;
            DoublyNode.prev = temp;
            temp = DoublyNode;
        }

        return newHead;


    }

    public DoublyNode deleteAllOccurrences(DoublyNode head, int target) {
        DoublyNode curr = head;

        while (curr != null) {
            DoublyNode nextNode = curr.next;

            if (curr.data == target) {
                if (curr.prev == null) {
                    // Deleting the head node
                    head = nextNode;
                    if (nextNode != null) {
                        nextNode.prev = null;
                    }
                } else {
                    // Deleting a middle or last node
                    curr.prev.next = nextNode;
                    if (nextNode != null) {
                        nextNode.prev = curr.prev;
                    }
                }
            }

            curr = nextNode;
        }

        return head;

    }

    public static void main(String[] args) {
        DoubleLinkedListImpl doubleLinkedList = new DoubleLinkedListImpl();
        DoublyNode head= doubleLinkedList.arrayToLinkedList(new int[]{1,2,3,4,2,2,2,5,6});
        head=deleteAllOccurrencesBrute(head,2);
        doubleLinkedList.printLinkedList(head);

        head=doubleLinkedList.arrayToLinkedList(new int[]{7,7,7,7,7});
        head=deleteAllOccurrencesBrute(head,7);
        doubleLinkedList.printLinkedList(head);
    }
}
