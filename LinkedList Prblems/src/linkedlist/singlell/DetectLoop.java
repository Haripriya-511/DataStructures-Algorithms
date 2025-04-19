package linkedlist.singlell;

import java.util.HashMap;
import java.util.Map;

public class DetectLoop {
    public static boolean hasCycleBrute(Node head) {
        Map<Node,Node> map=new HashMap<>();
        Node curr=head;
        while(curr!=null){
            if(map.containsKey(curr)){
                return true;
            }
            map.put(curr,curr.next);
            curr=curr.next;

        }

        return false;

    }
    public  static  boolean hasCycleOptimal(Node head) {
        Node slow= head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head= singleLinkedList.arrayToLinkedList(new int[]{1,2,3,4,5});
        head.next.next.next.next=head.next.next;
        System.out.println(hasCycleBrute(head));
        System.out.println(hasCycleOptimal(head));
    }
    
}
