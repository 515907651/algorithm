import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        //用什么结构去存储这种[1,2]啊，int[][]咋存的
        //用一个int[][2]的数组，可以看成n*2的表格
        //需要结果依然有序
        int[][] intervals = new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = new int[] {4,8};
        int[][] a = insert(intervals,newInterval);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i][0]);
            System.out.print(a[i][1]);
            System.out.println();
        }

    }
    static int[][] insert(int[][] intervals, int[] newInterval){
        int left = newInterval[0];
        int right = newInterval[1];
        boolean flag = false;
        List<int[]> temp = new ArrayList<int[]>();
        for(int i = 0;i< intervals.length;i++){
            //if(intervals[i][0]>right||intervals[i][1]<left) temp.add(intervals[i]);
            if(intervals[i][1]<left) temp.add(intervals[i]);
            else if(intervals[i][0]>right){
                if(!flag){
                    temp.add(new int[]{left,right});
                    flag=true;
                }
                temp.add(intervals[i]);
            }
            else{
                left = intervals[i][0]>left?left:intervals[i][0];
                right = intervals[i][1]>right?intervals[i][1]:right;
            }
        }
        if(!flag) temp.add(new int[]{left,right});
        int[][] ans = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }
}
