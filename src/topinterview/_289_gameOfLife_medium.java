package topinterview;

import java.util.Arrays;

public class _289_gameOfLife_medium {
    // 空间复杂度为mn
    // 出的bug是新建了temp数组，但是没把原数组copy进去
    public void gameOfLife(int[][] board) {
        // 首先特殊情况判断
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int column = board[0].length;
        int[][] temp = new int[row][column];
        for (int i = 0; i < row; i++) {
            temp[i] = Arrays.copyOf(board[i],column);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                    // 活细胞的数量
                    int num = 0;
                    if (i - 1 >= 0) {
                        // 有上一行，判断上一行的情况
                        if (j - 1 >= 0 && temp[i - 1][j - 1] == 1) {
                            // 上一行上一列位置
                            num++;
                        }
                        if (temp[i - 1][j] == 1) {
                            num++;
                        }
                        if (j + 1 < column && temp[i - 1][j + 1] == 1) {
                            num++;
                        }
                    }
                    // 当前行
                    if (j - 1 >= 0 && temp[i][j - 1] == 1) {
                        num++;
                    }
                    if (j + 1 < column && temp[i][j + 1] == 1) {
                        num++;
                    }
                    // 第三行
                    if (i + 1 < row) {
                        if (j - 1 >= 0 && temp[i + 1][j - 1] == 1) {
                            // 上一行上一列位置
                            num++;
                        }
                        if (temp[i + 1][j] == 1) {
                            num++;
                        }
                        if (j + 1 < column && temp[i + 1][j + 1] == 1) {
                            num++;
                        }
                    }
                    // 分析num的数量
                if (temp[i][j] == 1) {
                    // 活细胞的情况
                    if (num < 2) {
                        board[i][j] = 0;
                    } else if (num > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    // 死细胞的情况
                    if (num == 3) {
                        board[i][j] = 1;
                    }

                }

            }
        }
    }
    public void gameOfLife1(int[][] board) {
        // 我总是把所有情况列举出来，然后去判断合法性，尽量归结到一起，然后判断合法性
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int column = board[0].length;
        int[][] temp = new int[row][column];
        for (int i = 0; i < row; i++) {
            temp[i] = Arrays.copyOf(board[i],column);
        }
        // 各个方向
        int[] de = {-1, 0, 1};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int num = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (k == 1 && l == 1) {
                            // 当是自身位置的时候，直接跳过
                            continue;
                        }
                        int tempR = i + de[k];
                        int tempC = j + de[l];
                        if (tempR >= 0 && tempR < row && tempC >= 0 && tempC < column && temp[tempR][tempC] == 1) {
                            num++;
                        }
                    }
                }
                // 分析num的数量
                if (temp[i][j] == 1) {
                    // 活细胞的情况
                    if (num < 2) {
                        board[i][j] = 0;
                    } else if (num > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    // 死细胞的情况
                    if (num == 3) {
                        board[i][j] = 1;
                    }

                }
            }
        }
    }

    public void gameOfLife2(int[][] board) {
        // 在自身位置上进行修改，不新建数组
        // 要分情况讨论的，活细胞可能变成死细胞，死细胞可能变成活细胞
        // 如果变死细胞，那么变成-1，变成活细胞，那么变成2，这样0和2代表原先是死细胞，-1和1代表原先是活细胞
        // 最后再更新一遍数组，把-1变成0，把2变成1
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int column = board[0].length;
        // 各个方向
        int[] de = {-1, 0, 1};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int num = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (k == 1 && l == 1) {
                            continue;
                        }
                        int tempR = i + de[k];
                        int tempC = j + de[l];
                        if (tempR >= 0 && tempR < row && tempC >= 0 && tempC < column && (board[tempR][tempC] == 1 || board[tempR][tempC] == -1)) {
                            num++;
                        }
                    }
                }
                // 更新
                if (board[i][j] == 1) {
                    // 活细胞的情况
                    if (num < 2) {
                        board[i][j] = -1;
                    } else if (num > 3) {
                        board[i][j] = -1;
                    }
                } else {
                    // 死细胞的情况
                    if (num == 3) {
                        board[i][j] = 2;
                    }

                }

            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
