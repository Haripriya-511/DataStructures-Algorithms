package stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElementsOptimal(int[] arr) {

        int n = arr.length; // size of array

        Stack<Integer> st=new Stack<>();
        int[] ans = new int[n];


        for(int i = 2*n-1;i>=0; i--) {
            int ind= i%n;
            int ele=arr[ind];
            while(!st.isEmpty() && ele>= st.peek() )
                st.pop();
            if(i<n){
                if(st.isEmpty())
                    ans[i]=-1;
                else
                    ans[i]=st.peek();
            }
            st.push(ele);

        }

        // Return the answer
        return ans;
    }
    public int[] nextGreaterElementsBrute(int[] arr) {

        int n = arr.length; // size of array

        // To store the next greater elements
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for(int i = 0; i < n; i++) {

            // Get the current element
            int currEle = arr[i];

            /* Nested loop to get the
            next greater element */
            for(int j = 1; j < n; j++) {

                // Getting the hypothetical index
                int ind = (j + i) % n;

                // If the next greater element is found
                if(arr[ind] > currEle) {

                    // Store the next greater element
                    ans[i] = arr[ind];

                    // Break from the loop
                    break;
                }
            }
        }

        // Return the answer
        return ans;
    }

}
