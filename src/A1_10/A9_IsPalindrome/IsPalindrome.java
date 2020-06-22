package A1_10.A9_IsPalindrome;

/**
 * Created by GYC
 * 2020/5/30 22:06
 * 9. 回文数
 * 难度简单1045收藏分享切换为英文关注反馈
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome ip = new IsPalindrome();
        int x = 2112;
        System.out.println(ip.isPalindrome_1(x));
        System.out.println(ip.isPalindrome_2(x));
        System.out.println(ip.isPalindrome_3(x));
    }

    //way1 将x反转，和A7的整数反转一样
    //9ms
    public boolean isPalindrome_1(int x) {
        int a = x;
        if (x < 0) {
            return false;
        }
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            res = res * 10 + pop;
            x /= 10;
        }
        return a == res;
    }

    //way2 但是呢 回文串12321 只需要反转末尾2位即可，比way1少了一半的时间复杂度
    //额 我这个方法用了10ms, 应该哪还需要优化
    public boolean isPalindrome_2(int x) {
        int len = 0;//定义x的位数
        int a = x;//把x临时存起来
        int b = x;
        //获得总位数
        while (a != 0) {
            a /= 10;
            len++;
        }
        int halfLen = len / 2;
        int res = 0;
        for (int i = 0; i < halfLen; i++) {
            res = res * 10 + b % 10;
            b /= 10;
        }
        //12321 len=5 halfLen=3
        return (int)(x / Math.pow(10, len - halfLen)) == res;
    }

    //way2改良 反转后的数字res > 原数的现存x , 则判断循环结束
    public boolean isPalindrome_3(int x) {
        //112210,以0结尾的直接pass，不包括 0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int res = 0;
        while (x > res) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        //前面对于基数1221，后面对于偶数121
        return x == res || x == res / 10;
}
}
