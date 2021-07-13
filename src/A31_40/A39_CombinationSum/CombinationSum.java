package A31_40.A39_CombinationSum;

import java.util.*;

/**
 * Created by GYC
 * 2020/6/28 21:49
 * 39. 组合总和
 * 难度中等738收藏分享切换为英文关注反馈
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的数字可以无限制重复被选取。
 * 说明：
 * 	• 所有数字（包括target）都是正整数。
 * 	• 解集不能包含重复的组合。
 * 示例1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *  [2,2,2,2],
 *  [2,3,3],
 *  [3,5]
 * ]
 * 51 201
 */
public class CombinationSum {
    //用于存储最后的结果
    private List<List<Integer>> res = new ArrayList<>();
    //way1入口
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> subList = new ArrayList<>();//申请一个空的ArrayList
        divideAndConquer(candidates, target, subList);
        return res;
    }

    //分治   way1 未优化(未剪枝)
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




    //way2 回溯，先排序+剪枝
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        //先排序，用于剪枝优化
        Arrays.sort(candidates);
        backtraceOrDfs(res, candidates, path, 0, 0, target);
        return res;
    }

    /**
     * @param res        结果集
     * @param candidates 给定的数组
     * @param path       中间结果的路径
     * @param begin      记录每层的起始点
     * @param sum        当前的和
     * @param target     目标和
     */
    public void backtraceOrDfs(List<List<Integer>> res, int[] candidates, List<Integer> path, int begin, int sum, int target) {
        //终止条件
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;//再深入下去,一定有sum>target,所以就直接return了
        }

        if (sum > target || begin > candidates.length-1) {
            return;
        }


        for (int i = begin; i < candidates.length; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            //和40题的差别就在于，39题传入下标i（表示可以复用自身）
            //40题传入下标begin+1(or idx+1，表示本层的下一个元素开始，没有复用自身)
            backtraceOrDfs(res, candidates, path, i, sum + candidates[i], target);

            path.remove(path.size() - 1);

        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        CombinationSum cs = new CombinationSum();
//        List<List<Integer>> res = cs.combinationSum(candidates, target);
        List<List<Integer>> res = cs.combinationSum2(candidates, target);
        System.out.println("共几个结果"+res.size());
        for (List<Integer> aList : res) {
            for (int val : aList) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
