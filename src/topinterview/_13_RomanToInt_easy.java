package topinterview;

import java.util.HashMap;
import java.util.Map;

public class _13_RomanToInt_easy {
    // 具体思路就是数七种符号的个数,
    // 'I', 'V', 'X', 'L', 'C', 'D', 'M'，七个字符
    // 6个特殊情况 IV = 4, IX = 9, XL = 40, XC = 90, CD = 400, CM = 900

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            if (i < s.length() - 1 && value < map.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }
        return result;
    }

}
