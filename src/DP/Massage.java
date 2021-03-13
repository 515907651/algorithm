package DP;

public class Massage {
    public static void main(String args[]){
        int[] ap= {1,2,3,1};
        //System.out.println(dp1(ap,0));
        System.out.println(dp2(ap));
    }
    static int dp(int[] ap,int pos){
        //暴力DP
        if(pos==ap.length-1) return ap[ap.length-1];
        if(pos>ap.length-1) return 0;
        int time = 0;
        int temp = 0;
        for(int i = pos;i<ap.length;i++){
            time+=ap[i];
            //System.out.println(time);
            time+=dp(ap,i+2);
            if(time>temp) temp=time;
            time = 0;
        }
        return temp;
    }
    static int dp1(int[] ap,int pos){

        if(pos==ap.length-1) return ap[ap.length-1];
        if(pos>ap.length-1) return 0;
        int time = 0;
        int temp = 0;
        int n = 0;
        int[] mem = new int[ap.length];
        if(mem[pos]!=0) return mem[pos];
        for(int i = pos;i<ap.length;i++){
            time+=ap[i];
            System.out.println(n++);
            //System.out.println(time);
            time+=dp(ap,i+2);
            mem[pos] = time;
            //System.out.println("1");
            //System.out.println(mem[pos]);
            if(time>temp) temp=time;
            time = 0;
        }
        return temp;
    }
    static int dp2(int[] ap){
        if(ap.length<=0) return 0;
        if(ap.length==1) return ap[0];
        int[] temp = new int[ap.length];
        temp[0] = ap[0];
        temp[1] = ap[0]>ap[1]?ap[0]: ap[1];
        for(int i = 2;i<ap.length;i++){
            temp[i] = temp[i-1]>temp[i-2]+ap[i]?temp[i-1]:temp[i-2]+ap[i];
        }
        return temp[temp.length-1];
    }
}
