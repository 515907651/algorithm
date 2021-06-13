package topinterview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _22_GenerateParenthesis_Medium {
    /**
     * 生成n对括号的所有合法形式.
     * 注意左右括号数量相等.
     * */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuffer temp = new StringBuffer();
        recur(result, temp, 0, 0, n);
        return result;
    }

    private void recur(List<String> result, StringBuffer temp, int left, int right, int n) {
        if (temp.length() == n * 2) {
            result.add(temp.toString());
            return;
        }
        if (left < n) {
            temp.append('(');
            recur(result, temp, left + 1, right, n);
            temp.deleteCharAt(temp.length() - 1);
        }
        if (right < left) {
            temp.append(')');
            recur(result, temp, left, right + 1, n);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    @Test
    public void tempTest() {
        int n = 3;
        List<String> res = generateParenthesis(n);
        for (String temp : res) {
            System.out.println(temp);
        }
    }
}
