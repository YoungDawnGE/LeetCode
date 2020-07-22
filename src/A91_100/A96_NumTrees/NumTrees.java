package A91_100.A96_NumTrees;

/**
 * Created by GYC
 * 2020/7/6 9:51
 * 96. 不同的二叉搜索树
 * 难度中等595
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 示例:
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *      1         3     3       2       1
 *       \       /     /       / \       \
 *        3     2     1       1   3       2
 *       /     /       \                   \
 *      2     1        2                   3
 */
public class NumTrees {
    public static void main(String[] args) {
        System.out.println(new NumTrees().numTrees(2));

    }
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        //不用dp[0]
        dp[0] = 1;
        dp[1] = 1;
        if (n < 2) {
            return dp[n];
        }
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < i+1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
