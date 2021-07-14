package A61_70.A63_UniquePathsWithObstacles;

import MyUtils.ArrayUtil;

/**
 * @program: LeetCode
 * @description:
 * @author: geyangchen
 * @create: 2021/7/14 17:48
 * 63. 不同路径 II
 * 难度中等587收藏分享切换为英文接收动态反馈
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 示例 1：
 *
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 示例 2：
 *
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 *
 * 提示：
 * 	• m == obstacleGrid.length
 * 	• n == obstacleGrid[i].length
 * 	• 1 <= m, n <= 100
 * 	• obstacleGrid[i][j] 为 0 或 1
 **/
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        UniquePathsWithObstacles instance = new UniquePathsWithObstacles();
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        ArrayUtil.printArray2D(obstacleGrid);
        System.out.println(instance.uniquePathsWithObstacles(obstacleGrid));
    }

    //动态规划 + 滚动数组（节省空间）
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid.length;//行
        int y = obstacleGrid[0].length;//列
        int[] f = new int[y];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int i = 0; i < x; i++) {
            //滚动数组牛逼啊，f[j]在i=2的时候就到了第二行
            for (int j = 0; j < y; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j-1] == 0) {
                    f[j] += f[j - 1];//等于dp[i][j]=dp[i-1][j]+dp[i][j-1]
                }
            }
        }
        return f[y - 1];
    }
}
