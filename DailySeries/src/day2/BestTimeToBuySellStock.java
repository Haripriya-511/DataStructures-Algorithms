package day2;

public class BestTimeToBuySellStock {
    public static int maxProfit(int[] prices) {
        int n=prices.length;
        int maxLeft[]=new int[n];
        maxLeft[n-1]=0;
        int maxi=prices[n-1];
        for(int i=n-2;i>=0;i--){
            maxi=Math.max(prices[i+1],maxi);
            maxLeft[i]=maxi;
        }
        int maxProfit=0;
        for(int i=0;i<n;i++){
            maxProfit=Math.max(maxProfit,maxLeft[i]-prices[i]);
        }

        return maxProfit;

}
    public static int maxProfitOptimalBackward(int[] prices) {
        int n=prices.length;
        int maxProfit=0;
        int maxLeft=prices[n-1];
        for(int i=n-2;i>=0;i--){
            maxLeft=Math.max(prices[i+1],maxLeft);
            maxProfit=Math.max(maxProfit,maxLeft-prices[i]);
        }
        return maxProfit;
    }
    public static int maxProfitOptimalForward(int[] prices) {
        int n=prices.length;
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i=1;i<n;i++){
    maxProfit=Math.max(maxProfit,prices[i]-minPrice);
    minPrice=Math.min(minPrice,prices[i]);

}
        return maxProfit;
    }
    public static void main(String[] args) {
        int []prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitOptimalBackward(prices));
        System.out.println(maxProfitOptimalForward(prices));

    }
}
