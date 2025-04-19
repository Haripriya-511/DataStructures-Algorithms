package linkedlist.singlell;

public class DeleteNthNodeFromBack {
    public static Node removeNthFromEndBrute(Node head, int n) {

        int cnt=0;
        Node curr=head;
        while(curr!=null){
            curr=curr.next;
            cnt++;
        }
        int kthNode= (cnt-n+1);
        if(kthNode==1){
            return head.next;
        }

        cnt=0;
        curr=head;
        while(curr!=null){
            cnt++;
            if(cnt==(kthNode-1)){
                break;
            }
            curr=curr.next;
        }
       
            curr.next=curr.next.next;


        return head;



    }
    
    public static Node removeNthFromEndOptimal(Node head, int n) {

        if(head==null) return null;

        Node fast=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        if(fast==null){
            return head.next;
        }
        Node slow=head;
        while(fast.next!=null ){
            slow=slow.next;
            fast=fast.next;
        }
       
        slow.next=slow.next.next;
       

        return head;


    }

    public static void main(String[] args) {
        SingleLinkedListImpl singleLinkedList=new SingleLinkedListImpl();
        Node head= singleLinkedList.arrayToLinkedList(new int[]{1,2,3,4});
        head=removeNthFromEndBrute(head,4);
        singleLinkedList.printLinkedList(head);
        head=removeNthFromEndOptimal(head,2);
        singleLinkedList.printLinkedList(head);
    }
}
