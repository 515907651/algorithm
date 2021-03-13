package Arrays;

public class FindLengthOfLCIS_674_easy {
    public static void main(String[] args) {
//1357
    }
    private static int findLengthOfLCIS(int[] nums)
    {
        if (nums==null||nums.length==0) return 0;
        int n = 1;
        int temp = 1;
        for (int i = 0; i < nums.length-1; i++)
        {
            if (nums[i]<nums[i+1])
            {
                temp++;
            }else
                {
                    if (temp>n)
                    {
                        n=temp;
                    }
                temp = 1;

            }
        }
        if (temp>n) return temp;
        return n;
    }
}
