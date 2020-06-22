package Tencent.数组和字符串;

/*给定一个整数数组 nums 和一个目标值 target，
请你在该数组中找出和为目标值的那两个整数，
并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。*/
public class Q1_twoSumTarget {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int a[] = {i, j};
                    return a;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Q1_twoSumTarget a=new Q1_twoSumTarget();
        int []nums = {2, 7, 11, 15};
        System.out.println(a.twoSum(nums, 9)[0]+" "+a.twoSum(nums, 9)[1]);
    }
}
