package Tencent.数组和字符串;

/**
 * Created by Ge YangChen
 * 2019/10/20 11:54
 * 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */

/*从两遍往中间找，如果height比之前的height还小就不予考虑，area记录最大的容积*/
public class Q10_minArea {
    public int minArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area;
        area = Math.min(height[left], height[right])  * (right - left);
        while (left < right) {
            if (height[left] > height[right]) {
                right--;
            } else left++;
            area = area>Math.min(height[left], height[right])  * (right - left)? area : Math.min(height[left], height[right])  * (right - left);
        }
        return area;
    }


    public static void main(String[] args) {
        Q10_minArea a = new Q10_minArea();
        int []nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(a.minArea(nums));

    }
}
