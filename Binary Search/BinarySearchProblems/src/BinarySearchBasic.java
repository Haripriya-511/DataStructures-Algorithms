public class BinarySearchBasic {
    public static int binarySearch(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
    public static int binarySerachRecursive(int[] nums,int low,int high,int target){
        if(low>high)
            return -1;
        int mid=low+(high-low)/2;
        if(nums[mid]==target)
            return mid;
        else if(nums[mid]>target)
            return binarySerachRecursive(nums,low,mid-1,target);
        else
            return binarySerachRecursive(nums,mid+1,high,target);
    }

    public static void main(String[] args) {
        int arr[]={-1,0,3,5,9,12};
        int target=9;
        System.out.println(binarySearch(arr,target));
        System.out.println(binarySerachRecursive(arr,0,arr.length-1,target));
    }
}
