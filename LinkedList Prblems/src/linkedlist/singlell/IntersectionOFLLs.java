package linkedlist.singlell;

import java.util.HashMap;

public class IntersectionOFLLs {
    public static Node getIntersectionNodeBrute(Node headA, Node headB) {
        HashMap<Node,Integer> set=new HashMap<>();
        Node curr=headA;
        while(curr!=null){
            set.put(curr,1);
            curr=curr.next;
        }
        curr=headB;
        while(curr!=null){
            if(set.containsKey(curr)){
                return curr;
            }
            curr=curr.next;
        }
        return null;
    }
    public static Node getIntersectionNodeBetter(Node headA, Node headB) {
        int cnt1=0;
        int cnt2=0;
        Node curr1=headA;
        Node curr2=null;
        while(curr1!=null){
            cnt1++;
            curr1=curr1.next;
        }
        curr1=headB;
        while(curr1!=null){
            cnt2++;
            curr1=curr1.next;
        }
        int diff=Math.abs(cnt1-cnt2);
        if(cnt1>cnt2){
            curr1=headA;
            curr2=headB;
        }
        else{
            curr1=headB;
            curr2=headA;
        }
        while(diff>0){
            curr1=curr1.next;
            diff--;
        }
        while(curr1!=null && curr2!=null){
            if(curr1==curr2)
                return curr1;
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return null;

    }
    public static Node getIntersectionNodeOptimal(Node headA, Node headB) {
        if(headA == null || headB==null)
            return null;
        Node h1=headA;
        Node h2=headB;
        if(h1==h2)
            return h1;
        while(h1!=h2){
            h1=h1.next;
            h2=h2.next;
            if(h1==h2)
                return h1;
            if(h1==null) h1=headB;
            if(h2==null) h2=headA;
        }
        return h1;
    }

    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head1= singleLinkedList.arrayToLinkedList(new int[]{1,2,4,9,8,7,90,78});

        Node head2= singleLinkedList.arrayToLinkedList(new int[]{10,6,3});
        head2.next.next=head1.next.next.next.next;

        System.out.println(getIntersectionNodeBetter(head1,head2).data);
        System.out.println(getIntersectionNodeBetter(head1,head2).data);
        System.out.println(getIntersectionNodeOptimal(head1,head2).data);
    }
}
