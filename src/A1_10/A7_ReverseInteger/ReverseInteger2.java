package A1_10.A7_ReverseInteger;

/**
 * Created by GYC
 * 2020/5/30 18:17
 * 7. 整数反转
 * 难度简单1912收藏分享切换为英文关注反馈
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，
 * 则其数值范围为 [−2^31,  2^31 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ReverseInteger2 {
    public static void main(String[] args) {
        int a = -2147483412;
        ReverseInteger2 ri = new ReverseInteger2();
        System.out.println(ri.reverse(a));

        System.out.println(Integer.MAX_VALUE);
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&pop>7)) return 0;
            if(res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&pop<-8)) return 0;
            res = res * 10 + pop;
        }
        return res;
    }
}
