package DP;

public class Palindrome {
    public static void main(String[] args) {
        String s="aaa";
        System.out.println(PD1(s));
        System.out.println(countSubstrings(s));
    }
    static String PD1(String s){
        String ans="";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int l=0;l<s.length();l++){
            for(int i=0;i+l<s.length();i++){
                int j=i+l;
                if(l==0) dp[i][j]=true;
                if(l==1) dp[i][j]=(s.charAt(i)==s.charAt(j));
                if(l>=2) dp[i][j]=(dp[i+1][j-1]&&s.charAt(i)==s.charAt(j));
                if(dp[i][j]&&l>ans.length()) ans=s.substring(i,j+1);
            }
        }
        return ans;
    }
    static int countSubstrings(String s){
        int num = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int length = 0; length < s.length(); length++){
            for(int i = 0; i+length<s.length(); i++){
                //i从0开始还是从1开始,i+l可以等于s.length么
                int j = i+length;
                if(length==0) {
                    num++;
                    dp[i][j] = true;
                }
                if(length==1&&s.charAt(i)==s.charAt(j)){
                    num++;
                    dp[i][j]=true;
                }
                if(length>=2&&s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]){
                    num++;
                    dp[i][j] =true;
                }

            }
        }
        return num;
    }
}
