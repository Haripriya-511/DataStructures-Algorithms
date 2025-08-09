package aug8;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int res[]=new int[n-k+1];
        int ind=0;
        for(int i=0;i<=(n-k);i++){
            int max=Integer.MIN_VALUE;
            for(int j=i;j<(i+k);j++){
                max=Math.max(max,nums[j]);
            }
            res[i]=max;
        }
        return res;
    }

    public int[] maxSlidingWindowOptimal(int[] nums, int k) {
        int n=nums.length;
        int res[]=new int[n-k+1];
        
        return res;
    }
    public static void main(String[] args) {

    }
}
