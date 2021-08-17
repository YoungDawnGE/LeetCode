package A0_alibaba20210723;

/**
 * @program: LeetCode
 * @description:
 * @author: geyangchen
 * @create: 2021/7/23 18:54
 *
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 *
 * 示例 2：
 * 输入：n = 13
 * 输出：6
 *
 * 提示：
 * 1 <= n < 2^31
 **/
public class Problem3 {
    public static void main(String[] args) {
        System.out.println(new Problem3().getTotalOne(13));
    }

    //way1 暴力对每个数字，每次模10
    //时间O(n*10进制平均位数)
    public int getTotalOne(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += getOne(i);
        }
        return cnt;
    }
    public int getOne(int num) {
        int cnt = 0;
        while (num != 0) {
            if (num % 10 == 1) {
                cnt++;
            }
            num /= 10;
        }
        return cnt;
    }
    //way2 找规律111000
}
