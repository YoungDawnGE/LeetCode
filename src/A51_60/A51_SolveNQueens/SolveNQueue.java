package A51_60.A51_SolveNQueens;

import MyUtils.ArrayUtil;

/**
 * Created by GYC
 * 2020/9/26 14:55
 * 输入：4
 * 输出：[
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 *
 * 先做一个简单的版本，不能在同一行，同一列，不考虑斜角
 *
 */
public class SolveNQueue {

    public static void main(String[] args) {
        new SolveNQueue().solveNQueens(10);
    }
    public void solveNQueens(int n) {
        //按顺序填充每一行，只要记录当前列是否被占用就OK
        boolean[] col = new boolean[n];//记录列是否被占
        int[][] M = new int[n][n];
        backtrack(col, 0, M, n);
    }


    /**
     * 回溯的状态变量 row col M
     * depth int 记录当前的行数
     */
    public void backtrack(boolean[] col, int depth, int[][] M, int n) {
        if (depth == n ) {
            ArrayUtil.printArray2D(M);
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i]) {//列被占用
                continue;
            }
            col[i] = true;
            M[depth][i] = 1;
            backtrack(col, depth + 1, M, n);
            M[depth][i] = 0;
            col[i] = false;
        }
    }
}
