package linkedlist.singlell;

public class DeleteMiddleNode {
    public static Node deleteMiddle(Node head) {
        if(head==null || head.next==null) return null;
        Node fast=head;
        Node slow=head;
        Node temp=null;


        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            temp=slow;
            slow=slow.next;
        }
        temp.next=slow.next;
        slow=null;
        return head;

    }
    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head= singleLinkedList.arrayToLinkedList(new int[]{1,2,3,4,5,6});
        head=deleteMiddle(head);
        singleLinkedList.printLinkedList(head);
        head=deleteMiddle(head);
        singleLinkedList.printLinkedList(head);
    }
    
}
