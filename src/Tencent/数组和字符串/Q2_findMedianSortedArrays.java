package Tencent.数组和字符串;
/*
找2个有序数组中位数
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。
nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0

*/
public class Q2_findMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0){
            return nums2.length % 2 == 0 ? (double) (nums2[nums2.length/2]+nums2[nums2.length /2-1])/2 : nums2[nums2.length /2];
        }
        if (nums2.length == 0){
            return nums1.length % 2 == 0 ? (double) (nums1[nums1.length/2]+nums1[nums1.length /2-1])/2 : nums1[nums1.length /2];
        }
        int size = nums1.length + nums2.length;
        int[] temp = new int[size];
        int i=0, j = 0;
        for (int k = 0; k < size; k++) {
            if(nums1[i]<=nums2[j]){
                temp[k] = nums1[i];
                i++;
            }else {
                temp[k] = nums2[j];
                j++;
            }

            if (i >= nums1.length) {
                for (int l = k + 1; j<nums2.length; l++,j++) {
                    temp[l] = nums2[j];
                }
                break;
            }
            if (j >= nums2.length) {
                for (int l = k + 1; i<nums1.length; l++,i++) {
                    temp[l] = nums1[i];
                }
                break;
            }
        }
        return size % 2 == 0 ? (double) (temp[size/2]+temp[size/2-1])/2 : temp[size/2];
    }


    public static void main(String[] args) {
        Q2_findMedianSortedArrays a = new Q2_findMedianSortedArrays();
        int[] nums1 = {0,2,3,4};
        int[] nums2 = {1,3,4,5,9};
        System.out.println(a.findMedianSortedArrays(nums1, nums2));
    }
}
