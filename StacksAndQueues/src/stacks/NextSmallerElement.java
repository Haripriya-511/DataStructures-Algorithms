package stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    public static int[] nextSmallerToRight(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];

            // Pop elements greater or equal to curr
            while (!stack.isEmpty() && stack.peek() >= curr) {
                stack.pop();
            }

            // If stack is empty, no smaller element to the right
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }

            // Push current element for next iterations
            stack.push(curr);
        }

        return ans;
    }
    public static int[] nextSmallerToLeft(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i =0;i<n; i++) {
            int curr = arr[i];

            // Pop elements greater or equal to curr
            while (!stack.isEmpty() && stack.peek() >= curr) {
                stack.pop();
            }

            // If stack is empty, no smaller element to the right
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }

            // Push current element for next iterations
            stack.push(curr);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        int[] result = nextSmallerToRight(arr);

        System.out.println(Arrays.toString(result));
        int []res=nextSmallerToLeft(arr);
        System.out.println(Arrays.toString(res));
        // Output: [2, 5, 2, -1, -1]
    }
}
