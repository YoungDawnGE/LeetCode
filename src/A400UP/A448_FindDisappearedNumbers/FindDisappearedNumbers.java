package A400UP.A448_FindDisappearedNumbers;

import MyUtils.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GYC
 * 2020/9/22 16:44
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，
 * 数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 */
public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] in = {4, 3, 2, 7, 8, 2, 3, 1};

        ArrayUtil.printArray(in);
        List<Integer> ans = new FindDisappearedNumbers().findDisappearedNumbers3(in);
        System.out.println(ans.toString());
    }

    //way1 用到了额外空间O(n)
    private List<Integer> res = new ArrayList<>();
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len + 1];
        for (int i = 0; i < len; i++) {
            temp[nums[i]]++;
        }
        for (int i = 1; i <= len; i++) {
            if (temp[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }

    //way2 空间O(1) 时间O(n) 在原数组中存储有用的信息
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[Math.abs(nums[i]) - 1] = Math.abs(nums[Math.abs(nums[i]) - 1]) * -1;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        ArrayUtil.printArray(nums);
        return res;
    }
    //way3 way2的代码优化
    public List<Integer> findDisappearedNumbers3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
