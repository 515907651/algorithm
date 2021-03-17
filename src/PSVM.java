import Arrays.Calculate_227_medium;
import Arrays.Partition_131_medium;
import Arrays.SpiralOrder_54_medium;
import DataStructure.Calculate_224_hard;
import offer.Permutation_38_medium;
import offer.ReverseList_24_easy;

public class PSVM {
    public static void main(String[] args) {
        Permutation_38_medium test = new Permutation_38_medium();
        String s = "aab";
        String[] s1 = test.permutation(s);
        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i]);
        }
    }
}
