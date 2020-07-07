package A81_90.A84_LargestRectangleArea;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by GYC
 * 2020/7/3 11:33
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class LargestRectangleArea {
    public static void main(String[] args) {
//        int[] arr = {2, 1, 5, 6, 2, 3};
//        int[] arr = {0,0};
        int[] arr = {2,1,2};
        System.out.println(new LargestRectangleArea().largestRectangleArea3(arr));
    }

    //way1 暴力 O(n3) 超时
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len==0) return 0;
        int maxArea = -1;
        int temp;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                temp = getArea(heights, i, j);
                maxArea = temp > maxArea ? temp : maxArea;
            }
        }
        return maxArea;
    }
    private int getArea(int[] heights, int l, int r) {
        int width = r - l + 1;
        int height = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            height = heights[i] < height ? heights[i] : height;
        }
        return height * width;
    }

    //way1.1  way1的改进版 保存一个height的最小值 当有新的柱子进来和这个最小值比较就行，而不需要每次都去比较找最小值
    public int largestRectangleArea1_1(int[] heights) {
        int len = heights.length;
        if (len==0) return 0;
        int maxArea = -1;
        int minHeight;
        int temp;
        for (int i = 0; i < len; i++) {
            minHeight = heights[i];
            for (int j = i; j < len; j++) {
                minHeight = heights[j] < minHeight ? heights[j] : minHeight;
                temp = minHeight * (j - i + 1);
                maxArea = temp > maxArea ? temp : maxArea;
            }
        }
        return maxArea;
    }

    //way2 官网的暴力，固定height，往两边扩大底部
    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        if (len==0) return 0;
        int maxArea = -1;
        int temp;
        for (int i = 0; i < len; i++) {
            int k = i;
            int j = i;
            while (k-1 >= 0 && heights[k-1] >= heights[i]) k--;
            while (j+1 < len && heights[j+1] >= heights[i]) j++;
            temp = (j - k + 1) * heights[i];
            maxArea = maxArea < temp ? temp : maxArea;
        }
        return maxArea;
    }

    //way3 单调栈
    public int largestRectangleArea3(int[] heights) {
        int len = heights.length;
        if (len==0) return 0;
        if (len==1) return heights[0];
        int[] newH = new int[len + 2];//未被赋值的地方默认是0
        //用本地方法代替人工复制数组
        System.arraycopy(heights, 0, newH, 1, len);
        len += 2;
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);//首位的哨兵
        int tempIndex;
        for (int i = 1; i < len; i++) {//0 2 1 2 0
            //非空的条件写在前面，因为peekLast()没值的时候newH会报空指针的错误，栈为空在前，就不会执行到后面了
            while (!stack.isEmpty() && newH[stack.peekLast()] > newH[i]) {
                tempIndex = stack.pollLast();
                int a = stack.peekLast();
                maxArea = Math.max(maxArea, newH[tempIndex] * (i - stack.peekLast() - 1));
            }
            stack.addLast(i);
        }
        return maxArea;
    }
}
