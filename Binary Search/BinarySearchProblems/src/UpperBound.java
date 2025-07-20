public class UpperBound {
    public static int upperBound(int []nums,int x){
        int n=nums.length;
        int low=0;
        int high=n-1;
        int res=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]<=x)
            {
                low=mid+1;
            }
            else {
                res=mid;
                high=mid-1;
            }
        }
        return res;
    }
    public static int upperBoundBrute(int[] nums,int target){
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>target)
                return i;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        int x = 2;

        System.out.println(upperBound(nums,x));
        System.out.println(upperBoundBrute(nums,x));

    }
}
