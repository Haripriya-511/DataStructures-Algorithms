package day4;

public class TwoSumIfInoutisSorted {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int left=0,right=numbers.length-1;
        while(left<right){
            int sum=numbers[left]+numbers[right];
            if(sum==target)
                return new int[]{left+1,right+1};
            else if(sum<target)
                left++;
            else
                right--;

        }
        return new int[]{-1,-1};
    }
    public int[] twoSumBinarySearch(int[] numbers, int target) {
        int n=numbers.length;
        for(int i=0;i<numbers.length;i++){
            int l=i+1;
            int r=numbers.length-1;
            int tmp=target-numbers[i];
            while(l<=r){
                int mid=(l+r)/2;
                if(numbers[mid]==tmp)
                    return new int[]{i+1,mid+1};
                else if(numbers[mid]<tmp)
                    l=mid+1;
                else
                    r=mid-1;
            }

        }
        return new int[]{-1,-1};
    }
}
