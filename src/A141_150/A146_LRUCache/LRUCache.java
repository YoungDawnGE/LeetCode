package A141_150.A146_LRUCache;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * Created by GYC
 * 2020/8/11 12:30
 * 146. LRU缓存机制
 * 难度中等806
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *  
 * 示例:
 * LRUCache cache = new LRUCache( 2 缓存容量  );
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);     // 该操作会使得关键字 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);     // 该操作会使得关键字 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 */

//我自已用hashmap和queue实现了一个
//但是这个好像有点浪费内存 HashMap的内存区域并不是固定的地方，但是cache给定一块大小的内存，就在里面put get元素
public class LRUCache {
    HashMap<Integer, Integer> map = new HashMap<>();
    Deque<Integer> queue = new ArrayDeque<>();
    int MAX_SIZE = 0;

    public LRUCache(int capacity) {
        MAX_SIZE = capacity;
    }

    public int get(int key) {
        //重新加入队列，队头的元素就是LRU的元素
        if (map.containsKey(key)) {
            queue.remove(key);
            queue.addLast(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            queue.remove(key);
            queue.addLast(key);
        } else {
            if (map.size() < MAX_SIZE) {
                map.put(key, value);
                queue.addLast(key);
            } else {
                int removeKey = queue.pollFirst();
                map.remove(removeKey);
                map.put(key, value);
                queue.addLast(key);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(3);

    }
}
