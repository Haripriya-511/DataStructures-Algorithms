package linkedlist.speciall;


import java.util.HashMap;

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2 random;

    ListNode2() {
        val = 0;
        next = null;
        random = null;
    }

    ListNode2(int val) {
        this.val = val;
        next = null;
        random = null;
    }

    ListNode2(int val, ListNode2 next, ListNode2 random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
public class CloneLL {
    public static ListNode2 copyRandomListBrute(ListNode2 head) {
        if(head==null)
            return  null;
        HashMap<ListNode2, ListNode2> map=new HashMap<>();


        ListNode2 curr=head;

        while(curr!=null)
        {
            ListNode2 newNode=new ListNode2(curr.val);
            map.put(curr,newNode);
            curr=curr.next;
        }


        curr=head;
        while(curr!=null){

            ListNode2 copyNode=map.get(curr);
            copyNode.next=map.get(curr.next);
            copyNode.random=map.get(curr.random);
            curr=curr.next;



        }
        return map.get(head);


    }
    public   void insertCopyInBetween(ListNode2 head) {
        ListNode2 temp=head;
        while(temp!=null){
            ListNode2 nextEle=temp.next;
            ListNode2 copy=new ListNode2(temp.val);
            copy.next=nextEle;
            temp.next=copy;

            temp=nextEle;
        }
    }
    public void connectRandomPointers(ListNode2 head){
        ListNode2 temp=head;
        while(temp!=null){
            ListNode2 copy=temp.next;
            if(temp.random!=null){
                copy.random=temp.random.next;
            }
            else{
                copy.random=null;
            }
            temp=temp.next.next;
        }
    }
    public ListNode2 getDeepCopyList(ListNode2 head){
        ListNode2 temp=head;
        ListNode2 dummy=new ListNode2(-1);
        ListNode2 res=dummy;
        while(temp!=null){
            res.next=temp.next;
            res=res.next;

            temp.next=temp.next.next;
            temp=temp.next;
        }
        return dummy.next;
    }
    public ListNode2 copyRandomListOptimal(ListNode2 head) {
        if(head==null)
            return null;

        insertCopyInBetween(head);
        connectRandomPointers(head);

        return getDeepCopyList(head);




    }

    public static void main(String[] args) {

    }
}
