package Tencent.数组和字符串;

import java.util.List;

/**
 * Created by Ge YangChen
 * 2019/10/18 11:37
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Q6 {
    public List<List<Integer>> threeSum(int[] nums) {

        return null;

    }

    public void quickSort(int[] nums, int left, int right) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        int pivot = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] > pivot) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] < pivot) {
                i++;
            }
            nums[j] = nums[i];


        }
        nums[i] = pivot;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    public static void main(String[] args) {
        Q6 a = new Q6();

        int[] nums = {1, 9, 10, 5, 3, 6, 8, 7, 2, 4};

        a.quickSort(nums,0,nums.length-1);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
