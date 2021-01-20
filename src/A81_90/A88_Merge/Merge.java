package A81_90.A88_Merge;

/**
 * Created by GYC
 * 2021/1/18 22:56
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 有足够的空间（空间大小等于 m + n）来保存 nums2 中的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 */
public class Merge {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        new Merge().merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.println(i);
        }


    }

    //way1双指针 空间复杂度O(m+n) 时间复杂度O(m+n)
    public void merge_1(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0 || nums1.length == 0) {
            return;
        }
        int[] nums1_copy = new int[nums1.length];
        System.arraycopy(nums1, 0, nums1_copy, 0, nums1.length);

        int i = 0;//nums1
        int j = 0;//nums1_copy
        int k = 0;//nums2

        while (j < m && k < n) {
            if (nums1_copy[j] < nums2[k]) {
                nums1[i++] = nums1_copy[j++];
            } else {
                nums1[i++] = nums2[k++];
            }
        }

        if (j == m) {
            System.arraycopy(nums2, k, nums1, i, n - k);
        }
        if (k == n) {
            System.arraycopy(nums1_copy, j, nums1, i, m - j);
        }
    }

    //way2双指针从后往前 空间复杂度O(1) 时间复杂度O(m+n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0 || nums1.length == 0) {
            return;
        }
        //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        int p1 = m - 1;
        int p2 = n - 1;
        int p = nums1.length - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }
        if (p1 < 0) {
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }

}
