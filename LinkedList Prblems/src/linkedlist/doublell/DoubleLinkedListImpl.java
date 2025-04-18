package linkedlist.doublell;


import linkedlist.base.BaseLinkedList;


import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedListImpl implements BaseLinkedList<DoublyNode> {

    @Override
    public DoublyNode arrayToLinkedList(int[] arr) {
        int size = arr.length;
        if (size == 0) return null;
        //head creation
        DoublyNode head = new DoublyNode(arr[0]);
        DoublyNode current = head;
        for (int i = 1; i < size; i++) {
            DoublyNode newNode = new DoublyNode(arr[i]);
            newNode.prev = current;
            current.next = newNode;
            current = newNode;
        }
        return head;
    }

    @Override
    public void printLinkedList(DoublyNode head) {
        if (head == null) {
            System.out.println("Linked list is empty...");
            return;
        }
        DoublyNode current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    @Override
    public int lengthOfLinkedList(DoublyNode head) {
        if (head == null)
            return 0;
        int length = 0;
        DoublyNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    @Override
    public boolean searchElement(DoublyNode head, int target) {
        DoublyNode current = head;
        while (current != null) {
            if (current.data == target)
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public List<Integer> linkedListToList(DoublyNode head) {
        List<Integer> ans = new ArrayList<>();
        DoublyNode current = head;
        while (current != null) {
            ans.add(current.data);
            current = current.next;
        }
        return ans;
    }

    @Override
    public int[] linkedListToArray(DoublyNode head) {
        int length = lengthOfLinkedList(head);
        int []arr = new int[length];
        int index = 0;
        DoublyNode current = head;
        while (current != null) {
            arr[index] = current.data;
            current = current.next;
        }
        return arr;
    }

    @Override
    public DoublyNode insertAtHead(DoublyNode head, int x) {
        DoublyNode newHead = new DoublyNode(x);
        head.prev = newHead;
        newHead.next = head;
        head = newHead;
        return head;
    }

    @Override
    public DoublyNode insertAtTail(DoublyNode head, int X) {
        DoublyNode newHead = new DoublyNode(X);
        head.prev = newHead;
        newHead.next = head;
        head = newHead;
        return head;
    }
        /*
        Input: head -> 1 <-> 3 <-> 5, X = 7, K = 2

        Output: head -> 1 <-> 7 <-> 3 <-> 5
     */

    @Override
    public DoublyNode insertAtKPosition(DoublyNode head, int X, int K) {
        if (head == null) {
            if (K == 1) {
                return new DoublyNode(X);
            } else {
                return null;
            }
        }
        if (K == 1) {
            DoublyNode node = new DoublyNode(X, head, null);
            head.prev = node;
            return node;
        }
        DoublyNode current = head;
        int cnt = 0;
        while (current != null) {
            cnt++;
            if (cnt == (K - 1)) {
                DoublyNode newNode = new DoublyNode(X);
                newNode.next = current.next;
                current.next.prev = newNode;
                newNode.prev = current;
                current.next = newNode;
                break;
            }
            current = current.next;
        }
        return head;
    }

    @Override
    public DoublyNode insertBeforeX(DoublyNode node, int val, int X) {
        if(node==null) return null;
        if(node.data==val)
        {
            DoublyNode newNode= new DoublyNode(X,node,null);
            node.prev=newNode;
                        return newNode;

                    }

        DoublyNode curr=node;
        while(curr!=null){
            if(curr.data==val){
                break;
            }
            curr=curr.next;
        }
        DoublyNode newNode=new DoublyNode(X);
        newNode.prev=curr.prev;
        curr.prev.next=newNode;
        newNode.next=curr;
        curr.prev=newNode;

        return node;

    }

    @Override
    public DoublyNode deleteHeadNode(DoublyNode head) {
        if(head==null || head.next==null)
            return null;
        head=head.next;
        head.prev.next=null;
        head.prev=null;
        return head;
    }

    @Override
    public DoublyNode deleteTailNode(DoublyNode head) {
        if(head==null || head.next==null)
            return null;
        DoublyNode current=head;
        while(current.next!=null){
            current=current.next;


        }
        DoublyNode prev=current.prev;
        prev.next=null;
        current.prev=null;
        return head;
    }

    @Override
    public DoublyNode deleteKthNode(DoublyNode head, int k) {
        if(head==null) return null;
        if(k==1){
            if(head.next==null)
                return null;
            head=head.next;
            head.prev.next=null;
            head.prev=null;
            return head;
        }
        DoublyNode current=head;
        int cnt=0;
        while(current.next!=null){
            cnt++;
            if(k==cnt){

                break;
            }
            current=current.next;
        }

        DoublyNode prev=current.prev;
        prev.next=current.next;
        // this condition is needed in case if given node is last node

        if(current.next!=null)
            current.next.prev=prev;
        current.next=null;
        current.prev=null;

        return head;
    }

    @Override
    public DoublyNode deleteNodeWithValueX(DoublyNode head, int X) {
        return null;
    }

    public void insertBeforeGivenNode(DoublyNode node, int X) {

        DoublyNode prev=node.prev;

        DoublyNode newNode=new DoublyNode(X,node,prev);
        prev.next=newNode;
        node.prev=newNode;


    }
    public void deleteGivenNode(DoublyNode node) {

        DoublyNode prev= node.prev;
        if(prev!=null)
            prev.next=node.next;
        if(node.next!=null)
            node.next.prev=prev;




    }
}
