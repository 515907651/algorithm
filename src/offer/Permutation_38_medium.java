package offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Permutation_38_medium {
    // 递归来做吧
    // 把每一个字符都放进去一次，然后其他字符依次放进去
    // 什么时候结束呢，当所有字符都放进去的时候
    // 要从头遍历，然后判断当前字符有没有被访问过，建个标志数组吧

    List<String> result;
    Boolean[] visited;
    StringBuilder temp;

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        result = new LinkedList<>();
        int n = s.length();
        temp = new StringBuilder();
        visited = new Boolean[n];
        Arrays.fill(visited, false);
        // 必须初始化
        dfs1(0, s);
        return result.toArray(new String[result.size()]);
    }

    public void dfs(int pos, String s) {
        // 我要建一个数组来存储当前的序列，当数组满了，返回
        // 写不出来，大体思路有点，但是具体不会
        if (temp.length() == s.length()) {
            result.add(temp.toString());
            //System.out.println(temp);
            // 只输出了一次
            temp = new StringBuilder();
            return;
        }
        temp.append(s.charAt(pos));
        //System.out.println(temp);
        visited[pos] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                // 报错空指针异常
                dfs(i, s);
                visited[i] = false;
            } else {
                continue;
            }
        }
        return;
    }

    public void dfs1(int pos, String s) {
        // 没考虑重复字符
        // 还得剪枝
        if (pos == s.length()) {
            //System.out.println(temp);
            if (result.contains(temp.toString())) {
                return;
            }
            result.add(temp.toString());
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                if (set.contains(s.charAt(i))) {
                    continue;
                }
                set.add(s.charAt(i));
                temp.append(s.charAt(i));
                visited[i] = true;
                dfs1(pos + 1, s);
                temp.deleteCharAt(temp.length() - 1);
                visited[i] = false;
            }
        }
        return;
    }
}