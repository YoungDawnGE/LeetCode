package A00_FA;

/**
 * Created by GYC
 * 2020/12/28 0:28
 * 快排、 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] array = {5,4,2,69,10,10,2131,331,3,20,14,4354,345,332,13,4,1432,22,456,147,976};
        for (int k : array) {
            System.out.print(" " + k);
        }
        System.out.println();
//        quickSort(array, 0, array.length-1);
        quickSort_20210818(0, array.length - 1, array);
        for (int j : array) {
            System.out.print(" " + j);
        }
        System.out.println();


    }

    public static void quickSort(int[] array, int left, int right){
        int l = left;
        int r = right;

        if(l < r){
            int pivot = array[left];
            while (l < r) {
                while (l < r && array[r] >= pivot) {
                    r--;
                }
                if (l < r) {
                    array[l++] = array[r];
                }
                while (l < r && array[l] <= pivot) {
                    l++;
                }
                if (l < r) {
                    array[r--] = array[l];
                }
            }
            array[l] = pivot;
            quickSort(array, left, l-1);
            quickSort(array, l+1, right);
        }


    }
    public void swap(int i,int j, int[] array){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void quickSort_20210818(int left, int right, int[] nums) {
        int l = left;
        int r = right;

        if (l < r) {
            int pivot = nums[l];
            while (l < r) {
                while (l < r && nums[r] > pivot) {
                    r--;
                }
                if (l < r) {
                    nums[l++] = nums[r];
                }

                while (l < r && nums[l] <= pivot) {
                    l++;
                }
                if (l < r) {
                    nums[r--] = nums[l];
                }
            }
            nums[l] = pivot;
            quickSort_20210818(left, l - 1, nums);
            quickSort_20210818(l + 1, right, nums);
        }
    }
}