package A1_10.A7_ReverseInteger;

/**
 * Created by GYC
 * 2020/5/30 17:30
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
public class ReverseInteger {
    public static void main(String[] args) {
        int x = 0b1111_1111_1111_1111_1111_1111_1111_1110;//-1
        int y = 0b1000_0000_0000_0000_0000_0000_0000_0000;//0
//        System.out.println(x);
//        System.out.println(y);//-2147483648 -1 = -2147483649 但是整型溢出了
//        System.out.println(y-1);//2^31-1

        System.out.println(x);
        String xBin = Integer.toBinaryString(x);
        System.out.println(xBin);

        int xReverse = ~x;
        System.out.println(xReverse);
        String xRevBin = Integer.toBinaryString(xReverse);
        System.out.println(xRevBin);

    }

    public int reverse(int x) {
        return ~x;
    }

}
