package linkedlist.singlell;

public class SegregateOddEvenintoGroups {
   public static Node divide(Node head) {
        Node evenDummy=new Node(-1);
        Node evenTemp=evenDummy;

        Node temp=head;
        Node prev= null;

        while(temp!=null){
            if(temp.data%2==0){
                if(prev!=null){
                    prev.next=temp.next;
                }
                else{
                    head=temp.next;
                }
                evenTemp.next=temp;
                evenTemp=evenTemp.next;

                temp=temp.next;
            }
            else{
                prev=temp;
                temp=temp.next;
            }
        }
        if(evenDummy.next==null)
            return head;
        evenTemp.next=head;

        return evenDummy.next;

    }
    public static Node divide2(Node head) {
        Node oStart = new Node(0);
        Node eStart = new Node(0);
        // Pointers to the end of the even and odd lists
        Node eEnd = eStart;
        Node oEnd = oStart;

        // Node to traverse the list
        Node curr = head;

        while (curr != null) {
            int val = curr.data;

            // If current value is even, add it to the even list
            if (val % 2 == 0) {
                eEnd.next = curr;
                eEnd = eEnd.next;
            } else { // Else to the odd list
                oEnd.next = curr;
                oEnd = oEnd.next;
            }

            // Move to the next node
            curr = curr.next;
        }

        // Terminate the odd list
        oEnd.next = null;

        // Combine even and odd lists
        eEnd.next = oStart.next;

        // Return the new head of the combined list (even head)
        return eStart.next;

    }

    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head1= singleLinkedList.arrayToLinkedList(new int[]{1,2,3,4,5,6,7,8});
       head1= divide(head1);
       singleLinkedList.printLinkedList(head1);
        Node head2= singleLinkedList.arrayToLinkedList(new int[]{13,15,1,3,5,7});
       head2=divide2(head2);
       singleLinkedList.printLinkedList(head2);
    }
}
