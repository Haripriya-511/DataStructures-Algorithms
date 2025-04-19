package linkedlist.singlell;

import java.util.Stack;

public class PaindrmeLL {
    public static boolean isPalindromeBrute(Node head) {
        Stack<Integer> st=new Stack<>();
        Node curr=head;
        while(curr!=null){
            st.push(curr.data);
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            if(curr.data!=st.pop())
                return false;

            curr=curr.next;
        }
        return true;
    }
    public static Node reverse(Node head){
        if(head== null || head.next==null)
            return head;

        Node curr=head;
        Node prev=null;
        while(curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    public static boolean isPalindromeOptimal(Node head) {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if(fast==null){
            slow=reverse(slow);
        }
        else{
            slow= reverse(slow.next);
        }
        Node newHead=slow;
        Node curr=head;
        while(slow!=null){
            if(slow.data!=curr.data){
                reverse(newHead);
                return false;
            }
            slow=slow.next;
            curr=curr.next;
        }
        reverse(newHead);
        return true;
    }
    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head= singleLinkedList.arrayToLinkedList(new int[]{5,3,7,7,3,5});
        System.out.println(isPalindromeOptimal(head));
        System.out.println(isPalindromeBrute(head));
        /// /////////////////////////////////////
        Node head1=singleLinkedList.arrayToLinkedList(new int[]{1,2,3,4});
        System.out.println(isPalindromeBrute(head1));
        System.out.println(isPalindromeOptimal(head1));
    }
}
