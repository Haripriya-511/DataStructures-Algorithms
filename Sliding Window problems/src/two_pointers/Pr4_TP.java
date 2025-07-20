package two_pointers;

public class Pr4_TP {
    public static void main(String[] args) {

    }

    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int evenIndex = 0;
        int oddIndex = 1;

        for (int num : nums) {
            if (num % 2 == 0) {
                result[evenIndex] = num;
                evenIndex += 2;
            } else {
                result[oddIndex] = num;
                oddIndex += 2;
            }
        }

        return result;
    }

    public int[] sortArrayByParityIIOptimal(int[] nums) {
        int n = nums.length;

        int i = 0, j = 1;
        while (j < n && i < n) {
            if (nums[i] % 2 == 0)
                i += 2;
            else if (nums[j] % 2 == 1)
                j += 2;
            else {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i += 2;
                j += 2;
            }
        }
        return nums;
    }

}
