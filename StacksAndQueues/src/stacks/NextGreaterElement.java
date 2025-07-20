package stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextLargerElementBrute(int[] arr) {
        int n=arr.length;
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            int currEle=arr[i];
            boolean found=false;
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    res[i]=arr[j];
                    found=true;
                    break;
                }
            }
            if(!found)
                res[i]=-1;
        }
        return res;
    }
    public static int[] nextLargerElementRight(int[] arr) {
        Stack<Integer> st=new Stack<>();
        int res[]=new int[arr.length];

        for(int i=arr.length-1;i>=0;i--){
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return res;
    }
    public static int[] nextLargerElementLeft(int[] arr) {
        Stack<Integer> st=new Stack<>();
        int res[]=new int[arr.length];

        for(int i=0;i<arr.length;i++){
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        int[] result = nextLargerElementRight(arr);
        int[] res2=nextLargerElementLeft(arr);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(res2));


    }
}
