import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,2,6,3,1};
        int[] nums1 = new int[]{3,2,1};
        int[] nums2 = new int[]{1,2};

        Solution solution = new Solution();
        solution.nextPermutation(nums);
        solution.nextPermutation(nums2);

        for (int i = 0; i < nums2.length; i++) {
            System.out.println(nums2[i]);
        }
    }
    static class Solution{
        public void nextPermutation(int[] nums){
            int r = nums.length-1;
            int l = 0;
            for(; r > 0; r--){
                for(l = r-1; l >= 0; l--){
                    if(nums[r]>nums[l]){
                        break;
                    }
                }
                if(l>=0) break;
            }
            System.out.println(l);
            System.out.println(r);
            if(r==-1||l==-1) Arrays.sort(nums);
            else {
                int temp = 0;
                temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                Arrays.sort(nums,l+1,nums.length);

            }
        }
    }
}
