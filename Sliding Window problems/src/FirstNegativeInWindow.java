import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
Given an array arr[]  and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.

Note: If a window does not contain a negative integer, then return 0 for that window.

Examples:

Input: arr[] = [-8, 2, 3, -6, 10] , k = 2
Output: [-8, 0, -6, -6]
Explanation:
Window [-8, 2] First negative integer is -8.
Window [2, 3] No negative integers, output is 0.
Window [3, -6] First negative integer is -6.
Window [-6, 10] First negative integer is -6.
 */
public class FirstNegativeInWindow {
    public static void main(String[] args) {
        int arr[] = {-8, 2, 3, -6, 10};
        int k = 2;
        System.out.println("Brute Force:" + firstNegIntBrute(arr, k));

        System.out.println("Optimal :" + firstNegIntOptimal(arr, k));
    }

    public static List<Integer> firstNegIntBrute(int arr[], int k) {
        List<Integer> l = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i <= (n - k); i++) {
            boolean found = false;
            for (int j = i; j < i + k; j++) {
                if (arr[j] < 0) {
                    found = true;
                    l.add(arr[j]);
                    break;
                }
            }
            if (!found)
                l.add(0);

        }
        return l;
    }

    public static List<Integer> firstNegIntOptimal(int arr[], int k) {

        Deque<Integer> dq = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int l = 0, r = 0;
        int n = arr.length;
        while (r < n) {
            if (arr[r] < 0)
                dq.addLast(arr[r]);

            if ((r - l + 1) == k) {
                if (dq.size() == 0)
                    res.add(0);

                else
                    res.add(dq.peekFirst());

                if (arr[l] < 0)
                    dq.pollFirst();
                l++;
            }
            r++;
        }

        return res;

    }

}
