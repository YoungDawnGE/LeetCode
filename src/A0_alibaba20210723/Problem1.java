package A0_alibaba20210723;

/**
 * @program: LeetCode
 * @description:
 * @author: geyangchen
 * @create: 2021/7/23 18:20
 *
 * 笔试题01
 * 给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
 *
 * 示例 1：
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 *
 * 示例 2：
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *
 * 提示:
 * 给定的整数 num 保证在 32 位带符号整数的范围内。
 * num >= 1
 * 你可以假定二进制数不包含前导零位。
 **/
public class Problem1 {
    public static void main(String[] args) {
        System.out.println(new Problem1().getRevertNum(1));
    }

    //时间O(N),N为num的二进制位数
    public int getRevertNum(int num) {
        //1、获得位数
        int cnt = 0;
        int temp = num;
        while (temp != 0) {
            temp = temp >> 1;
            cnt++;
        }
        //2、1010+0101=1111    2^n-1-num = result
        return (int)Math.pow(2, cnt) - 1 - num;
    }

}
