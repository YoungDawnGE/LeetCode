package A151_160.A152_MaxProduct;

import MyUtils.ArrayUtil;

/**
 * Created by GYC
 * 2020/8/11 14:34
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaxProduct {
    public static void main(String[] args) {
        int[] input = {2,-1,1,1};
        System.out.println(new MaxProduct().maxProduct(input));

    }
    //way1 动态规划
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[][] dp = new int[len][2];//第0列记录max，第1列记录min
        dp[0][0] = dp[0][1] = nums[0];
        int max = nums[0];
        int temp;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(nums[i], Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]));
            dp[i][1] = Math.min(nums[i], Math.min(dp[i - 1][1] * nums[i], dp[i - 1][0] * nums[i]));
            temp = Math.max(dp[i][0], dp[i][1]);
            max = Math.max(max, temp);
        }
        ArrayUtil.printArray2D(dp);
        return max;
    }

    //way2 记录累乘 贪心
    public int maxProduct2(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];//第0列表示max，第1列表示min
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {

        }
        return 0;
    }

}
