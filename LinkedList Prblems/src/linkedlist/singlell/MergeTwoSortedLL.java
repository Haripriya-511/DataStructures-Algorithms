package linkedlist.singlell;

public class MergeTwoSortedLL {

    public static Node mergeTwoLists(Node l1, Node l2) {
        Node dummy=new Node(-1);
        Node temp=dummy;

        while(l1!=null && l2!=null){
            if(l1.data<=l2.data){
                temp.next=l1;
                l1=l1.next;
            }
            else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;

        }
        if(l1!=null)
            temp.next=l1;
        if(l2!=null)
            temp.next=l2;

        return dummy.next;
    }

    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head1= singleLinkedList.arrayToLinkedList(new int[]{1,2,3,4,5});
        Node head2=singleLinkedList.arrayToLinkedList(new int[]{4,5,6,7,8,9});
        singleLinkedList.printLinkedList(mergeTwoLists(head1,head2));
    }
}
