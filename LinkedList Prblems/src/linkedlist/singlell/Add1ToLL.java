package linkedlist.singlell;

public class Add1ToLL {
    public static Node reverseList(Node head){
        if(head==null ||  head.next==null)
            return head;

        Node prev=null;
        Node curr=head;
        Node temp=null;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public static Node addOneBrute(Node head) {

        head=reverseList(head);

        Node curr=head;
        int carry=1;

        while(curr!=null){
            int sum=curr.data+carry;
            carry=sum/10;
            curr.data= sum%10;

            if(carry ==0)
                break;

            if(curr.next==null && carry!=0)
            {
                curr.next=new Node(carry);
                break;
            }
            curr=curr.next;
        }
        head=reverseList(head);
        return head;

    }
    public static int helper(Node head){
        if(head==null)
            return 1;
        Node temp=head;
        int carry=helper(temp.next);
        int sum= carry+temp.data;
        temp.data= sum%10;
        return (sum)/10;

    }
    public static Node addOne(Node head) {
        int carry=helper(head);
        if(carry==1){
            Node newNode=new Node(carry);
            newNode.next=head;
            head=newNode;
        }
        return head;

    }

    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head1= singleLinkedList.arrayToLinkedList(new int[]{1,2,9});
            head1=addOneBrute(head1);
            singleLinkedList.printLinkedList(head1);
        Node head2= singleLinkedList.arrayToLinkedList(new int[]{9,9,9});
        head2=addOne(head2);
        singleLinkedList.printLinkedList(head2);

        Node head3= singleLinkedList.arrayToLinkedList(new int[]{1,2,3});
        head3=addOne(head3);
        singleLinkedList.printLinkedList(head3);




    }

}
