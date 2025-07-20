package two_pointers;

public class Pr2_TP {
    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int ind = 0;
        int temp[] = new int[n + m];
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[ind] = nums1[i];
                ind++;
                i++;
            } else {
                temp[ind] = nums2[j];
                ind++;
                j++;
            }
        }
        while (i < m) {
            temp[ind++] = nums1[i++];
        }
        while (j < n) {
            temp[ind++] = nums2[j++];

        }
        for (int k = 0; k < ind; k++) {
            nums1[k] = temp[k];
        }
    }

    public void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
    
}
