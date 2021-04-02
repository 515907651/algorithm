import Arrays.Calculate_227_medium;
import Arrays.Partition_131_medium;
import Arrays.SpiralOrder_54_medium;
import DataStructure.Calculate_224_hard;
import offer.*;
import sort.MergeSort;

public class PSVM {
    public static void main(String[] args) {
        SearchRange_53_1_medium temp = new SearchRange_53_1_medium();
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] result = temp.searchRangeBi(nums, 8);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
