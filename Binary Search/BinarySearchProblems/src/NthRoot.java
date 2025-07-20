public class NthRoot {
    public int NthRootBrute(int N, int M) {

        for(int i=1;i<=M;i++){
            int j=i;
            int res=1;
            for(int k=1;k<=N;k++){
                res*=i;
            }
            if(res==M)
                return j;
            if(res>M)
                break;
        }
        return -1;

    }
    private long Pow(int b, int exp) {
        long ans = 1;
        long base = b;

        // Exponentiation by squaring method
        while (exp > 0) {
            if (exp % 2 == 1) {
                exp--;
                ans *= base;
            } else {
                exp /= 2;
                base *= base;
            }
        }
        return ans;
    }
    public int NthRootBetter(int N, int M) {

        for(int i=1;i<=M;i++){
            int j=i;
            long val=Pow(j,N);

            if(val==M)
                return j;
            if(val>M)
                break;
        }
        return -1;

    }
    private int func(int mid, int n,int m) {
        long  ans=1;
        for(int i=1;i<=n;i++){
            ans=ans*mid;
            if(ans>m)
                return 2;
        }
        if(ans==m)
            return 1;
        return 0;

    }
    //efficient power function
    private int Pow(int mid, int n,int m) {
        long ans = 1;
        long base = mid;

        while (n > 0) {
            if ((n & 1) == 1) {  // if n is odd
                ans *= base;
                if (ans > m) return 2;
                n--;
            }
            else{
                n=n>>1;
                base = base* base;
                if (base > m)
                    return 2;

            }

        }

        if (ans == m) return 1;

        return 0;

    }
    public int NthRootBinarySearch(int N, int M) {

        int low=1;
        int high=M;
        while(low<=high){
            int mid=(low)+(high-low)/2;
            int res=func(mid,N,M);
            if(res==1)
                return mid;
            else if(res==2)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}
