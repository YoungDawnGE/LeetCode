package A41_50.A50_MyPow;

/**
 * @program: LeetCode
 * @description:
 * @author: geyangchen
 * @create: 2021/7/14 11:42
 * 50. Pow(x, n)
 * 难度中等687
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * 提示：
 * 	• -100.0 < x < 100.0
 * 	• -2^31 <= n <= 2^31-1
 * -10^4 <= x^n <= 10^4
 **/
public class MyPow {
    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double x = 0.00001;
//        int n = 10;
        int n = 2147483647/2;
        System.out.println(myPow.myPow_2(x, n));
    }

    //way1 递归 未优化
    public double absPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * myPow(x, n - 1);
    }

    public double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            return 1 / absPow(x, n);
        }
        return absPow(x, n);
    }


    //way2 快速幂（分治）+递归
    public double myPow_2(double x, int n) {
        if (n < 0) {
            n = -n;
            return 1 / myPowHelper(x, n);
        }
        return myPowHelper(x, n);
    }

    public double myPowHelper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = myPowHelper(x, n / 2);
        if (n % 2 != 0) {
            return half * half * x;
        } else {
            return half * half;
        }
    }





}
