package A71_80.A72_MinDistance;

import MyUtils.ArrayUtil;

/**
 * @program: LeetCode
 * @description:
 * @author: geyangchen
 * @create: 2021/8/21 14:23
 *
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 *
 * 提示：
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 **/
public class MinDistance {
    public static void main(String[] args) {
        String w1 = "sea";
        String w2 = "eat";
        System.out.println(new MinDistance().minDistance(w1, w2));
    }

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        if (len1 == 0 || len2 == 0) {
            return len1 == 0 ? len2 : len1;
        }
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int[][] dp = new int[len1 + 1][len2 + 1];

        //找转移方程
        //dp[i][j] 表示 w1[0...i]-->w2[0...j]要操作的次数
        //1.w1[i]==w2[j]的情况下
        //  dp[i][j] = dp[i-1][j-1]

        //2.w1[i] != w2[j]的情况下
        // * 插入一个字符 dp[i][j] = 插w1[i]后面 1 + dp[i][j-1]
        //                         插w2[j]后面 1 + dp[i-1][j]
        // * 删除一个字符 dp[i][j] = 删w2[j]    1 + dp[i][j-1]
        //                         删w1[i]    1 + dp[i-1][j]
        // * 替换一个字符 dp[i][j] = 1 + dp[i-1][j-1]

        //综上 dp[i][j]由左边、上边、左上最小的值决定
        //  i-1,j-1   i-1,j
        //    i,j-1     i.j
        //so 先把dp[0][j]行，和dp[i][0]给计算好

        //初始化
        //  初始化行
        for (int j = 0; j < len2 + 1; j++) {
            dp[0][j] = j;
        }

        //  初始化列
        for (int i = 1; i < len1 + 1; i++) {
            dp[i][0] = i;
        }

        //按照转移方程来
        for (int i = 1; i < len1+1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
            }
        }

        ArrayUtil.printArray2D(dp);
        return dp[len1][len2];
    }


    //研究一下下面为什么错了
    public int ErrorMinDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        if (len1 == 0 || len2 == 0) {
            return len1 == 0 ? len2 : len1;
        }
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int[][] dp = new int[len1][len2];

        //找转移方程
        //dp[i][j] 表示 w1[0...i]-->w2[0...j]要操作的次数
        //1.w1[i]==w2[j]的情况下
        //  dp[i][j] = dp[i-1][j-1]

        //2.w1[i] != w2[j]的情况下
        // * 插入一个字符 dp[i][j] = 插w1[i]后面 1 + dp[i][j-1]
        //                         插w2[j]后面 1 + dp[i-1][j]
        // * 删除一个字符 dp[i][j] = 删w2[j]   1 + dp[i][j-1]
        //                         删w1[i]   1 + dp[i-1][j]
        // * 替换一个字符 dp[i][j] = 1 + dp[i-1][j-1]

        //综上 dp[i][j]由左边、上边、左上最小的值决定
        //  i-1,j-1   i-1,j
        //    i,j-1     i.j
        //so 先把dp[0][j]行，和dp[i][0]给计算好

        //初始化
        if (w1[0] == w2[0]) {
            dp[0][0] = 0;
        } else {
            dp[0][0] = 1;
        }

        //  初始化行
        for (int j = 1; j < len2; j++) {
            dp[0][j] = 1 + dp[0][j - 1];
        }

        //  初始化列
        for (int i = 1; i < len1; i++) {
            dp[i][0] = 1 + dp[i - 1][0];
        }


        //按照转移方程来
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (w1[i] == w2[j]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1+Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }
}
