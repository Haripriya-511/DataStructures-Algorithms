package linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode(int data1, ListNode next1, ListNode next2) {
        val = data1;
        next = next1;
        child = next2;
    }
}
public class SpecialLL_Flatten {
    public ListNode flattenLinkedListBrute(ListNode head) {

        List<Integer> arr=new ArrayList<>();
        while(head!=null){
            ListNode t1=head;
            while(t1!=null){
                arr.add(t1.val);
                t1=t1.child;
            }
            head=head.next;
        }
        Collections.sort(arr);
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        for(int i=0;i<arr.size();i++){
            temp.child=new ListNode(arr.get(i));
            temp=temp.child;
        }
        return dummy.child;

    }
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(-1);
        ListNode res=dummy;

        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                res.child=list1;
                res=list1;
                list1=list1.child;
            }
            else{
                res.child=list2;
                res=list2;
                list2=list2.child;
            }
            res.next=null;;
        }
        if(list1!=null)
            res.child=list1;
        if(list2!=null)
            res.child=list2;

        return dummy.child;

    }
    public ListNode flattenLinkedListOptimal(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode mergedOne=flattenLinkedListOptimal(head.next);

        head=merge(mergedOne,head);

        return head;



    }

    public static void main(String[] args) {

    }
}
