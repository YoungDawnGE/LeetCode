package A51_60.A53_MaxSubArray;

/**
 * Created by GYC
 * 2020/7/1 12:24
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4,100],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray msa = new MaxSubArray();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int []arr = {-2,-1};
        System.out.println(msa.maxSubArray2(arr));
    }

    //way1 sub[i][j] 为i开始j结尾的序列的和 O(n2)

    //way2 O(n)此方法行不通
    @Deprecated
    public int maxSubArray22(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        //找右边界
        int right=0;
        int sum = 0;
        int maxSum=Integer.MIN_VALUE;
        for (int i = right; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxSum) {
                right = i;
                maxSum = 0;
                sum = 0;
            }
        }
        //找左边界
        int left = nums.length - 1;
        sum = 0;
        maxSum = Integer.MIN_VALUE;
        for (int i = right; i >= 0; i--) {
            sum += nums[i];
            if (sum > maxSum) {
                left = i;
                maxSum = 0;
                sum = 0;
            }
        }
        //求和
        int res = 0;
        for (int i = left; i < right + 1; i++) {
            res += nums[i];
        }
        return res;
    }

    //way2 贪心算法 如果sum<0，那么此之前的都清空
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int sum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < len; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }


    //way3 动态规划dp
    public int maxSubArray3(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return Math.max(max, dp[len - 1]);
    }

    //way4 分治
    public int maxSubArray4(int[] nums) {
        return 0;
    }
}
