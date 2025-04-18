package linkedlist.singlell;


import linkedlist.base.BaseLinkedList;

import java.util.ArrayList;
import java.util.List;

public class SingleLinkedListImpl implements BaseLinkedList<Node> {


    @Override
    public Node arrayToLinkedList(int[] arr) {
        int size = arr.length;
        if (size == 0) return null;
        //head creation
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < size; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

        @Override
    public void printLinkedList(Node head) {
            if (head == null) {
                System.out.println("Linked list is empty...");
                return;
            }
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
    }

    @Override
    public int lengthOfLinkedList(Node head) {
        if(head==null)
            return 0;
        int length=0;
        Node current=head;
        while(current!=null){
            length++;
            current=current.next;
        }
        return length;

    }

    @Override
    public boolean searchElement(Node head, int target) {
        Node current=head;
        while(current!=null){
            if(current.data==target)
                return true;
            current=current.next;
        }
        return false;

    }

    @Override
    public List<Integer> linkedListToList(Node head) {
        List<Integer> ans = new ArrayList<>();
        Node current=head;
        while(current!=null){
            ans.add(current.data);
            current=current.next;
        }
        return ans;

    }

    @Override
    public int[] linkedListToArray(Node head) {
        int length= lengthOfLinkedList(head);
        int []arr=new int[length];
        int index=0;
        Node current=head;
        while(current!=null){
            arr[index]=current.data;
            current=current.next;
        }
        return arr;
    }

    @Override
    public Node insertAtHead(Node head, int x) {
        Node newHead=new Node(x);
        newHead.next=head;
        head=newHead;
        return head;
    }

    @Override
    public Node insertAtTail(Node head, int X) {
        Node newNode=new Node(X);
        if(head==null)
            return newNode;
        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=newNode;
        return head;
    }

    @Override
    public Node insertAtKPosition(Node head, int X, int K) {
        if(head==null)
        {
            if(K==1)
                return new Node(X);
            else
                return null;
        }
        // insert at head
        if(K==1){
            return new Node(X,head);
        }
        int cnt=0;
        Node current=head;
        while(current!=null){
            cnt++;
            if(cnt==K-1){
                Node newNode=new Node(X);
                newNode.next=current.next;
                current.next=newNode;
                break;
            }
            current=current.next;
        }
        return head;
    }

    @Override
    public Node insertBeforeX(Node head, int x, int val) {
        if(head.data==x){
            return new Node(val,head);
        }
        Node current=head;
        while(current.next!=null){
            if(current.next.data==x){
                current.next=new Node(val,current.next);
                break;
            }
            current=current.next;
        }
        return head;
    }

    @Override
    public Node deleteHeadNode(Node head) {
        if(head==null || head.next==null)
            return null;

        head= head.next;

        return head;

    }

    @Override
    public Node deleteTailNode(Node head) {
        if(head==null || head.next==null) return null;
        Node current=head;
        Node prev=null;
        while(current.next!=null){
            prev=current;
            current=current.next;
        }
        prev.next=null;


        return head;
    }

    @Override
    public Node deleteKthNode(Node head, int k) {
        if (head == null) return null;

        // Case 1: Deleting the head (k == 1)
        if (k == 1) {
            return head.next;
        }

        Node current = head;
        int count = 1;

        // Move to the (k-1)-th node
        while (current != null && count < k - 1) {
            current = current.next;
            count++;
        }

        // If k is out of bounds (greater than length of list)
        if (current == null || current.next == null) {
            return head;
        }

        // Skip the k-th node
        current.next = current.next.next;

        return head;
    }

    @Override
    public Node deleteNodeWithValueX(Node head, int X) {
        if(head==null) return null;
        if(head.data==X){
            return head.next;
        }
        Node current=head;
        while(current.next!=null){
            if(current.next.data==X){
                current.next=current.next.next;
                break;
            }
            current=current.next;
        }
        return head;
    }
}
