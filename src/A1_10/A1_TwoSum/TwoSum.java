package LeetCode.A1_10.A_1_TwoSum;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4};



        int target = 6;
        TwoSum twoSum = new TwoSum();
//        int[] ans = twoSum.twoSum_1(nums, target);

        int[] ans = twoSum.twoSum_3(nums, target);


        for (int a: ans) {
            System.out.print(a+" ");
        }


    }

//    way1 用两层循环
//    时间复杂度O(n^2)
//    空间复杂度O(1)
    public int[] twoSum_1(int[] nums, int target){
        if (nums.length == 0) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
//    两遍hashMap，建立与查询
//    建立k-v表
//    时间复杂度O(2n),查找的时间复杂度为O(n)
//    空间复杂度O(n)

    public int[] twoSum_2(int[] nums, int target){
        if (nums.length == 0) {
            return null;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
//        int a=5;
//        hashMap.put(a, 0);
//        System.out.println(hashMap.size());
//        System.out.println(hashMap.get(a));
//        hashMap.put(a, 1);
//        System.out.println(hashMap.size());
//        System.out.println(hashMap.get(a));
        int b;
//        nums   {3,2,4}
//        target 6
//        b      {3,4,2}  不可以取自身（每个只能取一次）
        for (int i = 0; i< nums.length;i++){
//            a + b == target
            b = target - nums[i];
//
            if (hashMap.containsKey(b) && hashMap.get(b)!=i ) {
                return new int[]{i, hashMap.get(b)};
            }
        }
        return null;
    }

//    一遍hashMap，边建立边查询
    public int[] twoSum_3(int[] nums, int target){
        if (nums.length == 0) {
            return null;
        }
        int b;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
//            先查 再put
            b = target - nums[i];
            if(hashMap.containsKey(b) && hashMap.get(b)!=i){
                return new int[]{hashMap.get(b), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }



}
