package A161_170.A169_MajorityElement;

/**
 * Created by GYC
 * 2020/8/5 16:20
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {
    public static void main(String[] args) {
//        int[] arr = {3, 2, 3};
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
//        int[] arr = {6, 5, 5};
//        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new MajorityElement().majorityElement(arr));

    }

    //way1 moore投票
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int cur = nums[0];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (count == 0) {
                cur = nums[i];
            }
            if (cur == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return cur;
    }
    //way1.1 moore投票 代码优化
    public int majorityElement2(int[] nums) {
        int len = nums.length;
        int cur = nums[0];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (count == 0) {
                cur = nums[i];
            }
            count += (cur == nums[i]) ? 1 : -1;
        }
        return cur;
    }

}
