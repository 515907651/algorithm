import java.util.ArrayList;
import java.util.List;

public class WordLadder {
    int num = 0;

    private static boolean canTrans(String a,String b){
        int n = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i)!=b.charAt(i)) n++;
        }
        if(n==1) return true;
        return false;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = new String[] {"hot","dot","dog","lot","log","cog"};
        List<String> wordList1 = new ArrayList<>() ;
        for (int i = 0; i < wordList.length; i++) {
            wordList1.add(wordList[i]);
        }


    }
    private int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord==endWord) return num;
        int length = wordList.size();
        boolean[] flag = new boolean[length];
        for (int i = 0; i < length; i++) {
            flag[i] = true;
        }

        for (int i = 0; i < length; i++) {
            if(canTrans(beginWord,wordList.get(i))&&flag[i]) {
                flag[i] =false;
                num++;
                ladderLength(wordList.get(i),endWord,wordList);
            }
        }


        return 1;
    }

}
