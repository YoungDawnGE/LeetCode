package A61_70.A62_UniquePaths;

/**
 * Created by GYC
 * 2020/7/2 11:00
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 *
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 *
 * 提示：
 *
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 */
public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        System.out.println(new UniquePaths().uniquePaths(m, n));

    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        //初始化 上方
        for (int i = 0; i < n-1; i++) {
            dp[0][i + 1] = dp[0][i];
        }

        //初始化 左侧
        for (int i = 0; i < m-1; i++) {
            dp[i + 1][0] = dp[i][0];
        }

        //构建dp表
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];//动态方程
            }
        }

        return dp[m - 1][n - 1];
    }
}
