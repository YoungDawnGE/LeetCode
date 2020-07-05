package A51_60.A55_CanJump;

/**
 * Created by GYC
 * 2020/7/5 8:01
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class CanJump {
    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        System.out.println(new CanJump().canJump2_2(arr));

    }

    //way1 构建二维数组 记录i是否可以到j  此方法超出内存限制
    public boolean canJump1(int[] nums) {
        //构建dp[][]
        int len = nums.length;
        if (len == 1) {
            return true;
        }
        boolean dp[][] = new boolean[len][len];
        boolean[] canReach = new boolean[len];
        canReach[0] = true;
        for (int i = 0; i < len; i++) {
            if (!canReach[i]) continue;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j > len - 1) {
                    break;
                }
                dp[i][i+j] = true;
                canReach[i + j] = true;
            }
        }

        for (int i = 0; i < len; i++) {
            if (dp[i][len - 1]) {
                return true;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return false;
    }

    //way2 官网 可以到达的最远位置
    public boolean canJump2(int[] nums) {
        if (nums.length==1) return true;
        int len = nums.length;
        int maxDistance = 0;
        for (int i = 0; i < len; i++) {
            if (maxDistance >= i) {
                maxDistance = Math.max(maxDistance, i + nums[i]);
            }
        }
        return maxDistance >= len - 1;
    }

    //way2.1 way2的改进版本
    public boolean canJump2_1(int[] nums) {
        if (nums.length==1) return true;
        int len = nums.length;
        int maxDistance = 0;
        for (int i = 0; i < len; i++) {
            if (i > maxDistance) {
                return false;
            }
            maxDistance = Math.max(maxDistance, i + nums[i]);
        }
        return true;
    }

    //way2.2 way2.1的改进版本 改进循环条件，大于最大长度的时候直接结束
    public boolean canJump2_2(int[] nums) {
        if (nums.length==1) return true;
        int len = nums.length;
        int maxDistance = 0;
        for (int i = 0; i <= maxDistance && maxDistance <= len; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
        }
        return maxDistance >= len - 1;
    }
}
