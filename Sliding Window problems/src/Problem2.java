import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Problem2 {
    public static void main(String[] args) {
        System.out.println(firstNegIntOptimal(new int[]{12, -1, -7, 8, 15, 30, 16, 28}, 3));
// Output: [-1, -1, -7, 0, 0, 0]

        System.out.println(firstNegIntOptimal(new int[]{1, 2, 3, 4, 5}, 2));
// Output: [0, 0, 0, 0]

        System.out.println(firstNegIntOptimal(new int[]{-5, -3, -2, -1}, 2));
// Output: [-5, -3, -2]
    }

    static List<Integer> firstNegInt(int arr[], int k) {
        int n = arr.length;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i <= (n - k); i++) {
            boolean negFound = false;
            for (int j = i; j < (i + k); j++) {
                if (arr[j] < 0) {
                    l.add(arr[j]);
                    negFound = true;
                    break;
                }
            }
            if (!negFound)
                l.add(0);
        }
        return l;
    }

    static List<Integer> firstNegIntOptimal(int[] arr, int k) {

        if (arr == null || arr.length < k || k <= 0) return new ArrayList<>();

        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        int start = 0, end = 0;

        while (end < n) {
            if (arr[end] < 0)
                dq.addLast(arr[end]);

            if (end - start + 1 == k) {
                result.add(dq.isEmpty() ? 0 : dq.peek());

                if (!dq.isEmpty() && arr[start] == dq.peek())
                    dq.removeFirst();
                start++;
            }
            end++;
        }

        return result;
    }
    

}
