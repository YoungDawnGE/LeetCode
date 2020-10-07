package A31_40.A40_CombinationSum2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GYC
 * 2020/10/1 10:35
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * 5 3 2 1     target 8
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {2,2,2,2,2,2};
        int target = 2;
        List<List<Integer>> result = new CombinationSum2().combinationSum2(candidates, target);
        System.out.println("共几个结果"+result.size());
        for (List<Integer> aList : result) {
            for (int val : aList) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }


    //way1  我第一次用回溯 存在一个问题就是 无法去重
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        boolean[] used = new boolean[len];
        List<Integer> sub = new ArrayList<>();
        backtrack(candidates, target, len, used, 0, sub, 0);
        return res;
    }

    /**
     * 所需传入的状态遍量
     *
     * @param can    数组
     * @param target 目标和
     * @param len    数组大小
     * @param used   记录数字的使用情况
     * @param depth  已经使用的数量
     * @param sub    子结果
     * @param sum    当前的和
     */
    private void backtrack(int[] can, int target, int len, boolean[] used, int depth, List<Integer> sub, int sum) {
        if (sum == target) {
            //草这边得新建一个ArrayList<Integer> sub，否则res里面的引用全指向同一个sub，导致最后的sub都被清空了。
            ArrayList<Integer> newSub = new ArrayList<>(sub);
            res.add(newSub);
            return;
        }
        if (sum > target || depth == target) {
            return;
        }
        for (int i =0; i < len; i++) {
            if (used[i]) break;
            used[i] = true;
            sub.add(can[i]);

            backtrack(can, target, len, used, depth + 1, sub, sum + can[i]);

            sub.remove(depth);
            used[i] = false;
        }
    }

    //way2 官网解法

}
