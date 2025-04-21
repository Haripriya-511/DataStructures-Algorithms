package linkedlist.singlell;

public class ReverseLLinKGroups {
    public static  Node reverse(Node temp){
        if(temp==null || temp.next==null)
            return temp;

        Node curr=temp;
        Node prev=null;
        while(curr!=null){
            Node nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }
    public static Node getKthNode(Node temp,int k){
        k-=1;
        while(temp!=null && k>0)
        {
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public  static Node reverseKGroup(Node head, int k){
        Node temp=head;
        Node prevLast=null;
        while(temp!=null){
            Node kthNode=getKthNode(temp,k);
            //incomplete group
            if(kthNode==null){
                if(prevLast!=null)
                    prevLast.next=temp;
                break;

            }
            Node nextNode=kthNode.next;
            kthNode.next=null;

            reverse(temp);
            if(temp==head){
                head=kthNode;
            }
            else{
                prevLast.next=kthNode;
            }
            prevLast=temp;
            temp=nextNode;

        }
        return head;
    }

    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head1= singleLinkedList.arrayToLinkedList(new int[]{5,6,7,8,9,10,1,23,45,78});
       head1= reverseKGroup(head1,3);
       singleLinkedList.printLinkedList(head1);
    }
}
