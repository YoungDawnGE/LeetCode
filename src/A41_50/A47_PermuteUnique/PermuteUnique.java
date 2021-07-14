package A41_50.A47_PermuteUnique;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: geyangchen
 * @create: 2021/7/13 23:24
 *
 * 47. 全排列 II
 * 难度中等742
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 提示：
 * 	• 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 **/
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs_2(0, nums, nums.length, used, 0, path, res);
        return res;

    }

    //way2 去重优化
    /**
     * @param start 每层开始的下标
     * @param nums  传入的数组
     * @param len   数组的长度（冗余）
     * @param used  使用过的元素
     * @param depth 栈深度
     * @param path  走过的路径
     * @param res   结果集
     */
    public void dfs_2(int start ,int[] nums, int len, boolean[] used, int depth, List<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] (used[i - 1]==false) 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            dfs_2(start, nums, len, used, depth + 1, path, res);
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }


    //way1 和39题一样 但是需要去重，可以用set去重，28ms 排28%，需要优化
    /**
     * @param nums  传入的数组
     * @param len   数组的长度（冗余）
     * @param used  使用过的元素
     * @param depth 栈深度
     * @param path  走过的路径
     * @param res   结果集
     */
    public void dfs(int[] nums, int len, boolean[] used, int depth, List<Integer> path, Set<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, len, used, depth + 1, path, res);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }




    public static void main(String[] args) {
        PermuteUnique pu = new PermuteUnique();
        int[] nums = {1,2,1};
        List<List<Integer>> result = pu.permuteUnique(nums);
        System.out.println("共几个结果"+result.size());
        for (List<Integer> aList : result) {
            for (int val : aList) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
