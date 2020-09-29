package A51_60.A56_Merge;

import MyUtils.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GYC
 * 2020/7/17 17:24
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 */
public class Merge {
    public static void main(String[] args) {
        int[][] M = {{2, 6}, {1, 3}, {15, 18}, {8, 10}};
        int[][] res = new Merge().merge(M);
        ArrayUtil.printArray2D(res);


    }

    //way1 按每个集合左边界的元素排序
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][2];
        }

        int l = 0;
        int r = intervals.length - 1;
        quickSort(intervals, l, r);

        //排列好的
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];

            if (merged.size() == 0 || L > merged.get(merged.size() - 1)[1]) {
                merged.add(new int[]{L, R});
            } else {
                //对于最后一个元素操作
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    //快排，按照左区间快排升序
    private void quickSort(int[][] intervals, int l, int r) {
        if (l < r) {
            int[] pivot = intervals[l];
            int tmpl = l;
            int tmpr = r;
            int[] temp;
            while (tmpl < tmpr) {
                while (tmpl < tmpr && intervals[tmpr][0] >= pivot[0]) {
                    tmpr--;
                }
                if (tmpl < tmpr) {
                    temp = intervals[tmpl];
                    intervals[tmpl] = intervals[tmpr];
                    intervals[tmpr] = temp;
                    tmpl++;
                }
                while (tmpl < tmpr && intervals[tmpl][0] <= pivot[0]) {
                    tmpl++;
                }
                if (tmpl < tmpr) {
                    temp = intervals[tmpr];
                    intervals[tmpr] = intervals[tmpl];
                    intervals[tmpl] = temp;
                    tmpr--;
                }
            }
            intervals[tmpl] = pivot;
            quickSort(intervals, l, tmpl - 1);
            quickSort(intervals, tmpl + 1, r);
        }
    }
}
