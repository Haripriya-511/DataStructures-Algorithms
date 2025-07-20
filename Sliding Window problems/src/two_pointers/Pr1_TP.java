package two_pointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pr1_TP {
    public static void main(String[] args) {
        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
        int[] nums2[] = {{1, 4}, {3, 2}, {4, 1}};
        int[][] res = mergeArrays1(nums1, nums2);
        for (int i[] : res) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

    //My approach
    public static int[][] mergeArrays1(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i][0];
            int value = nums1[i][1];
            int existingValue = map.getOrDefault(key, 0);
            map.put(key, existingValue + value);
        }
        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i][0];
            int value = nums2[i][1];
            int existingValue = map.getOrDefault(key, 0);
            map.put(key, existingValue + value);
        }
        int n = map.size();
        int res[][] = new int[n][2];
        int ind = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (nums1[i][0] <= nums2[j][0]) {
                int value = map.get(nums1[i][0]);
                res[ind][0] = nums1[i][0];
                res[ind][1] = value;
                if (nums1[i][0] == nums2[j][0]) {
                    i++;
                    j++;
                } else {
                    i++;
                }

            } else if (nums1[i][0] > nums2[j][0]) {
                int value = map.get(nums2[j][0]);
                res[ind][0] = nums2[j][0];
                res[ind][1] = value;
                j++;
            }
            ind++;
        }
        while (i < n1) {
            int value = map.get(nums1[i][0]);
            res[ind][0] = nums1[i][0];
            res[ind][1] = value;
            i++;
            ind++;
        }
        while (j < n2) {
            int value = map.get(nums2[j][0]);
            res[ind][0] = nums2[j][0];
            res[ind][1] = value;
            j++;
            ind++;
        }
        return res;
    }

    //efficient one without any hashtable
    public int[][] mergeArrays2(int[][] nums1, int[][] nums2) {
        List<int[]> res = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            int id1 = nums1[i][0], val1 = nums1[i][1];
            int id2 = nums2[j][0], val2 = nums2[j][1];

            if (id1 < id2) {
                res.add(new int[]{id1, val1});
                i++;
            } else if (id2 < id1) {
                res.add(new int[]{id2, val2});
                j++;
            } else {
                res.add(new int[]{id1, val1 + val2});
                i++;
                j++;
            }

        }
        while (i < n1) {
            res.add(nums1[i]);
            i++;
        }
        while (j < n2) {
            res.add(nums2[j]);
            j++;
        }
        int[][] finalRes = new int[res.size()][2];
        for (int k = 0; k < res.size(); k++) {
            finalRes[k] = res.get(k);
        }
        return finalRes;
    }


}


