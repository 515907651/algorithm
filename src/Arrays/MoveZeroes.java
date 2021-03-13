package Arrays;

public class MoveZeroes {
    //283
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    private static void moveZeroes(int[] nums){
        int i = 0;
        for (; i < nums.length; i++) {
            int j = i;
            while(nums[j]==0){
                j++;
                if(j>= nums.length) break;
            }
            if(j>=nums.length) break;
            if(i!=j){
                nums[i] = nums[j];
                nums[j] = 0;

            }
        }
    }
}
