package linkedlist.doublell;

public class RemoveDuplicated {
    public static  DoublyNode removeDuplicates(DoublyNode head) {
        if(head==null || head.next==null)
            return head;
        DoublyNode temp=head;
        while(temp!=null){
            DoublyNode nextNode = temp.next;

            // Remove all duplicate nodes
            while (nextNode != null && nextNode.data == temp.data) {

                nextNode = nextNode.next;

            }
            temp.next=nextNode;
            if(nextNode!=null)

                nextNode.prev=temp;
            temp=nextNode;

        }
        return head;
    }

    public static void main(String[] args) {
        DoubleLinkedListImpl doubleLinkedList = new DoubleLinkedListImpl();
        DoublyNode head= doubleLinkedList.arrayToLinkedList(new int[]{1,1,1,2,3,3,3,4,4,5});
        doubleLinkedList.printLinkedList(removeDuplicates(head));
    }
}
