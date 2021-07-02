package topinterview;

import java.util.*;

public class _127_ladderLength_hard {
    // 最少再看两遍，太复杂，太绕了
    Map<String, Integer> wordID = new HashMap<>();
    List<List<Integer>> edge = new ArrayList<>();
    int wordNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 将所有的word加入wordId
        for (String temp : wordList) {
            addEdge(temp);
        }
        addEdge(beginWord);
        // 验证endWord是否在其中
        if (!wordID.containsKey(endWord)) {
            return 0;
        }
        // 设置标志数组
        int[] dis = new int[wordNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordID.get(beginWord);
        int endId = wordID.get(endWord);
        // 这里什么意思
        dis[beginId] = 0;

        Deque<Integer> queue = new LinkedList<>();
        queue.offer(beginId);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == endId) {
                // 这个距离怎么算
                return dis[endId] / 2 + 1;
            }
            for (int i : edge.get(x)) {
                // 遍历x的所有边
                if (dis[i] == Integer.MAX_VALUE) {
                    // 如果没有遍历过这条边
                    dis[i] = dis[x] + 1;
                    queue.offer(i);
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        // 这个edge的结构要搞明白，他的index就对应着加入word的顺序，存储着能够到达的边，每个边在wordId中都存储着他的序号
        addWord(word);
        int id1 = wordID.get(word);
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char temp = array[i];
            array[i] = '*';
            String newWord = array.toString();
            addWord(newWord);
            int id2 = wordID.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = temp;
        }
    }

    public void addWord(String word) {
        if (!wordID.containsKey(word)) {
            wordID.put(word, wordNum++);
            edge.add(new ArrayList<Integer>());
        }
    }
}
