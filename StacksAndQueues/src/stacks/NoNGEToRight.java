package stacks;

import java.util.Arrays;
import java.util.Stack;

public class NoNGEToRight {

    public static int[] numberOfNextGreaterToRight(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];


            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }

            ans[i] = stack.size();

            stack.push(curr);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3 ,4 ,2 ,7 ,5 ,8 ,10 ,6};
        int[] result = numberOfNextGreaterToRight(arr);

        System.out.println(Arrays.toString(result));
        // Output: [2, 1, 1, 0]
    }
}


