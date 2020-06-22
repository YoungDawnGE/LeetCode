package A11_20.A15_ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by GYC
 * 2020/6/12 8:47
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum ts = new ThreeSum();

        List<List<Integer>> list = ts.threeSum_2(nums);

        for (List<Integer> aList : list) {
            for (int val : aList) {
                System.out.print(val + " ");
            }
            System.out.println();
        }


    }

    //way1 暴力解法 超时
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> subList;//记录每次的子结果
        List<List<Integer>> result = new ArrayList<>();//把成功的子结果添加到这个里面
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                int[] arr = new int[3];
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {

                        subList = new ArrayList<>();
                        arr[0] = nums[i];
                        arr[1] = nums[j];
                        arr[2] = nums[k];
                        Arrays.sort(arr);

                        //TODO 判断重复
                        subList.add(arr[0]);
                        subList.add(arr[1]);
                        subList.add(arr[2]);
                        //把里面的元素拿出来
                        //利用hashCode
                        if (!result.contains(subList)) {
                            result.add(subList);
                        }
                        //暴力搜素查重
//                        boolean flag = false;
//                        for (List<Integer> aList : result) {
//                            if (aList.get(0) != arr[0]) {
//                                continue;
//                            } else if (aList.get(1) != arr[1]) {
//                                continue;
//                            } else if (aList.get(2) != arr[2]) {
//                                continue;
//                            }
//                            flag = true;
//                        }
//                        if (!flag) {
//                            result.add(subList);
//                        }

                    }
                }
            }
        }
        return result;
    }

    //way2 双指针
    public List<List<Integer>> threeSum_2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> subList;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        //这样做的话一定是有序的
        for (int i = 0; i < len-2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int target = -nums[i];
            int j = i + 1;//首指针
            int k = len - 1;//尾指针

            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    subList = new ArrayList<>();
                    subList.add(nums[i]);
                    subList.add(nums[j]);
                    subList.add(nums[k]);
                    res.add(subList);
                    j++;
                    k--;
                    while (nums[j] == nums[j - 1] && j < len - 1) j++;
                    while (nums[k] == nums[k + 1] && k > j) k--;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
