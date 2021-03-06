package A281_290.A283_MoveZeros;

import MyUtils.ArrayUtil;

/**
 * Created by GYC
 * 2020/8/31 11:11
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] input = {2,0,0,1};
        ArrayUtil.printArray(input);
        new MoveZeros().moveZeroes(input);
        ArrayUtil.printArray(input);

    }

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int pos = 0;//用一个pos记录非0的存储到哪了
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (pos != i) {
                nums[pos] = nums[i];
                nums[i] = 0;
            }
            pos++;
        }
    }
}
