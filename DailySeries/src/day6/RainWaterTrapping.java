package day6;

public class RainWaterTrapping {
    public int trapI(int[] height) {

        int n=height.length;
        int water=0;
        for(int i=0;i<height.length;i++){
            int maxLeft=0;
            int maxRight=0;
            for(int j=0;j<(i);j++){
                maxLeft=Math.max(maxLeft,height[j]);
            }
            for(int j=i+1;j<n;j++){
                maxRight=Math.max(maxRight,height[j]);
            }
            int trapppedWater=Math.min(maxLeft,maxRight)-height[i];
            if(trapppedWater>0)
                water+=trapppedWater;

        }
        return water;

    }
    public int trapII(int[] height) {

        int n=height.length;
        int water=0;
        int maxLeft[]=new int[n];
        int maxRight[]=new int[n];
        maxLeft[0]=0;

        for(int i=1;i<n;i++){
            maxLeft[i]=Math.max(maxLeft[i-1],height[i-1]);
        }
        maxRight[n-1]=0;
        for(int i=n-2;i>=0;i--){
            maxRight[i]=Math.max(maxRight[i+1],height[i+1]);
        }
        for(int i=1;i<n-1;i++){
            int trapped= Math.min(maxLeft[i], maxRight[i])-height[i];
            if(trapped>0)
                water+=trapped;
        }
        return water;

    }
    public int trapoptimal(int[] height) {

        int n=height.length;
        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0, r = n - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        while(l<r){
            if(leftMax<rightMax){
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            }
            else
            {
                r--;
                rightMax=Math.max(rightMax,height[r]);
                res+= rightMax-height[r];

            }
        }
        return res;

    }
    public static void main(String[] args) {

    }
}
