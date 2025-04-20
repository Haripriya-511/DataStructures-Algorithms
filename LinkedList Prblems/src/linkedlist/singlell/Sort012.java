package linkedlist.singlell;

public class Sort012 {
    public static Node sortListOptimal(Node head){
        if (head == null || head.next == null)
            return head;

        Node zeroHead=new Node(-1);
        Node oneHead=new Node(-1);
        Node twoHead=new Node(-1);

        Node one=oneHead;
        Node zero=zeroHead;
        Node two=twoHead;

        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
                zero.next=temp;
                zero=temp;

            }
            else if(temp.data==1){
                one.next=temp;
                one=temp;
            }
            else if(temp.data==2){
                two.next=temp;
                two=temp;

            }
            temp=temp.next;
        }


        zero.next= (oneHead.next !=null)? oneHead.next : twoHead.next;
        one.next=twoHead.next;

        two.next=null;
        Node newHead=zeroHead.next;
        return newHead;

    }
    public static Node sortListBrute(Node head) {
        int zero=0;
        int one=0;
        int two=0;
        Node temp=head;
        while(temp!=null){
            if(temp.data==0) zero++;
            if(temp.data==1) one++;
            if(temp.data==2) two++;
            temp=temp.next;
        }
        temp=head;
        while(zero>0){
            temp.data=0;
            zero--;
            temp=temp.next;

        }
        while(one>0){
            temp.data=1;
            one--;
            temp=temp.next;
        }
        while(two>0){
            temp.data=2;
            two--;
            temp=temp.next;
        }
        return head;
    }
    

    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head= singleLinkedList.arrayToLinkedList(new int[]{0,1,2,1,2,0,0,0,1,1});
      head=sortListBrute(head);
        singleLinkedList.printLinkedList(head);
        head=sortListOptimal(head);
        singleLinkedList.printLinkedList(head);
    }
}
