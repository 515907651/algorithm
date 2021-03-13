package DP;

public class Package01 {
    static int[] value = new int[]{0,2,4,3,7};
    static int[] volume = new int[]{0,2,3,5,5};
    static int[][] results = new int[5][11];
    static int[] fun = new int[11];
    public static void main(String[] args) {
        int v = 10;
        int n = 4;
        //System.out.println(ks1(10,4));
/*
        for (int i = 0; i < 5; i++) {
            results[i][0] = 0;
        }
        for (int i = 0; i < 11; i++) {
            results[0][i] = 0;
        }
        for(int i = 1; i < 5; i++){
            for(int j = v; j>=volume[i]; j--){
                results[i][j] = Math.max(results[i-1][j],results[i-1][j-volume[i]]+value[i]);
            }
        }
        System.out.println(results[4][10]);
*/
        fun[0] = 0;
        for(int i = 1; i < 5; i++){
            for (int j = 1; j < 11; j++){
                if(j<volume[i]) fun[j] = fun[j-1];
                else {
                    fun[j] = Math.max(fun[j],fun[j-volume[i]]+volume[i]);
                    //System.out.println(fun[j]);

                }
            }
        }
        System.out.println(fun[10]);
    }
    public static int ks(int v, int i){
        if(v==0||i==0){
            return 0;
        }else if(v<volume[i]){
            return ks(v,i-1);
        }else {
            return Math.max(ks(v,i-1),ks(v-volume[i],i-1)+value[i]);
        }
    }
    public static int ks1(int v, int i){
        if(results[i][v] != 0) return results[i][v];
        if(v==0||i==0){
            return 0;
        }else if(v<volume[i]){
            return ks1(v,i-1);
        }else {
            results[i][v] = Math.max(ks(v,i-1),ks(v-volume[i],i-1)+value[i]);
            return results[i][v];
        }
    }
}
