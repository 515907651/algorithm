package topinterview;

import java.util.LinkedList;
import java.util.List;

public class _118_generate_easy {
    // 杨辉三角
    // 性质是，每行的第一个和最后一个是1，其他位置是上一行的i-1和i位置之和
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    // 第一个和最后一个为1
                    cur.add(1);
                } else {
                    // 取上一行的i-1和i
                    cur.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1));
                }
            }
            ans.add(cur);
        }
        return ans;
    }

}
