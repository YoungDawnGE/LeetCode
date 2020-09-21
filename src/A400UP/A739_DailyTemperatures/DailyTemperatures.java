package A400UP.A739_DailyTemperatures;

import MyUtils.ArrayUtil;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by GYC
 * 2020/8/14 14:33
 * 739. 每日温度
 * 难度中等468
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：
 * 要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] in = {73, 74, 75, 71, 69, 72, 76, 73};
        ArrayUtil.printArray(new DailyTemperatures().dailyTemperatures2(in));

    }

    //way1 暴力O(n2)
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        if (len == 0) return null;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    //[73, 74, 75, 71, 69, 68, 72, 73]
    //way2 单调递减栈
    public int[] dailyTemperatures2(int[] T) {
        int len = T.length;
        if (len == 0) return null;
        int[] res = new int[len];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && T[stack.peekLast()] < T[i]) {
                res[stack.peekLast()] = i - stack.pollLast();
            }
            stack.addLast(i);
        }
        return res;
    }

    //way3 最牛逼
    public int[] dailyTemperatures3(int[] T) {
        int[] res = new int[T.length];
        //从后面开始查找
        for (int i = res.length - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < res.length) {
                if (T[j] > T[i]) {
                    //如果找到就停止while循环
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    //如果没找到，并且res[j]==0。说明第j个元素后面没有
                    //比第j个元素大的值，因为这一步是第i个元素大于第j个元素的值，
                    //那么很明显这后面就更没有大于第i个元素的值。直接终止while循环。
                    break;
                } else {
                    //如果没找到，并且res[j]！=0说明第j个元素后面有比第j个元素大的值，
                    //然后我们让j往后挪res[j]个单位，找到那个值，再和第i个元素比较
                    j += res[j];
                }
            }
        }
        return res;
    }
}

