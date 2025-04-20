package linkedlist.singlell;

public class AddTwoNumbersAsLL {
    // 4->5->6->7
    // 7654
    public static long convertToNumber(Node l1){
        long num1=0;
        Node curr1=l1;
        long c=1;
        while(curr1!=null){
            long sum=curr1.data*c+num1;
            num1=sum;
            curr1=curr1.next;
            c=c*10;
        }
       return num1;
    }
    public static Node addTwoNumbersBrute(Node l1, Node l2) {
        long num1=convertToNumber(l1);
        long num2=convertToNumber(l2);
        long sum=num1+num2;

        Node dummy= new Node(-1);
        Node temp=dummy;

        while(sum>0){
            long digit=sum%10;
            temp.next=new Node((int)digit);
            sum=sum/10;
            temp=temp.next;
        }
        return dummy.next;


    }

        public static Node addTwoNumbersOptimal(Node l1, Node l2) {
            Node curr1=l1;
            Node curr2=l2;
            int carry=0;
            Node dummy = new Node(-1);
            Node temp=dummy;
            while(curr1!=null || curr2!=null || carry!=0){
                int sum=0;
                if(curr1!=null){
                    sum+=curr1.data;
                    curr1=curr1.next;
                }
                if(curr2!=null){
                    sum+=curr2.data;
                    curr2=curr2.next;
                }
                sum+=carry;
                carry= sum/10;
                Node node= new Node(sum%10);
                temp.next=node;
                temp=temp.next;
            }

            return dummy.next;

    }

    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head1= singleLinkedList.arrayToLinkedList(new int[]{5,6,7,8,9});
        Node head2=singleLinkedList.arrayToLinkedList(new int[]{2,0,1});
        singleLinkedList.printLinkedList(addTwoNumbersBrute(head1,head2));
        singleLinkedList.printLinkedList(addTwoNumbersBrute(head1,head2));

    }
}
