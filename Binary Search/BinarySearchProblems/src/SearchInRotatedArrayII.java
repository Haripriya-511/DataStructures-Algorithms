import java.util.ArrayList;

public class SearchInRotatedArrayII {
    public boolean searchInARotatedSortedArrayII(ArrayList<Integer> nums, int k) {
        int n=nums.size();
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(nums.get(mid)==k)
                return true;

            if (nums.get(low).equals(nums.get(mid)) && nums.get(mid).equals(nums.get(high))) {
                low = low + 1;
                high = high - 1;
                continue;
            }


            if(nums.get(mid)>=nums.get(low)){
                if(nums.get(low)<=k && k<=nums.get(mid)){
                    high=mid-1;
                }
                else low=mid+1;
            }
            else{
                if(nums.get(mid)<=nums.get(high)){
                    if(nums.get(mid)<=k && k<=nums.get(high)){
                        low=mid+1;
                    }
                    else{
                        high=mid-1;
                    }
                }
            }

        }
        return false;
    }
}
