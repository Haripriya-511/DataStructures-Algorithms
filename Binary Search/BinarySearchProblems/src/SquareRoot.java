public class SquareRoot {
    public long floorSqrt(long n) {
        //  if(n==1 || n==0) return n;
        long low=1;
        long high= n;
        while(low<=high){
            long mid= low+(high-low)/2;
            if(mid*mid==n)
                return mid;
            else if(mid*mid<n)
                low=mid+1;
            else
                high=mid-1;
        }
        return high;

    }
    public long floorSqrtLinear(long n) {
        long ans = 0;

        // Linear search in the answer space
        for (long i = 1; i <= n; i++) {
            long val = i * i;

            // Check if val is less than or equal to n
            if (val <= (long) n) {
                // Update ans to current value of i
                ans = (int) i;
            } else {
                break;
            }
        }
        return ans;
    }
}
