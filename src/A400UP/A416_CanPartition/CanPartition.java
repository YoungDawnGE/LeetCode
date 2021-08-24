package A400UP.A416_CanPartition;

import java.util.Arrays;

/**
 * Created by GYC
 * 2021/8/24 13:12
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class CanPartition {
    public static void main(String[] args) {
//        int[] nums = {1, 5, 11, 5};
        int[] nums = {1, 2, 3, 8};


        System.out.println(new CanPartition().canPartition(nums));

    }

    //01背包问题
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        //背包的大小
        int volume = sum / 2;
        //有nums个物品，从这些物品里面取，使其满足正好装满volume大小的背包
        //dp[i][j] 表示在1~j中取物品，放到大小为j的背包里，
        // 到最后遍历  dp[i][volume]看看是否有dp[i][volume]==volume，有则return true
        //转移方程
        // 考虑第i个是否要放入背包
        //1、NO
        //  dp[i][j]=dp[i-1][j]
        //2、YES
        //  dp[i][j]=dp[i-1][j-v[i]]+w[i]  本题中的vi和wi相等的   其中j-v[i]>=0


        int[][] dp = new int[nums.length + 1][volume + 1];

        //初始化第1行   当前容量是j，
        for (int j = 1; j <= volume; j++) {
            dp[1][j] = nums[0] > j ? 0 : nums[0];
        }

        //背包问题
        for (int i = 2; i <= nums.length; i++) {
            for (int j = 1; j <= volume; j++) {
                if (j - nums[i-1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i-1]] + nums[i-1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        //看看是否有dp[i][volume]==volume
        for (int i = 2; i <= nums.length; i++) {
            if (dp[i][volume] == volume) {
                return true;
            }
        }
        return false;
    }
}
