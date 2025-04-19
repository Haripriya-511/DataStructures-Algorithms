package linkedlist.singlell;

import java.util.HashMap;
import java.util.Map;

public class StartPointOfCycle {
    public static Node findStartingPointBrute(Node head) {
        Map<Node,Node> map=new HashMap<>();
        Node curr=head;
        while(curr!=null){
            if(map.containsKey(curr)){
                return curr;
            }
            map.put(curr,curr.next);
            curr=curr.next;

        }

        return null;
    }

    public static Node findStartingPointOptimal(Node head) {

        Node slow= head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;

                }
                return slow;

            }
        }
        return null;

    }

    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head= singleLinkedList.arrayToLinkedList(new int[]{1,2,3,4,5});
        head.next.next.next.next=head.next.next;
        System.out.println(findStartingPointBrute(head).data);
        System.out.println(findStartingPointOptimal(head).data);
    }

}
