package A121_130.A128_LongestConsecutive;

import MyUtils.ArrayUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by GYC
 * 2020/7/23 15:49
 * 128. 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class LongestConsecutive {
    public static void main(String[] args) {
//        int[] in = {9,1,4,7,3,-1,0,5,8,-1,6};
        int[] in = {3,4,5,6,7,8,9};
        Arrays.sort(in);
        ArrayUtil.printArray(in);
        System.out.println(new LongestConsecutive().longestConsecutive(in));
    }

    //利用HashSet
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len<=1) return len;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);

        }
        int maxLen = 1;
        for (int n : set) {
            if (!set.contains(n - 1)) {//这行代码用于判断是不是当前的数字是不是起点，少了这行性能下降200倍
                int temp = 0;
                int curNum = n;
                while (set.contains(curNum)) {
                    curNum += 1;
                    temp += 1;
                }
                maxLen = Math.max(temp, maxLen);
            }
        }
        return maxLen;
    }
}
