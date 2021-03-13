package DP;

public class Stock {
    public static void main(String[] args) {
        //这是哪门子动态规划？？？
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices){
        if(prices==null||prices.length<=1) return 0;
        int minPrice = Integer.MAX_VALUE;
        int max = 0;
        int profit = 0;
        for(int i = 0;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }
            else{
                profit = prices[i]-minPrice;
                if(max<profit) max = profit;
            }
        }
        return max;
    }
}
