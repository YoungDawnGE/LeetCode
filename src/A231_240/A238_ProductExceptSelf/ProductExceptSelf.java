package A231_240.A238_ProductExceptSelf;

import MyUtils.ArrayUtil;

/**
 * Created by GYC
 * 2020/9/14 15:02
 * 238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        new ProductExceptSelf().productExceptSelf3(nums);
    }

    //way1 L前缀之积 R后缀之积 output输出
    //时间O(N) 空间 O(2N)
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        int[] L = new int[len];//前缀
        int[] R = new int[len];//后缀
        L[0]=1;R[len-1]=1;
        //构造前 后缀
        for (int i = 1; i < len; i++) {
            L[i] = L[i - 1] * nums[i - 1];
            R[len - i - 1] = R[len - i] * nums[len - i];
        }

        //前缀*后缀=除去自身的积
        for (int i = 0; i < len; i++) {
            output[i] = L[i] * R[i];
        }
        return output;
    }

    //way2 时间O(N) 空间O(N)
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        int L = 1;
        int[] R = new int[len];//后缀
        //构造 后缀  省掉了一个N的空间
        R[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            R[len - i - 1] = R[len - i] * nums[len - i];
        }
        for (int i = 0; i < len; i++) {
            output[i] = L * R[i];
            L = L * nums[i];
        }
        return output;
    }

    //way3 时间O(N) 额外空间O(1)
    public int[] productExceptSelf3(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        int L = 1;
        //第一次 将L存入output中
        for (int i = 0; i < len; i++) {
            output[i] = L;
            L = L * nums[i];
        }
        //第二次 将R存入output中
        int R = 1;
        for (int i = 0; i < len; i++) {
            output[len - 1 - i] = R * output[len - 1 - i];
            R = R * nums[len - 1 - i];
        }
        return output;
    }
}
