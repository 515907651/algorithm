package DP;

public class Knapsack {
    private static int[] profit = {0,5,8};
    private static int[] volume = new int[]{0,5,7};//这么写好蠢
    private static int t = 10;
    private static Integer[][] results = new Integer[profit.length][t];
    public static void main(String[] args) {
        //System.out.println(knapsack(2,10));

    }
    private static int knapsack(int i, int v){
        int result = 0;
        if(i==0||v==0){
            result = 0;
        }
        else if(v<volume[i]){
            result = knapsack(i-1, v);
        }else {
            for(int k = 0; k*volume[i]<=t;k++){
                int temp = knapsack(i-1, v-k*volume[i]) + k*profit[i];
                if(temp>result) result = temp;
            }
        }
        return result;
    }
    private static int knapsack1(int i, int v){
        int result = 0;
        if(results[i][v]!=null) return results[i][v];
        if(i==0||v==0){
            result = 0;
        }else if (v<volume[i]);
        return 1;
    }
}
