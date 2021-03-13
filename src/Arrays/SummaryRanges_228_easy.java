package Arrays;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges_228_easy {
    public static void main(String[] args) {

    }
    private static List<String> summaryRanges(int[] nums){
        List<String> list = new LinkedList<String>();
        int i = 0;
        while(i<nums.length){
            int left = i;
            while (i+1<nums.length&&nums[i]+1==nums[i+1]){
                i++;
            }
            StringBuffer temp = new StringBuffer(Integer.toString(nums[left]));
            if (left<i){
                temp.append("->");
                temp.append(Integer.toString(nums[i]));
            }
            list.add(temp.toString());
            i++;
        }
        return list;
    }
}
