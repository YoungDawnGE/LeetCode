package A141_150.A146_LRUCache;

import java.util.HashMap;

/**
 * Created by GYC
 * 2020/8/13 10:49
 * <p>
 * 在此类中，hashmap的value存的是链表节点的Value
 */
//手写双端队列
class ListNode{
    int key;
    int value;
    ListNode pre;
    ListNode next;
    ListNode(){}
    ListNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}

public class LRUCache2 {
    private HashMap<Integer, ListNode> cache = new HashMap<>();
    private int MAX_SIZE;
    private ListNode head, tail;

    public LRUCache2(int capacity) {
        MAX_SIZE = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            ListNode temp = cache.get(key);
            moveToLast(temp);
            return temp.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            ListNode temp = cache.get(key);
            temp.value = value;
            moveToLast(temp);
        } else {
            ListNode temp = new ListNode(key, value);
            if (cache.size() >= MAX_SIZE) {
                int removeKey = removeFirst().key;
                cache.remove(removeKey);
                cache.put(key, temp);
            }
            cache.put(key, temp);
            addLast(temp);
        }
    }

    private void addLast(ListNode cur) {
        cur.next = tail;
        tail.pre.next = cur;
        cur.pre = tail.pre;
        tail.pre = cur;
    }

    private ListNode removeFirst() {
        ListNode temp = head.next;
//        head.next = head.next.next;
//        head.next.next.pre = head;
        remove(temp);
        return temp;
    }

    private void remove(ListNode cur) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
    }

    private void moveToLast(ListNode cur) {
        remove(cur);
        addLast(cur);
    }

}
