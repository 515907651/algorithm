package Arrays;

public class GasStation {
    //134
    public static void main(String[] args) {
        int[] gas = new int[]{2,3,4};
        int[] cost = new int[]{3,4,3};
        System.out.println(canCompleteCircuit(gas,cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int[] surplus = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            surplus[i] = gas[i] - cost[i];
            //surplus是每站的加油数减去耗油数
        }
        for (int i = 0; i < gas.length; i++) {
            int k = 0;
            //k记录开了多少站
            if(surplus[i]>=0){
                //当大于0，代表这一站可以作为起始站
                sum+=surplus[i];
                for(int j = 1; j < gas.length; j++){
                    int n = 0;
                    if(j+i>=gas.length) {
                        n = j+i-gas.length;
                    }
                    else {
                        n = j+i;
                    }
                    sum+=surplus[n];
                    if(sum>=0) {
                        k++;
                        continue;
                    }
                    else {
                        sum = 0;
                        break;
                    }

                }
                //System.out.println(k);
                if(k==gas.length-1) return i;
            }
        }
        return -1;
    }

}
