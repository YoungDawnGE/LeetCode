package A0_alibaba20210723.PDDTest20210820;

import MyUtils.ArrayUtil;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: geyangchen
 * @create: 2021/8/21 08:39
 *
 * 多多君最近在研究字符串之间的变换，可以对字符串进行若干次变换操作:
 *
 * 交换任意两个相邻的字符，代价为0。
 * 将任意一个字符a修改成字符b，代价为 |a - b|（绝对值）。
 * 现在有两个长度相同的字符串X和Y，多多君想知道，
 * 如果要将X和Y变成两个一样的字符串，需要的最少的代价之和是多少。
 *
 *
 * 输入描述:
 * 共三行，第一行，一个整数N，表示字符串的长度。
 * （1 <= N <= 2,000）
 * 接下来两行，每行分别是一个字符串，表示字符串X和Y。
 * （字符串中仅包含小写字母）
 *
 * 输出描述:
 * 共一行，一个整数，表示将X和Y变换成一样的字符串需要的最小的总代价。
 *
 * 输入例子1:
 * 4
 * abca
 * abcd
 *
 * 输出例子1:
 * 3
 *
 * 例子说明1:
 * 其中一种代价最小的变换方案：
 * 都修改为abcd，那么将第一个字符串X最后一个字符a修改为d，代价为|a - d| = 3。
 *
 * 输入例子2:
 * 4
 * baaa
 * aabb
 *
 * 输出例子2:
 * 1
 *
 * 例子说明2:
 * 其中一种代价最小的变换方案：
 * 首先将第一个字符串通过交换相邻的字符：baaa -> abaa -> aaba，代价为0。
 * 然后将第二个字符串修改最后一个字符b：|b - a| = 1。
 * 两个字符都修改为aaba，所以最小的总代价为1。
 *
 * 输入例子3:
 * 3
 * abc
 * xyz
 *
 * 输出例子3:
 * 69
 **/
public class P2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String X = sc.nextLine();
        String Y = sc.nextLine();


        System.out.println(getTotalCost(N, X, Y));
    }

    public static int getTotalCost(int N, String X, String Y) {
        char[] xch = X.toCharArray();
        char[] ych = Y.toCharArray();

        Arrays.sort(xch);
        Arrays.sort(ych);
//        ArrayUtil.printArray(xch);
//        ArrayUtil.printArray(ych);

        int totalCost = 0;

        for (int i = 0; i < N; i++) {
            totalCost += Math.abs(xch[i] - ych[i]);
        }

        return totalCost;
    }


    public static int getTotalCost2(int N, String X, String Y) {
        char[] xch = X.toCharArray();
        char[] ych = Y.toCharArray();

        Arrays.sort(xch);
        Arrays.sort(ych);
        ArrayUtil.printArray(xch);
        ArrayUtil.printArray(ych);

        int totalCost = 0;

        for (int i = 0; i < N; i++) {
            totalCost += Math.abs(xch[i] - ych[i]);
        }

        return totalCost;
    }




}
