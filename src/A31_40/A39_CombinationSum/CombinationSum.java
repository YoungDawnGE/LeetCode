package A31_40.A39_CombinationSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by GYC
 * 2020/6/28 21:49
 * 39. 组合总和
 * 难度中等738收藏分享切换为英文关注反馈
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 	• 所有数字（包括 target）都是正整数。
 * 	• 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * 51 201
 */
public class CombinationSum {
    //用于存储最后的结果
    private List<List<Integer>> res = new ArrayList<>();
    //入口
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> subList = new ArrayList<>();//申请一个空的ArrayList
        divideAndConquer(candidates, target, subList);
        return res;
    }

    //分治
    public void divideAndConquer(int[] candidates, int target, List<Integer> list) {
        if (target > 0) {
            for (int i = 0; i < candidates.length; i++) {
                ArrayList<Integer> subList = new ArrayList<>(list);
                int nextTarget = target - candidates[i];
                subList.add(candidates[i]);
                divideAndConquer(candidates, nextTarget, subList);
            }
        } else if (target == 0) {
            Collections.sort(list);
            if (!res.contains(list)) {
                res.add(list);
            }
        }
        //target<0就什么都不做
    }
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        CombinationSum cs = new CombinationSum();
        List<List<Integer>> res = cs.combinationSum(candidates, target);
        System.out.println("共几个结果"+res.size());
        for (List<Integer> aList : res) {
            for (int val : aList) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
