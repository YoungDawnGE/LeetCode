package A400UP.A461_HammingDistance;

/**
 * Created by GYC
 * 2020/8/17 16:21
 * 461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance(1,4));
    }

    //way1 先异或运算 + 计算二进制中1的个数(x&x-1)
    public int hammingDistance(int x, int y) {
        return countBit(x ^ y);
    }

    private int countBit(int x) {
        int count = 0;
        while (x != 0) {
            x &= (x - 1);
            count++;
        }
        return count;
    }

    //way2 每次比较最后两位
    public int hammingDistance2(int x, int y) {
        //2^8=256
        int distance = 0;
        for (int i = 0; i < 8; i++) {

        }
        return distance;
    }
}
