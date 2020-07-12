package A61_70.A66_PlusOne;

/**
 * Created by GYC
 * 2020/7/8 21:43
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] arr = {8,9,4,5,0,0,7,9};
        int[] res = new PlusOne().plusOne(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
    public int[] plusOne(int[] digits) {
        int len = digits.length;

        if (digits[len - 1] + 1 <= 9) {
            digits[len - 1] += 1;
            return digits;
        }
        int carry = 1;
        digits[len - 1] = 0;
        //999
        for (int i = len - 2; i >= 0; i--) {
            if (digits[i] + carry >= 10) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] += carry;
                carry = 0;
            }
        }

        if (carry == 1) {
            int[] res = new int[len + 1];
            System.arraycopy(digits, 0, res, 1, len);
            res[0] = carry;
            return res;
        }
        return digits;
    }
}
