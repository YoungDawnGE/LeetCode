package A141_150.A141_HasCycle;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by GYC
 * 2020/8/4 14:57
 * 141. 环形链表
 * 难度简单699
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class HasCycle {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node2;

        System.out.println(new HasCycle().hasCycle2(node1));
    }

    //way1 hash缓存 用set
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        boolean isCycle = false;
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    //way2 快慢指针
    public boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
