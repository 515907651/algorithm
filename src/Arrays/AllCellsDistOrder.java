package Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class AllCellsDistOrder {
    public static void main(String[] args) {

    }
    public static int[][]allCellsDistOrder(int R, int C, int r0, int c0){
        int[][] a = new int[R*C][];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                a[i*C+j] = new int[]{i,j};
            }
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (Math.abs(o1[0]-r0)+Math.abs(o1[1]-c0)-Math.abs(o2[0]-r0)-Math.abs(o1[1]-c0));
            }
        });
        return a;
    }
}

