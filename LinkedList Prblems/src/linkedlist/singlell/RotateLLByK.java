package linkedlist.singlell;

public class RotateLLByK {
    public static Node rotateRight(Node head, int k) {
        if(head==null || head.next==null)
            return head;
        int cnt=1;
        Node curr=head;
        while(curr!=null && curr.next!=null){
            cnt++;
            curr=curr.next;
        }
        k=k%cnt;
        if(k==0)
            return head;
        k=cnt-k;
        Node temp=head;
        k-=1;
        while(temp!=null && k>0)
        {
            k--;
            temp=temp.next;
        }
        Node newHead=temp.next;
        temp.next=null;
        curr.next=head;
        return newHead;
    }

    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head1= singleLinkedList.arrayToLinkedList(new int[]{1,2,3,4,5});
        head1=rotateRight(head1,41);
        singleLinkedList.printLinkedList(head1);

    }
}
