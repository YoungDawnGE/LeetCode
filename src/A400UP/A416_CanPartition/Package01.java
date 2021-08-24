package A400UP.A416_CanPartition;

import MyUtils.ArrayUtil;

/**
 * Created by GYC
 * 2021/8/24 14:27
 描述
 已知一个背包最多能容纳物体的体积为 V


 现有 n个物品，第i个物品的体积为vi, 重量为wi


 求当前背包最多能装多大重量的物品?

 数据范围：
 1≤V≤5000
 1≤n≤5000
 1≤vi≤5000
 1≤wi≤5000

 复杂度要求：
 O(n⋅V)
 示例1
 输入：10,2,[[1,3],[10,4]]复制
 返回值：4
 复制
 说明：第一个物品的体积为1，重量为3，第二个物品的体积为10，重量为4。只取第二个物品可以达到最优方案，取物重量为4
 备注：
 1≤V≤200
 1≤n≤200
 1≤vi≤200
 1≤wi≤200

 */
public class Package01 {
    public static void main(String[] args) {

        int V = 10;
        int n = 2;
        int[][] vw = {
                {1,3},
                {10,4}};

        System.out.println(new Package01().knapsack2(V, n, vw));

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算01背包问题的结果
     * @param V int整型 背包的体积
     * @param n int整型 物品的个数
     * @param vw int整型二维数组 第一维度为n,第二维度为2的二维数组,vw[i][0],vw[i][1]分别描述i+1个物品的vi,wi
     * @return int整型
     */
    //way1 dp[][]未有空间优化
    public int knapsack (int V, int n, int[][] vw) {
//        01背包问题
//        dp[i][j]表示，从第0~i个物品里，放到容量为V的背包，所取的最大价值
//        第i个物品有放和不放的区别
//         不放第i个物品  A= dp[i][j] = dp[i-1][j]  就是从第0~i-1个物品里取，放到容量为j的背包里
//         放第i个物品    B= dp[i][j] = dp[i-1][j-vi] + wi  就看子问题，从0~i-1里面取，看看能不能放到容量为j-vi的背包里
//
//        所以转以方程
//        dp[i][j] == max(A,B)

        int[][] dp = new int[n + 1][V + 1];
        //画个图就知道是左->右  上到下  逐行构建

        //dp[0][j]=0, dp[i][j]=0


        //构建dp[1][j],把第1个物品放到容量j的背包产生的最大价值
        for (int j = 1; j <= V; j++) {
            dp[1][j] = vw[0][0] > j ? 0 : vw[0][1];

        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                //这边的vw物品下标是0开始的

                //这边要考虑下标越界
                if (j - vw[i - 1][0] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vw[i - 1][0]] + vw[i - 1][1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][V];
    }


    //way2 有空间优化
    public int knapsack2 (int V, int n, int[][] vw) {
        //01背包问题
        //空间优化：利用滚动数组
        //只需要1维度
        int[] dp = new int[V + 1];

        //初始话第一行
        for (int j = 1; j <=V ; j++) {
            //vw[i][0]体积,vw[i][1]价值
            dp[j] = vw[0][0] > j ? 0 : vw[0][1];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = V; j >=1 ; j--) {
                if (j - vw[i - 1][0] < 0) {//说明放不下第j个物品
                    //dp[j]保持不变
                } else {
                    dp[j] = Math.max(dp[j], dp[j - vw[i - 1][0]] + vw[i - 1][1]);
                }
            }
        }
        return dp[V];
    }
}
