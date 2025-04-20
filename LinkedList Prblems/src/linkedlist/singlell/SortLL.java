package linkedlist.singlell;

public class SortLL {
    public static Node mergeLL(Node left,Node right){
        Node dummy=new Node(-1);
        Node temp=dummy;

        while(left!=null && right!=null){
            if(left.data<=right.data){
                temp.next=left;
                left=left.next;
            }
            else{
                temp.next=right;
                right=right.next;

            }
            temp=temp.next;
        }
        if(left!=null) temp.next=left;
        if(right!=null) temp.next=right;
        return dummy.next;
    }
    public static Node middle(Node head){
        if(head==null || head.next==null)
            return head;
        Node fast=head.next;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public static Node sortLL(Node head){
        if(head==null || head.next==null)
            return head;

        Node midddle=middle(head);
        Node left= head;
        Node right=midddle.next;
        midddle.next=null;

        left=sortLL(left);
        right=sortLL(right);

       return  mergeLL(left,right);

    }
    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head= singleLinkedList.arrayToLinkedList(new int[]{1,2,4,9,8,7,0,23,78,100,43});
        head=sortLL(head);
        singleLinkedList.printLinkedList(head);
    }
}
