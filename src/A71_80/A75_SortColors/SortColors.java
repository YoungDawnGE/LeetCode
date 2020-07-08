package A71_80.A75_SortColors;

/**
 * Created by GYC
 * 2020/7/8 10:06
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class SortColors {
    public static void main(String[] args) {
//        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] nums = {2, 0, 1};
        new SortColors().sortColors2(nums);

        for (int a : nums) {
            System.out.print(a + " ");
        }
    }
    //way1 扫描两遍
    public void sortColors(int[] nums) {
        int a0 = 0;
        int a1 = 0;
//        int a2 = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                a0++;
            } else if (nums[i] == 1) {
                a1++;
            }
        }
        for (int i = 0; i < a0; i++) {
            nums[i] = 0;
        }
        for (int i = a0; i < a0 + a1; i++) {
            nums[i] = 1;
        }
        for (int i = a0 + a1; i < len; i++) {
            nums[i] = 2;
        }
    }

    //way2 双指针 一次遍历
    public void sortColors2(int[] nums) {
        int l = 0;//左边的指针 该指针左边是第最后一个0
        int r = nums.length - 1;//右边的指针，该指针右边是第一个2
        int cur = 0;//用于指向当前位置的指针
        while (cur <= r) {
            if (nums[cur] == 2) {
                nums[cur] = nums[r];
                nums[r--] = 2;
            } else if (nums[cur] == 0) {
                nums[cur++] = nums[l];
                nums[l++] = 0;
            } else {
                cur++;//是1的话就++
            }
        }
    }
}
