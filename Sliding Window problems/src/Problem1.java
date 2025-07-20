public class Problem1 {

    public static void main(String[] args) {
        System.out.println(new Problem1().maximumSumSubarrayBrute(new int[]{2, 1, 5, 1, 3, 2}, 3)); // Output: 9
        System.out.println(new Problem1().maximumSumSubarrayOptimal(new int[]{2, 3}, 3)); // Edge case: k > arr.length
        System.out.println(new Problem1().maximumSumSubarrayOptimalCleansedCode(new int[]{1, 1, 1, 1}, 2)); // Output: 2
    }

    public int maximumSumSubarrayBrute(int[] arr, int k) {
        int n = arr.length;
        int max_sum = 0;
        for (int i = 0; i <= (n - k); i++) {
            int sum = 0;
            for (int j = i; j < (i + k); j++) {
                sum += arr[j];
                max_sum = Math.max(max_sum, sum);
            }
        }
        return max_sum;
    }

    public int maximumSumSubarrayOptimal(int[] arr, int k) {
        int n = arr.length;
        int max_sum = 0;
        int sum = 0;
        int i = 0, j = 0;
        while (j < n) {
            sum += arr[j];
            if (j - i + 1 > k) {
                sum -= arr[i];
                i++;
            }
            if (j - i + 1 == k) {
                max_sum = Math.max(sum, max_sum);
            }
            j++;

        }
        return max_sum;

    }

    //(Code Cleanliness):
    public int maximumSumSubarrayOptimalCleansedCode(int[] arr, int k) {
        int n = arr.length;
        int max_sum = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        max_sum = sum;
        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            max_sum = Math.max(max_sum, sum);
        }
        return max_sum;

    }

}
