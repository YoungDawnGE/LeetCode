package A11_20.A18_FourSum;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: geyangchen
 * @create: 2021/7/12 21:58
 * 18. 四数之和
 * 难度中等896收藏分享切换为英文接收动态反馈
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 * 注意：答案中不可以包含重复的四元组。
 *
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * 输入：nums = [], target = 0
 * 输出：[]
 *
 * 提示：
 * 	• 0 <= nums.length <= 200
 * 	• -109 <= nums[i] <= 109
 * -109 <= target <= 109
 **/
public class FourSum {
    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums = {-2,-1,-1,1,1,2,2};//[[-2,-1,1,2],[-1,-1,1,1]]

        int target = 0;


        FourSum fourSum = new FourSum();

        List<List<Integer>> lists = fourSum.fourSum(nums, target);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
    //根据三数之和 搞定4数之和  -2 -1 0 0 1 2｜   -2 -1 -1 1 1 2 2
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n < 4) {
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> res = new ArrayList<>();//也可以用set进行去重
        //O(n^3)
        for (int i = 0; i < n - 3; i++) {
            // 保证和上一次枚举的元素不相等
            if ( i > 0 && nums[i] == nums[i - 1] ) {
                continue;
            }
            // 剪枝 1重循环的肯定都>target,所以break
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // 剪枝 1重循环剩下的都<target，所以continue，继续别的便利
            if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }

            for (int j = i+1; j < n - 2; j++) {
                // 保证和上一次枚举的元素不相等
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                //剪枝 剩下的都大于target 所以break掉
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                //剪枝
                if (nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) {
                    continue;
                }

                int k = j + 1;//左指针
                int l = n - 1;//右指针

                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        ArrayList<Integer> subList = new ArrayList<>();
                        //按序递增的，不会因为hashcode出现错误
                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[k]);
                        subList.add(nums[l]);
                        res.add(subList);
                        while (k < l && nums[l - 1] == nums[l]) {
                            l--;
                        }
                        l--;
                        while (k < l && nums[k + 1] == nums[k]) {
                            k++;
                        }
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return res;
    }
}

