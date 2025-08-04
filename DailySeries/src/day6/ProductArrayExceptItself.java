package day6;

public class ProductArrayExceptItself {
    public int[] productExceptSelf1(int[] nums) {

        int n=nums.length;
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            int product=1;
            for(int j=0;j<n;j++){
                if(j!=i)
                    product*=nums[j];
            }
            res[i]=product;
        }
        return res;
    }
    public int[] productExceptSelf2(int[] nums) {

        int n=nums.length;
        int res[]=new int[n];
        int product=1;
        int zeroesCount=0;
        for(int i:nums){
            if(i==0) zeroesCount++;
            else
                product*=i;
        }
        if(zeroesCount>1)
            return new int[nums.length];
        for(int i=0;i<n;i++){
            if(zeroesCount==1){
                if(nums[i]==0)
                    res[i]=product;
                else
                    res[i]=0;
            }
            else{
                res[i]=product/nums[i];
            }
        }
        return res;
    }
    public int[] productExceptSelf3(int[] nums) {
        int n=nums.length;
        int res[]=new int[n];
        int prefix[]=new int[n];
        int suffix[]=new int[n];
        prefix[0]=1;
        suffix[n-1]=1;
        for(int i=1;i<n;i++)
            prefix[i]=nums[i-1]*prefix[i-1];
        for (int i=n-2;i>=0;i--)
            suffix[i]=nums[i+1]*suffix[i+1];
        for(int i=0;i<n;i++){
            res[i]=prefix[i]*suffix[i];
        }
        return res;

    }
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
