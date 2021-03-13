package DP;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Change {
    public static void main(String args[]){
        int[] coins = {1,2,5};
        int amount = 11;
        ArrayList mem = new ArrayList();
        for(int i=0;i<=amount;i++){
            mem.add(0);
        }
        //System.out.println((int)mem.get(5));
        //System.out.println(change(coins,11));
        //System.out.println(change1(coins,11,mem));
        System.out.println(change2(coins,amount));
        /*
        for(int i=0;i<12;i++){
            System.out.println(mem.get(i));
        }


         */
    }
    static int change(int[] coins, int amount){
        //原始dp
        if(amount==0) return 0;
        if(amount<0) return -1;
        int res=Integer.MAX_VALUE;
        for (int coin:coins
             ) {
            int sub= change(coins,amount-coin);
            if(sub<0) continue;
            res = res>sub+1?sub+1:res;
        }
        return res;
    }
    static int change1(int[] coins, int amount, ArrayList mem){
        //带备忘录的DP

        if(amount==0) return 0;
        if(amount<0) return -1;
        if((int)mem.get(amount)!=0) return (int)mem.get(amount);
        int res = Integer.MAX_VALUE;
        for (int coin:coins
             ) {
            int sub = change1(coins,amount-coin,mem);
            if(sub<0) continue;
            res = res>sub+1?sub+1:res;

        }
        if(res!=Integer.MAX_VALUE){
            mem.add(amount,res);
        }
        else mem.add(amount,0);
        return (int)mem.get(amount);
    }
    static int change2(int[] coins,int amount){
        int[] dp=new int[amount+1];
        Arrays.fill(dp,11);
        dp[0]=0;

        for(int i=0;i<=amount;i++){
            for (int coin:coins
                 ) {
                if(i-coin<0) continue;
                dp[i]=dp[i]>dp[i-coin]?dp[i-coin]+1:dp[i];
            }
        }
        return dp[amount];
    }
}
