package linkedlist.singlell;

public class ReorderLL {

    public static Node reverse(Node head){
        if(head==null || head.next==null)
            return head;
        Node prev= null;
        Node curr=head;
        while(curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public static void reorderList(Node head) {
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        Node l1=slow.next;
        slow.next=null;
       l1=reverse(l1);
        Node temp=head;


        while(l1!=null){
            Node nextNode=temp.next;
            Node nextNode2=l1.next;
            temp.next=l1;
            l1.next=nextNode;

            temp=nextNode;
            l1=nextNode2;
        }
    }
    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head1= singleLinkedList.arrayToLinkedList(new int[]{1,2});
        Node head2= singleLinkedList.arrayToLinkedList(new int[]{1,2,3,4,5,6});
        reorderList(head1);
        reorderList(head2);



    }
}
