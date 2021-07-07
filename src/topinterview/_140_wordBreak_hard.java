package topinterview;

import java.util.*;

public class _140_wordBreak_hard {
    // 单词拆分的进阶版本，要求返回所有结果，而不是是否可以拆分
    // 回溯法，也就是自顶向下的动态规划+剪枝
    // 完全不会写，主要是剪枝部分，抄一遍答案理解一下
    // 模拟一下过程，从底向上的方法是，对于每一个开头在set中的子串，去找他剩余部分中在set中的单词
    // 自顶向下的方法是，淦，不理解，
    // 首先明确map中存储的是什么，是下标对应的从下标到结尾的拆分后的句子
    // 对于0-index，如果对应的子串在set中，判断index到length，然后将他加入判断后的list的头部
    public List<String> wordBreak(String s, List<String> wordDict) {
        // 用来存储每个位置的？句子？
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<String>(wordDict), 0, map);
        List<String> breakList = new LinkedList<>();
        for (List<String> wordBreak:
             wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    private List<List<String>> backtrack(String s, int length, HashSet<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            // 之前没求过index至length的句子
            // 当前的句子
            List<List<String>> wordBreaks = new LinkedList<>();
            if (index == length) {
                // 当到结尾，在句子中加入空链表？
                // 已经没有句子加入了，这一步有必要么，假如当前位置就是index，不新建的活就是null，所以还是有必要的，最后把空的去掉就好了
                wordBreaks.add(new LinkedList<String>());
            }
            for (int i = index + 1; i <= length; i++) {
                // 这个地方还蛮好理解的，对于index后面的子串，如果index到i在set中，就求i之后的句子
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak:
                         nextWordBreaks) {
                        // 这里要理解好list的结构，nextWordBreaks中存储的是多个句子
                        // 每次取出一个句子，把word加入队首，然后再将这个句子放回list
                        LinkedList<String> wordBreak = new LinkedList<>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }
}
