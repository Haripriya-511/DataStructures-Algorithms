package two_pointers;

import java.util.ArrayList;
import java.util.List;

public class Pr5_TP {
    public static void main(String[] args) {

    }

    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) pos.add(num);
            else neg.add(num);
        }

        int[] result = new int[nums.length];
        int i = 0, p = 0, n = 0;
        while (i < nums.length) {
            result[i++] = pos.get(p++);
            result[i++] = neg.get(n++);
        }

        return result;
    }

    public int[] rearrangeArray1(int[] nums) {
        int[] result = new int[nums.length];
        int posIndex = 0, negIndex = 1;

        for (int num : nums) {
            if (num > 0) {
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }
        return result;
    }
}
