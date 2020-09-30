package A41_50.A41_FirstMissingPositive;

/**
 * Created by GYC
 * 2020/9/30 9:22
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 *
 * 提示：
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] in = {3,4,-1,1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(in));

    }

    //首先缺失的数字一定在[1,1+N]
    //way1 原地哈希，利用原nums数组存储有用的信息，比如将nums[i]置负，表示 i+1存在于nums[]
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 1;
        }

        //先数据处理 把<=0的和>N+1的都设为一个固定的数字
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len+1) {
                nums[i] = len+1 ;
            }
        }
        //在原数组上记录信息
        for (int i = 0; i < len; i++) {
            if (Math.abs(nums[i]) <= len) {
                nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
            }
        }
        //寻找第一个正数
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return len + 1;
    }

    public void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }


    //way2 置换
    public int firstMissingPositive2(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        //2  1  4  5  6
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                int k = nums[i] - 1;//下标
                swap(nums, i, k);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length;
    }


}
