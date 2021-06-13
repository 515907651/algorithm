package topinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _17_LetterCombinations_medium {
    private HashMap<Character, String> hashMap = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        // 深度优先搜索
        // 首先将所有数字和字母的对应关系加入hashmap。
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
        // 返回的结果
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        // 然后对于digits进行遍历
        // Stringbuffer存储当前字符串
        recur(result, digits, 0, new StringBuffer());
        return result;
    }

    private void recur(List<String> result, String digits, int index, StringBuffer stringBuffer) {
        if (index == digits.length()) {
            result.add(stringBuffer.toString());
            return;
        }
        String temp = hashMap.get(digits.charAt(index));
        for (int i = 0; i < temp.length(); i++) {
            stringBuffer.append(temp.charAt(i));
            recur(result, digits, index + 1, stringBuffer);
            stringBuffer.deleteCharAt(index);
        }
    }

}
