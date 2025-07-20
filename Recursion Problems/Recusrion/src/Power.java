public class Power {
    public double pow(double x,int n){
        if(n==0)
            return 1.0;
        if(n==1)
            return x;
        if(n%2==1)
            return x*pow(x,n-1);
        return pow(x*x,n/2);


    }
    public double myPow(double x, int n) {
        if(n<0){
            x=1/x;
            n=-1*n;
        }
        return pow(x,n);


    }
    public double myPowIterative(double x,int n){
        if(n==0)
            return 1.0;
        if(n==1)
            return x;
        double ans=1;
        long num=n;
        if(n<0){
            x=1/x;
            num= -1*num;

        }
        while(num>0){
            if(num%2==0){
                x= (x*x);
                num=num/2;
            }
            else{
                ans= x*ans;
                num=num-1;
            }
        }
        return ans;
    }
}
