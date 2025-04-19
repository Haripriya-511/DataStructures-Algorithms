package linkedlist.singlell;

public class LengthOfCycle {

    public static int countNodesinLoopOptimal(Node head) {

        Node slow= head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                int cnt=1;
                slow=slow.next;
                while(slow!=fast){
                    slow=slow.next;
                    cnt++;
                }
                return cnt;

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head= singleLinkedList.arrayToLinkedList(new int[]{1,2,3,4,5});
        head.next.next.next.next=head.next.next;

        System.out.println(countNodesinLoopOptimal(head));
    }
}
