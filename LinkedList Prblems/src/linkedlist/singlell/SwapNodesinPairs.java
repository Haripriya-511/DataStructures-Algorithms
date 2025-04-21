package linkedlist.singlell;

public class SwapNodesinPairs {
    public static Node swapPairsOptimal(Node head) {
        if(head==null || head.next==null)
            return head;
        Node dummy=new Node(-1);
        Node prev=dummy;
        Node curr=head;

        // Traverse the list and swap data in pairs
        while (curr != null && curr.next != null) {
            Node nextTonext=curr.next.next;
            Node second=curr.next;

            second.next=curr;
            curr.next=nextTonext;
            prev.next=second;

            prev=curr;
            curr=nextTonext;
        }
        return dummy.next;
    }
    public static Node swapPairsBrute(Node head) {
        Node curr = head;

        // Traverse the list and swap data in pairs
        while (curr != null && curr.next != null) {
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;

            // Move to the next pair
            curr = curr.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head1= singleLinkedList.arrayToLinkedList(new int[]{1,2,3,4,5});
        head1=swapPairsOptimal(head1);
        singleLinkedList.printLinkedList(head1);
        head1=swapPairsBrute(head1);
        singleLinkedList.printLinkedList(head1);

    }
}
