package A201_210.A201_RangeBitwiseAnd;

/**
 * Created by GYC
 * 2021/1/11 21:19
 * 201. 数字范围按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1:
 *
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 *
 * 输入: [0,1]
 * 输出: 0
 */
public class RangeBitwiseAnd {
    public static void main(String[] args) {

    }
    //way1 brute
    public int rangeBitwiseAnd_1(int m, int n) {
        int res = m;
        for (int i = m + 1; i <= n; i++) {
            res = res & i;
        }
        return res;
    }
    //way2 即看起始数字和结束数字的公共前缀
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            i++;
        }
        return m << i;
    }
}
