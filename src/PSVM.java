import Arrays.Calculate_227_medium;
import Arrays.Partition_131_medium;
import Arrays.SpiralOrder_54_medium;
import DataStructure.Calculate_224_hard;
import offer.*;
import sort.MergeSort;

public class PSVM {
    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] a = {1,2,4};
        int[] b = {1,3,5};
        int[] c = sort.mergeArray(a,b);
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }
}
