package A0_alibaba20210723.PDDTest20210820;

import MyUtils.ArrayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: geyangchen
 * @create: 2021/8/21 08:41
 * [编程题]多多的求和计算
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 256M，其他语言512M
 *
 * 多多路上从左到右有N棵树（编号1～N），其中第i个颗树有和谐值Ai。
 * 多多鸡认为，如果一段连续的树，它们的和谐值之和可以被M整除，那么这个区间整体看起来就是和谐的。
 * 现在多多鸡想请你帮忙计算一下，满足和谐条件的区间的数量。
 *
 * 输入描述:
 * 第一行，有2个整数N和M，表示树的数量以及计算和谐值的参数。
 * （ 1 <= N <= 100,000, 1 <= M <= 100  ）
 * 第二行，有N个整数Ai, 分别表示第i个颗树的和谐值。
 * （ 0 <= Ai <= 1,000,000,000 ） 2^30   int类型
 *
 * 输出描述:
 * 共1行，每行1个整数，表示满足整体是和谐的区间的数量。
 *
 * 输入例子1:
 * 5 2
 * 1 2 3 4 5
 *
 * 输出例子1:
 * 6
 *
 * 例子说明1:
 * 长度为1: [2], [4]
 * 长度为2: 无
 * 长度为3: [1,2,3], [3,4,5]
 * 长度为4: [1,2,3,4], [2,3,4,5]
 * 长度为5: 无
 * 共6个区间的和谐值之和可以被2整除。
 **/
public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if (N == 0) {
            System.out.println(0);
            return;
        }



        int M = sc.nextInt();
        long[] trees = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            trees[i] = sc.nextLong();
        }
        System.out.println(getAns2(N, M, trees));
    }

    //N 树的数量
    //M mod M
    //dp[][]会超过内存限制，用该用滚动数组
    public static int getAns(int N, int M, int[] trees) {

        //动态规划
        //dp[i][j]表示i～j之间的数字大小
        //dp[i][j+1] = dp[i][j] + trees[j+1]
        //dp[i+1][j] = dp[i][j] - trees[i]
        //dp[i+1][j+1] = dp[1]
        //   i,j      i,j+1
        // i+1,j    i+1,j+1
        //

        long[][] dp = new long[N + 1][N + 1];

        int sum = 0;
        for (int i = 1; i < N+1; i++) {
            dp[i][i] = trees[i];
            if (dp[i][i] % M == 0) {
                sum++;
            }
        }
        ArrayUtil.printArray2D(dp);
        System.out.println();


        for (int i = 1; i < N; i++) {
            for (int j = i; j < N; j++) {
                dp[i][j + 1] = dp[i][j] + trees[j+1];
                if (dp[i][j + 1] % M == 0) {
                    sum++;
                }
            }
        }
        ArrayUtil.printArray2D(dp);

        return sum;
    }


    //2.滚动数组   报错了 不会了
    public static int getAns2(int N, int M, long[] trees) {
        // 0 0 0 0 0 0
        // 0 1 3 6 10 15
        // 0 0 2 5 9 14
        // 0 0 0 3 7 12
        // 0 0 0 0 4 9
        // 0 0 0 0 0 5
        int sum = 0;
        long[] dp = new long[N + 1];
        dp[1] = trees[1];
        for (int i = 1; i < N; i++) {
            dp[i + 1] = dp[i] + trees[i+1];
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                if (dp[j] % M == 0) {
                    sum++;
                }
                dp[j] -= trees[i];
            }
        }
        return sum;
    }
}
