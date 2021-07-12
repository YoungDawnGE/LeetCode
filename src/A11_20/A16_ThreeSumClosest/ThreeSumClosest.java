package A11_20.A16_ThreeSumClosest;

import MyUtils.ArrayUtil;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description:
 * @author: geyangchen
 * @create: 2021/7/12 10:03
 * 难度中等820收藏分享切换为英文接收动态反馈
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 提示：
 * 	• 3 <= nums.length <= 10^3
 * 	• -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 **/
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,1,55};
        int target = 3;

        ThreeSumClosest.threeSumClosest(nums, target);
        ArrayUtil.printArray(nums);
        System.out.println(ThreeSumClosest.threeSumClosest(nums, 3));
    }

    //双指针
    public static int threeSumClosest(int[] nums, int target) {
        //-1 0 1 1 55      3
        Arrays.sort(nums);
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {

            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int k = nums.length - 1;
            int j = i + 1;
            while (j < k) {
                //双指针 j k
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                }

                int abs = Math.abs(sum - target);
                if (abs < min) {
                    min = abs;
                    res = sum;
                }

                if (sum > target) {
                    //跳过相等的
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;//缩小最右边c的下标
                }
                if (sum < target) {
                    while ( j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;//扩大最左边b的下标
                }
            }
        }
        return res;
    }
}
