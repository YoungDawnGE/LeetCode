package A31_40.A31_NextPermutation;

/**
 * Created by GYC
 * 2020/6/24 14:39
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        //此时从i-1是第一次 a[i]<a[i-1]

        //从i-1之后的 找第一个比a[i-1]大的数
        if (i > 0) {//
            int j = len - 1;
            while (j > i - 1 && nums[i - 1] >= nums[j]) {
                j--;
            }
            swap(nums, i - 1, j);
        }

        reverse(nums, i, len - 1);



        //for
        /*for (int i = len - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {//找到第一个a[i-1]<a[i]的值
                for (int j = len - 1; j > i - 1; j--) {//找i-1之后恰好比a[i-1]大的数字，然后交换位置
                    if (nums[i - 1] < nums[j]) {
                        swap(nums, i - 1, j);
                        break;
                    }
                }
                //对于i-1之后的升序排序
                reverse(nums, i, len - 1);
                return;
            }
        }
        reverse(nums, 0, len - 1);*/
    }

    private void reverse(int[] nums, int start, int end) {
        int mid = (end-start) / 2;//0 1 2 3 4 5 6
        for (int i = 0; i <= mid; i++) {
            swap(nums,start+i,end-i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //快速排序呢？
    //这边用升序实现
    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int base = nums[left];//取第一个数作为基准
            int l = left;
            int r = right;

            while (l < r) {
                //从右边开始 找第一个比 base 小的元素
                while (l < r && nums[r] >= base) r--;
                if (l < r) nums[l++] = nums[r];

                //从左边开始，找第一个比 base 大的元素
                while (l < r && nums[l] < base) l++;
                if (l < r) nums[r--] = nums[l];
            }
            nums[l] = base;//最后一个空位放入基准
            quickSort(nums, left, l);
            quickSort(nums, l + 1, nums.length-1);
        }

    }

//    public static void main(String[] args) {
//        NextPermutation nextPermutation = new NextPermutation();
//        int[] arr = {20, 8, 12, 4, 1, 30, 15, 5, 6};
//        for (int i : arr) {
//            System.out.print(" " + i);
//        }
//        nextPermutation.quickSort(arr, 0, arr.length - 1);
//        System.out.println();
//        for (int i : arr) {
//            System.out.print(" " + i);
//        }
//
//    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] arr = {9,8,7,6,5,4,3,2,1};
        for (int i : arr) {
            System.out.print(" " + i);
        }
        System.out.println();
        np.nextPermutation(arr);
        for (int i : arr) {
            System.out.print(" " + i);
        }
    }

}
