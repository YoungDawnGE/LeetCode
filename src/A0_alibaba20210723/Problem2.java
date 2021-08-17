package A0_alibaba20210723;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: geyangchen
 * @create: 2021/7/23 18:49
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 *
 * 提示：
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 **/
public class Problem2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem2().getSmallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 8)));
    }

    //利用快排的结构
    public int[] getSmallestK(int[] nums, int k) {
        if (null == nums || nums.length == 0) {
            return new int[]{};
        }
        int[] res = new int[k];
        quickSort(nums, 0, nums.length - 1, k);
        System.arraycopy(nums, 0, res, 0, k);
        return res;
    }

    public static void quickSort(int[] array, int left, int right, int k) {
        int l = left;
        int r = right;

        if (l < r) {
            int pivot = array[left];
            while (l < r) {
                while (l < r && array[r] >= pivot) {
                    r--;
                }
                if (l < r) {
                    array[l++] = array[r];
                }
                while (l < r && array[l] <= pivot) {
                    l++;
                }
                if (l < r) {
                    array[r--] = array[l];
                }
            }
            array[l] = pivot;

            if (l > k) {
                quickSort(array, left, l - 1, k);
            } else {
                quickSort(array, l + 1, right, k);
            }
        }
    }
}
