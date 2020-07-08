package A0_DailyExercise.B1_DivingBoard;

import java.util.*;

/**
 * Created by GYC
 * 2020/7/8 9:05
 * 面试题 16.11. 跳水板
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 返回的长度需要从小到大排列。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 * <p>
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 */
public class DivingBoard {
    public static void main(String[] args) {
        int shorter = 1;
        int longer = 2;
        int k = 3;
        int[] res = new DivingBoard().divingBoard(shorter, longer, k);
        for (int a : res) {
            System.out.print(a + " ");
        }
    }

    //way1 利用了TreeSet 无重复
    public int[] divingBoard1(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        Set<Integer> res = new TreeSet<>();
        int temp = 0;
        for (int i = 0; i <= k; i++) {
            temp = shorter * i + longer * (k - i);
            res.add(temp);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    //way2 单独讨论 shorter==longer
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) {
            int[] res = new int[1];
            res[0] = shorter * k;
            return res;
        }
        int[] res = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            res[i] = shorter * (k - i) + longer * i;
        }
        return res;
    }
}
