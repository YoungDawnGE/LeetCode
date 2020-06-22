package A1_10.A4_FindMedianSortedArrays;

/**
 * Created by GYC
 * 2020/5/26 10:19
 * 4. 寻找两个正序数组的中位数
 * 难度困难2676收藏分享切换为英文关注反馈
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *  
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        FindMedianSortedArrays fmsa = new FindMedianSortedArrays();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(fmsa.findMedianSortedArrays(nums1, nums2));
    }

    /**
     * @param nums1 数组1
     * @param nums2 数组2
     * @return nums1
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //使nums1的长度更小
        if (nums1.length > nums2.length) {
            int temp[];
            temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length, n = nums2.length;
        int totalLeft = (m + n + 1) / 2;//分割线左边元素的个数

        int left = 0, right = m;
        //left==right的时候，也就是分割线找到了
        while (left < right) {
            //定义分割线
            int i = (left + right + 1) / 2;//+1的作用如果nums1只有一个元素，那么把它放分割线左边
            int j = totalLeft - i;

            //思考一下下标是否会越界i-1
            if (nums1[i - 1] > nums2[j]) {  //循环内部不会出现left==right的情况，i不可能为0，至少为1，（0+1+1）/2=1
                right = i - 1;
            }else {
                left = i;
            }
        }

        int i = left;
        int j = totalLeft - left;

        int num1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int num1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];//i等于m的时候越界，数组下标最大m-1
        int num2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int num2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        //考虑奇数偶数
        if ((m + n) % 2 == 0) {
            return (double)(Math.max(num1LeftMax, num2LeftMax) + Math.min(num1RightMin, num2RightMin)) / 2;
        }else{
            //因为定义了分割线左边所有元素比右边多一个
            return (double)Math.max(num1LeftMax, num2LeftMax);
        }
    }
}
