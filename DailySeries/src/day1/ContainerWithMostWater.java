package day1;

public class ContainerWithMostWater {
    public static int maxAreaBrute(int[] height) {
        int water = 0;
        int n = height.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                water = Math.max(water, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return water;
    }

    public static int maxAreaOptimal(int[] height) {
        int water = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            water = Math.max(water, Math.min(height[l], height[r]) * (r - l));
            if (height[l] <= height[r])
                l++;
            else
                r--;
        }
        return water;
    }

    public static void main(String[] args) {
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Brute:" + maxAreaBrute(height));
        System.out.println("Optima:" + maxAreaOptimal(height));
    }
}
