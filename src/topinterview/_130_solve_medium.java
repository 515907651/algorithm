package topinterview;

public class _130_solve_medium {
    // 深度优先，写写递归，递归可太绕了
    // 思路是遍历边界上的0，以他为根，深度优先搜索其他节点，相连的0标记，最后把所有标记的变成0，没标记的变成x
    // 思路简单，但是写起来太多行列的变换，容易出错
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int column = board[0].length;
        // 遍历边界，这里面有重复遍历的几个，不过无所谓
/*
        for (int i = 0; i < column; i++) {
            // 第0行
            if (board[0][i] == 'O') {
                board[0][i] = 'A';
                dfs(board, 0 , i);
            }
        }
        for (int i = row - 1; i < column; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = 'A';
                dfs(board, 0 , i);
            }
        }
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'A';
                dfs(board, i , 0);
            }
        }
        for (int i = column - 1; i < row; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'A';
                dfs(board, i , 0);
            }
        }
*/
        // 上面这一部分是可以合并的
        for (int i = 0; i < column; i++) {
            // 第0行
            if (board[0][i] == 'O') {
                board[0][i] = 'A';
                dfs(board, 0 , i);
            }
            if (board[row - 1][i] == 'O') {
                board[row - 1][i] = 'A';
                dfs(board, row - 1, i);
            }
        }
        for (int i = 0; i < row; i++) {
            // 第0行
            if (board[i][0] == 'O') {
                board[i][0] = 'A';
                dfs(board, i , 0);
            }
            if (board[i][column - 1] == 'O') {
                board[i][column - 1] = 'A';
                dfs(board, i, column - 1);
            }
        }

        // 遍历数组，转换、
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int row, int column) {
        // 对于行列的四个方向进行遍历
        if (row + 1 < board.length && board[row + 1][column] == 'O') {
            board[row + 1][column] = 'A';
            dfs(board, row + 1, column);
        }
        if (row - 1 >= 0 && board[row - 1][column] == 'O') {
            board[row - 1][column] = 'A';
            dfs(board, row - 1, column);
        }
        if (column - 1 >= 0 && board[row][column - 1] == 'O') {
            board[row][column - 1] = 'A';
            dfs(board, row, column - 1);
        }
        if (column + 1 < board[0].length && board[row][column + 1] == 'O') {
            board[row][column - 1] = 'A';
            dfs(board, row, column + 1);
        }

    }

    /*
    题解的思路和我大同小异
    不同点在于，他是在dfs中判断节点是否是'O'
    其中最好的一个点是，判断节点是否合法的时候，一句话就ok，简单优雅
    class Solution {
    int n, m;

    public void solve(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/surrounded-regions/solution/bei-wei-rao-de-qu-yu-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

}
