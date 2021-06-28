package topinterview;

import org.junit.Test;

public class _79_exist_medium {
    // 深度优先+标记状态，有点回溯法的感觉
    // 好多点出错
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 当能够找到的时候直接返回
                flag = dfs(board, visited, word, i , j , 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int k) {
        if (board[i][j] != word.charAt(k)) {
            // 不相等直接返回
            return false;
        } else if (k == word.length() - 1) {
            return true;
        }
        boolean f1 = false;
        boolean f2 = false;
        boolean f3 = false;
        boolean f4 = false;
        // 当前位置已经遍历过
        visited[i][j] = true;
        if (j - 1 >= 0 && !visited[i][j-1]) {
            visited[i][j-1] = true;
            f1 = dfs(board, visited, word, i , j - 1, k + 1);
            visited[i][j-1] = false;

        }
        if (j + 1 < board[0].length && !visited[i][j+1]) {
            visited[i][j+1] = true;
            f2 = dfs(board, visited, word, i, j + 1, k + 1);
            visited[i][j+1] = false;

        }
        if (i + 1 < board.length && !visited[i+1][j]) {
            visited[i+1][j] = true;
            f3 = dfs(board, visited, word, i + 1, j , k + 1);
            visited[i+1][j] = false;

        }
        if (i - 1 >= 0 && !visited[i-1][j]) {
            visited[i-1][j] = true;
            f4 = dfs(board, visited, word, i - 1, j, k + 1);
            visited[i-1][j] = false;

        }
        // 当前状态变为未遍历
        visited[i][j] = false;
        return f1||f2||f3||f4;


    }

    @Test
    public void tempTest() {
        char[][] board = {{'a','a'}};
        String word = "aaa";
        System.out.println(exist(board, word));
    }
}
