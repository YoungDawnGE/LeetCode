package A341_350.A347_TopKFrequent;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by GYC
 * 2020/7/27 9:00
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int[] res = new TopKFrequent().topKFrequent(arr, 3);

        for (int e : res) {
            System.out.print(e + " ");
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] topK = new int[k];
        //hashmap记录频率
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int elem : nums) {
            if (map.containsKey(elem)) {
                map.put(elem, map.get(elem) + 1);
            } else {
                map.put(elem, 1);
            }
        }
        //堆 输出topK
        PriorityQueue<HashMap.Entry<Integer, Integer>> heap = new PriorityQueue<>(((o1, o2) -> o2.getValue() - o1.getValue()));
        heap.addAll(map.entrySet());

        for (int i = 0; i < k; i++) {
            topK[i] = heap.poll().getKey();
        }

        map.entrySet().forEach(heap::offer);
        return topK;
    }
}
