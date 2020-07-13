package A71_80.A78_Subsets;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by GYC
 * 2020/7/12 22:50
 * 78. 子集
 * 难度中等645
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> output = new Subsets().subsets3_1(arr);
        for (List<Integer> aList : output) {
            for (int val : aList) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    private static List<List<Integer>> res = new ArrayList<>();

    //way1 递归
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());//[]
        for (int num : nums) {
            List<List<Integer>> tempSet = new ArrayList<>();
            for (List<Integer> list : output) {//[] 1 2 12
                tempSet.add(new ArrayList<Integer>(list){{add(num);}});
//                tempSet.add(num);//这个步骤对原来的output的元素进行了操作 与下面的冲突
            }
            output.addAll(tempSet);
        }
        return output;
    }

    // way2 回溯
    // 一般用回溯的时候，都把要返回的结果集作为一个成员变量 而非局部变量
    public List<List<Integer>> subsets2(int[] nums) {
        int len = nums.length;
        Deque<Integer> path = new ArrayDeque<>();//全局只用一个状态变量
        res.add(new ArrayList<>());
        int curInd = 0;

        for (int i = 0; i < len; i++) {
            backtrack(i, path, nums, len);
        }
        return res;
    }

    /**
     * @param curInd 记录当前访问到的元素
     * @param path   一个栈 用于加、弹出元素
     * @param nums   数组
     * @param len    数组长度
     */
    private void backtrack(int curInd, Deque<Integer> path, int[] nums, int len) {
        if (curInd == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = curInd; i < len; i++) {
            path.addLast(nums[curInd]);
            backtrack(i + 1, path, nums, len);
            path.removeLast();
        }
    }

    // way3 利用bitmap 进行字典排序
    //0表示该数字作为子集，1表示该数字不作为子集
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int len = nums.length;
        int bitHelp = 1 << len;
        String bitMask;
        for (int i = 0; i < (int) Math.pow(2, len); i++) {
            bitMask = Integer.toBinaryString(bitHelp | i).substring(1);
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < bitMask.length(); j++) {
                if (bitMask.substring(j,j+1).equals("1")) temp.add(nums[j]);
            }
            output.add(temp);
        }
        return output;
    }

    // way3.1 不用转化为字符串，直接可以用数字进行运算
    public List<List<Integer>> subsets3_1(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < (int) Math.pow(2, len); i++) {
            List<Integer> temp = new ArrayList<>();
            int a = i;
            for (int j = 0; j < nums.length; j++) {
                if (a % 2 == 1) temp.add(nums[j]);
                a >>= 1;
            }
            output.add(temp);
        }
        return output;
    }


}
