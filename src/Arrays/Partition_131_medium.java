package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Partition_131_medium {
    // 给的案例里，单个字母也是回文串
    // 要求返回所有的回文串
    // 第一个想到的方法是递归，从第一个开始，找到第一个回文字串，然后把剩下的字符串放到递归里
    // 淦，写不出来
    List<String> temp = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        recur(s,0);
        return result;
    }
    public void recur(String s, int current) {
        if (s.length()==current) {
            //result.add(temp);
            // 如果加入的是temp，那么加入的是引入，每次remove都会在temp中删去
            result.add(new ArrayList<String>(temp));
            return;
        }
            for (int j = current; j < s.length(); j++) {
                if (isHui(s,current,j)) {
                    temp.add(s.substring(current,j+1));
                    recur(s,j+1);
                    temp.remove(temp.size() - 1);//这一句每次j++都会清空temp。
                }
            }

    }
    public boolean isHui(String s, int i, int j){
        while(i<j){
            if (s.charAt(i)!=s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
