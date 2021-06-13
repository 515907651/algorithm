package topinterview;

import java.util.HashMap;

public class _36_IsValidSudoku_medium {
    /**
     * 看到这个题我的思路是
     * 遍历三次数组，分别判断行，列和子数组内是否有重复
     * 题解遍历一次
     * 利用
     * box_index = (row / 3) * 3 + columns / 3
     * 来确定box*/
    public boolean isValidSudoku(char[][] board) {
        // 三个hashmap判断重复
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        // 将三个map初始化
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 先算boxIndex
                int boxIndex = (i / 3) * 3 + j / 3;
                // 将所有数据加入hashmap
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                    columns[j].put(num, columns[j].getOrDefault(num, 0) + 1);
                    boxes[boxIndex].put(num, boxes[boxIndex].getOrDefault(num, 0) + 1);
                    // 判断重复
                    if (rows[i].get(num) > 1 || columns[j].get(num) > 1 || boxes[boxIndex].get(num) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
