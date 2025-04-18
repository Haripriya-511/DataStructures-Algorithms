package linkedlist.singlell;

public class MiddleOfLinkedList {
    public static Node middleOfLinkedListBrute(Node head) {
        int cnt=0;
        Node current=head;
        while(current!=null){
            cnt++;
            current=current.next;
        }
        current=head;
        int middle=cnt/2;
        cnt=0;
        while(current!=null){

            if(cnt== middle){
                return current;

            }
            cnt++;
            current=current.next;
        }
        return null;
    }

    public static Node middleOfLinkedListOptimal(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList = new SingleLinkedListImpl();
        Node head= singleLinkedList.arrayToLinkedList(new int[]{1,2,3,4,5});
        System.out.println(middleOfLinkedListBrute(head).data);

        System.out.println(middleOfLinkedListOptimal(head).data);



    }
}
