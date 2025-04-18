package linkedlist.singlell;

public class ReverseLinkedList {
    public static Node reverseLinkedListIterative(Node head){
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
    public static Node reverseLinkedListRecursive(Node head){
        if(head==null || head.next==null)
            return head;

        Node newHead=reverseLinkedListRecursive(head.next);
        Node front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }

    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList = new SingleLinkedListImpl();
        Node head= singleLinkedList.arrayToLinkedList(new int[]{1,2,3,4,5});
        System.out.println("Before reversal:");
        singleLinkedList.printLinkedList(head);
        head= reverseLinkedListIterative(head) ;
        System.out.println("after reversal:");
        singleLinkedList.printLinkedList(head);

        System.out.println("---------------");

        Node head2= singleLinkedList.arrayToLinkedList(new int[]{10,20,30,40});
        System.out.println("Before reversal:");
        singleLinkedList.printLinkedList(head2);
        head2= reverseLinkedListRecursive(head2) ;
        System.out.println("after reversal:");
        singleLinkedList.printLinkedList(head2);



    }
}
