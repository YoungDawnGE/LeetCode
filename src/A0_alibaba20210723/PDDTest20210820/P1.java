package A0_alibaba20210723.PDDTest20210820;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: geyangchen
 * @create: 2021/8/20 22:04
 * [编程题]多多的数字组合
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 256M，其他语言512M
 *
 * 多多君最近在研究某种数字组合：
 * 定义为：每个数字的十进制表示中(0~9)，每个数位各不相同且各个数位之和等于N。
 * 满足条件的数字可能很多，找到其中的最小值即可。
 * 多多君还有很多研究课题，于是多多君找到了你--未来的计算机科学家寻求帮助。
 *
 * 输入描述:
 * 共一行，一个正整数N，如题意所示，表示组合中数字不同数位之和。
 * （1 <= N <= 1,000）
 *
 * 输出描述:
 * 共一行，一个整数，表示该组合中的最小值。
 * 如果组合中没有任何符合条件的数字，那么输出-1即可。
 *
 * 输入例子1:
 * 5
 *
 * 输出例子1:
 * 5
 *
 * 例子说明1:
 * 符合条件的数字有：5，14，23，32，41
 * 其中最小值为5
 *
 * 输入例子2:
 * 12
 *
 * 输出例子2:
 * 39
 *
 * 例子说明2:
 *
 *
 * 输入例子3:
 * 50
 *
 * 输出例子3:
 * -1
 *
 * 例子说明3:
 * 没有符合条件的数字 (Ｔ▽Ｔ)
 **/
public class P1 {
    private static List<List<Integer>> ans = new ArrayList<>();
    private static int smallestNodeNums = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> subList = new ArrayList<>();
        boolean[] used = new boolean[10];//false


        backTrace(subList, N, 9, used);
        int min = Integer.MAX_VALUE;

        if (ans.size() == 0) {
            System.out.println(-1);
            return;
        }


        for (List<Integer> list : ans) {
            if (list.size() != smallestNodeNums) {
                break;
            }
            Collections.sort(list);
            int temp;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
            }
            temp = Integer.parseInt(sb.toString());
            min = Math.min(min, temp);
        }
        System.out.println(min);

        //复原
//        ans = new ArrayList<>();
//        smallestNodeNums = Integer.MAX_VALUE;
    }

    // ans 保留答案
    // leftNum 剩余数字
    // node Num 节点的数量
    public static void backTrace(List<Integer> path, int leftNum, int startNum,boolean[] used) {
        if (leftNum < 0) {
            return;
        }
        if (leftNum == 0) {
            if (smallestNodeNums >= path.size()) {
                ans.add(new ArrayList<>(path));
                smallestNodeNums = path.size();
            }
        }

        for (int i = startNum; i >=1 ; i--) {
            if (path.size() > smallestNodeNums) {
                break;
            }

            if (used[i]) {
                break;
            }

            used[i] = true;
            path.add(i);
            backTrace(path, leftNum - i, startNum - 1, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
