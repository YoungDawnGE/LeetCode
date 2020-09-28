package A51_60.A51_SolveNQueens;

/**
 * Created by GYC
 * 2020/9/26 16:54
 *
 * 返回N皇后的个数
 */
public class SolveNQueue2 {
    private int count = 0;
    public static void main(String[] args) {
        System.out.println(new SolveNQueue2().solveNQueens(15));
    }
    public int solveNQueens(int n) {
        boolean[] col = new boolean[n];//记录列是否被占
        boolean[] diagonals1 = new boolean[n * 2 - 1];//   /
        boolean[] diagonals2 = new boolean[n * 2 - 1];//  \
        int[][] M = new int[n][n];
        backtrack(0, n, M, col, diagonals1, diagonals2);
        return count;
    }

    public void backtrack(int depth, int n, int[][] M, boolean[] col, boolean[] diagonals1, boolean[] diagonals2) {
        if (depth == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i]) {
                continue;
            }

            //   /斜边
            int d1 = depth + i;
            if (diagonals1[d1]) {// /行+列的下标
                continue;
            }
            //   \斜边
            int d2 = i - depth + n - 1;
            if (diagonals2[d2]) {// \列-行+n-1
                continue;
            }

            col[i] = true;
            diagonals1[d1] = true;
            diagonals2[d2] = true;
            M[depth][i] = 1;

            backtrack(depth + 1, n, M, col, diagonals1, diagonals2);

            diagonals1[d1] = false;
            diagonals2[d2] = false;
            col[i] = false;
            M[depth][i] = 0;
        }
    }
}
