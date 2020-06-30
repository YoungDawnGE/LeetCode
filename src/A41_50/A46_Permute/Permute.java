package A41_50.A46_Permute;

import java.util.*;

/**
 * Created by GYC
 * 2020/6/30 10:55
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permute {
    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        List<List<Integer>> res = permute.permute(arr);
        System.out.println("共几个结果"+res.size());
        for (List<Integer> aList : res) {
            for (int val : aList) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<Integer>();//唯一的状态变量
        int depth = 0;//当前元素个数or遍历深度
        boolean[] used = new boolean[len];//记录当前的数字是否被用过默认false
        dfs(depth, nums, used, path);
        return res;
    }

    private void dfs(int depth, int[] nums, boolean[] used, Deque<Integer> path) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));//新建一个链表放进去
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(depth + 1, nums, used, path);//从return那边结束
            //下面是回溯操作
            used[i] = false;
            path.removeLast();
        }
    }
}
