package linkedlist.doublell;

import java.util.ArrayList;
import java.util.HashMap;


public class PairsWithGivenSum {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSumBrute(int target, DoublyNode head) {

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        DoublyNode curr1=head;
        while(curr1!=null){
            DoublyNode curr2=curr1.next;
            while(curr2!=null){
                if(curr1.data+curr2.data==target){
                    ArrayList<Integer> l= new ArrayList<>();
                    l.add(curr1.data);
                    l.add(curr2.data);
                    res.add(l);

                }
                curr2=curr2.next;
            }
            curr1=curr1.next;
        }
        return res;
    }
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, DoublyNode head) {

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        DoublyNode curr1=head;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(curr1!=null){
            if(map.containsKey(target-curr1.data))
            {
                ArrayList<Integer> l= new ArrayList<>();

                l.add(target-curr1.data);
                l.add(curr1.data);
                res.add(l);
            }

            map.put(curr1.data,1);
            curr1=curr1.next;
        }

        return res;
    }
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSumOptimal(int target, DoublyNode head) {

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        DoublyNode right=head;
        while(right.next!=null)
            right=right.next;
        int sum=0;

        DoublyNode left=head;
        while(left.data<right.data){

                sum=left.data+right.data;
            if(sum==target){
                ArrayList<Integer> l= new ArrayList<>();

                l.add(left.data);
                l.add(right.data);
                res.add(l);

                left=left.next;
                right=right.prev;
            }
            else  if(sum<target)
                left=left.next;

            else
                right=right.prev;


        }


        return res;
    }
    public static void main(String[] args) {
        DoubleLinkedListImpl doubleLinkedList = new DoubleLinkedListImpl();
        DoublyNode head= doubleLinkedList.arrayToLinkedList(new int[]{1,2,3,4,5,6,8,9});
        System.out.println(findPairsWithGivenSumBrute(7,head));
        System.out.println(findPairsWithGivenSum(6,head));
        System.out.println(findPairsWithGivenSumOptimal(8,head));


    }
}
