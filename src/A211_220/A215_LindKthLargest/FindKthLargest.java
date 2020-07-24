package A211_220.A215_LindKthLargest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by GYC
 * 2020/7/23 17:10
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 6 5 5 4 3 3 2 2 1
 * 输出: 4
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] arr = {5,2,3,4,5,6,7,8,9};

        System.out.println(new FindKthLargest().findKthLargest(arr, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }

//        return heapSort(nums, k);
//        return quickSort(nums, k);
        //way3.1
        quickSort2(nums, 0, nums.length - 1, k);
        for (int a : nums) {
            System.out.print(a + " ");
        }
        return nums[k-1];
    }

    //way1 冒泡排序 57ms
    private int bubbleSort(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            for (int j = len - 1; j > i; j--) {
                if (nums[j - 1] < nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums[k-1];
    }

    //way2 选择排序 263ms
    private int selectSort(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int max = i;
            for (int j = i + 1; j < len; j++) {
                max = nums[max] < nums[j] ? j : max;
            }
            int temp = nums[i];
            nums[i] = nums[max];
            nums[max] = temp;
        }
        return nums[k - 1];
    }

    //way3 快速排序 完成排序后输出第k大 36ms
    private int quickSort(int[] nums, int k) {
        int len = nums.length;
        quickSortHelper(nums, 0, len - 1);
        return nums[k-1];
    }
    private void quickSortHelper(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = nums[left];
            int l = left;
            int r = right;

            while (l < r) {
                while (l < r && nums[r] <= pivot) {
                    r--;
                }
                if (l < r) {
                    nums[l++] = nums[r];
                }

                while (l < r && nums[l] >= pivot) {
                    l++;
                }
                if (l < r) {
                    nums[r--] = nums[l];
                }
            }
            nums[l] = pivot;
            quickSortHelper(nums, left, l - 1);
            quickSortHelper(nums, l + 1, right);
        }

    }

    //way3.1 快排的改进版本 13ms
    //没必要每次分治对左右两部分都进行快速排序，只需要快排靠近k下标的那部分
    private void quickSort2(int[] nums, int left, int right, int k) {
        if (left < right) {
            int pivot = nums[left];
            int l = left;
            int r = right;
            while (l < r) {
                while (l < r && nums[r] <= pivot) {
                    r--;
                }
                if (l < r) {
                    nums[l++] = nums[r];
                }

                while (l < r && nums[l] >= pivot) {
                    l++;
                }
                if (l < r) {
                    nums[r--] = nums[l];
                }
            }
            nums[l] = pivot;
            if (l > k-1)
                quickSort2(nums, left, l - 1, k);
            else if (l < k-1) {
                quickSort2(nums, l + 1, right, k);
            }
        }
    }



    //way4 堆排序 输出K次就行 7ms
    //手写堆排序 暂时不会
    private int heapSort(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int a : nums) {
            heap.offer(a);
        }
        int kLargest = 0;
        for (int i = 0; i < k; i++) {
            kLargest = heap.poll();
        }
        return kLargest;
    }


    //way5 插入排序不行 要全部插一遍才可以找到第K大
}
