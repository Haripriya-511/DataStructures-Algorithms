public class CountSubArrayFixedbound {
    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 2, 7, 5};
        int minK = 1;
        int maxK = 5;
        System.out.println(countSubarraysBrute(nums, minK, maxK));
    }

    public static long countSubarraysBrute(int[] nums, int minK, int maxK) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int maxi = Integer.MIN_VALUE;
            int mini = Integer.MAX_VALUE;
            int miniFound = 0;
            int maxiFound = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] < mini) {
                    mini = nums[j];
                    miniFound = (mini == minK ? 1 : 0);

                }
                if (nums[j] > maxi) {
                    maxi = nums[j];
                    maxiFound = (maxi == maxK) ? 1 : 0;
                }
                if (miniFound == 1 && maxiFound == 1) {
                    count++;
                }


            }
        }
        return count;
    }
}
