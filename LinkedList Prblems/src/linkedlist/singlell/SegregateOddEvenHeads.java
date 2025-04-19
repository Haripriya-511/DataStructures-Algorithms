package linkedlist.singlell;

public class SegregateOddEvenHeads {
    public static Node oddEvenList(Node head) {
        if(head==null || head.next==null)
            return head;
        Node odd=head;
        Node even=head.next;
        Node evenHead=even;

        while(even !=null && even.next!=null ){
            odd.next=odd.next.next;

            even.next=even.next.next;

            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head ;

    }
    
    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head= singleLinkedList.arrayToLinkedList(new int[]{1,2,3,4});
        oddEvenList(head);
        singleLinkedList.printLinkedList(head);
        
    }
}
