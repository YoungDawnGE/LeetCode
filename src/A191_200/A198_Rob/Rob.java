package A191_200.A198_Rob;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by GYC
 * 2020/7/9 9:20
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * 通过次数149,005提交次数324,736
 */
public class Rob {
    public static void main(String[] args) {
        int[] arr = {183, 219, 57, 193, 94, 233, 202, 211, 222, 789, 12, 128, 64, 13, 18, 190, 24, 234, 111, 31, 98};
//        int[] arr = {2, 7, 9, 3, 1};
//        System.out.println(new Rob().rob(arr));
        System.out.println(new Rob().rob2(arr));
    }

    private int maxSum = 0;

    //---------------------------------------------------------------------
    //way1 回溯 nums的个数有点过大 存在超时的风险
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        boolean[] used = new boolean[len];//记录当前的房子是否用过
        Deque<Integer> path = new ArrayDeque<>();//用于记录走过的路径
        dfs(nums, used, len, path, 0, len);
        return maxSum;
    }

    /**
     * way1 回溯的递归
     *
     * @param nums    金额数组
     * @param used    是否被偷
     * @param len     金额数组的大小
     * @param path    已偷金额的路径
     * @param sum     当前偷的金额和
     * @param restNum 剩下待偷的房子数量
     */
    private void dfs(int[] nums, boolean[] used, int len, Deque<Integer> path, int sum, int restNum) {
        if (restNum == 0) {
            maxSum = Math.max(maxSum, sum);
            return;
        }
        boolean originLeft = false;
        boolean originRight = false;

        //之后可以考虑首尾加入哨兵
        for (int i = 0; i < len; i++) {//2,7,9
            if (used[i]) continue;
            used[i] = true;
            restNum--;
            path.addLast(i);
            sum = sum + nums[i];//加入本次偷的金额

            //好像得记录一下下标 是否相邻的false被改变为true，而相邻的true不需要改变
            if (i == 0) {//相邻的位置设为true表示不能偷,如果首尾加入哨兵这边的代码是否能够简化
                originRight = used[i + 1];
                if (!originRight) {//如果右边的原值为true 即被访问过，则不用再-1了
                    used[i + 1] = true;
                    restNum--;
                }
            } else if (i == len - 1) {//如果左边的原值为true 即被访问过，则不用再-1了
                originLeft = used[i - 1];
                if (!originLeft) {
                    used[i - 1] = true;
                    restNum--;
                }
            } else {
                //保留左右的原值
                originRight = used[i + 1];
                originLeft = used[i - 1];
                if (!originRight) {
                    used[i + 1] = true;
                    restNum--;
                }
                if (!originLeft) {
                    used[i - 1] = true;
                    restNum--;
                }
            }
            //dfs
            dfs(nums, used, len, path, sum, restNum);

            //下面的是回溯
            used[i] = false;
            restNum++;
            //复原左右两边的访问情况
            if (i == 0) {
                if (!originRight) {//如果原来右边的房子没被访问过，used[i+1]一定被置为了true，需要复原
                    used[i + 1] = false;
                    restNum++;
                }
            } else if (i == len - 1) {
                if (!originLeft) {//如果原来左边的房子没被访问过
                    used[i - 1] = false;
                    restNum++;
                }
            } else {
                if (!originRight) {
                    used[i + 1] = false;
                    restNum++;
                }
                if (!originLeft) {
                    used[i - 1] = false;
                    restNum++;
                }
            }
            path.pollLast();
            sum -= nums[i];
        }
    }

    //---------------------------------------------------------------------
    //way2 动态规划，针对上面的回溯，子问题爆炸，指数级增长，维度超过20时，运行速度就急速降低
    //so，考虑用动态规划，自底向上解决问题
    public int rob2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[len - 1];
    }
}
