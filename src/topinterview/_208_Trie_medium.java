package topinterview;

public class _208_Trie_medium {
    // 1次AC，我可真是小天才
    // 首先要熟悉什么是前缀树
    // 前缀树形式上是带有结束标志的多叉树
    // 有两种基本操作，insert和search
    private _208_Trie_medium[] children;
    private boolean isEnd;

    // 初始化
    public _208_Trie_medium() {
        // 有26个字符，对应26个子节点
        children = new _208_Trie_medium[26];
        // flag = false对应着不是结尾
        isEnd = false;
    }

    // 插入操作
    public void insert(String word) {
        // 当前节点的子节点如果没有word[i]，新建节点存入word[i]，循环
        // 当前节点的子节点有word[i]，当前节点变为其子节点，循环
        // 当进行到word[l - 1]时，flag = true；
        // 特殊条件判断
        if (word == null || word.length() == 0) {
            return;
        }
        int l = word.length();
        _208_Trie_medium temp = this;
        for (int i = 0; i < l; i++) {
            int n = word.charAt(i) - 'a';
            if (temp.children[n] == null) {
                temp.children[n] = new _208_Trie_medium();
            }
            temp = temp.children[n];
            if (i == l - 1) {
                temp.isEnd = true;
            }
        }
    }

    // search操作
    public boolean search(String word) {
        // 当前节点的子节点没有word[i]，直接返回false
        // 当前节点的子节点有word[i]，当前节点变为其子节点，循环
        // 如果到word[l-1]并且isEnd是true时，返回true；
        if (word == null || word.length() == 0) {
            return true;
        }
        int l = word.length();
        _208_Trie_medium temp = this;
        for (int i = 0; i < l; i++) {
            int n = word.charAt(i) - 'a';
            if (temp.children[n] == null) {
                return false;
            }
            temp = temp.children[n];
            // 这个顺序感觉要注意一下
            if (i == l - 1 && temp.isEnd) {
                return true;
            }
        }
        return false;
    }

    // 查找前缀
    public boolean startsWith(String prefix) {
        // 简化版的search
        // 当前节点的子节点没有word[i]，直接返回false
        // 当前节点的子节点有word[i]，当前节点变为其子节点，循环
        // 最后返回true
        if (prefix == null || prefix.length() == 0) {
            return true;
        }
        int l = prefix.length();
        _208_Trie_medium temp = this;
        for (int i = 0; i < l; i++) {
            int n = prefix.charAt(i) - 'a';
            if (temp.children[n] == null) {
                return false;
            }
            temp = temp.children[n];
            // 这个顺序感觉要注意一下
        }
        return true;

    }

}
