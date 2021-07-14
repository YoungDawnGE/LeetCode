package A61_70.A61_RotateRight;

import MyUtils.LinkedListUtil;
import MyUtils.ListNode;

/**
 * @program: LeetCode
 * @description:
 * @author: geyangchen
 * @create: 2021/7/14 14:56
 * 61. 旋转链表
 * 难度中等586
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 *
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *
 * 提示：
 * 	• 链表中节点的数目在范围 [0, 500] 内
 * 	• -100 <= Node.val <= 100
 * 	• 0 <= k <= 2 * 10^9
 **/

public class RotateRight {
    public static void main(String[] args) {
        ListNode listNode = LinkedListUtil.getIntLinkedList(new int[]{0,1,2});

        LinkedListUtil.printList(listNode);
        int k = 4;
        RotateRight instance = new RotateRight();
        LinkedListUtil.printList(instance.rotateRight(listNode, k));

    }
    public ListNode rotateRight(ListNode head, int k) {
        //0、计算节点的个数
        int n = 0;
        ListNode sentinel = new ListNode(-1, head);
        while (head != null) {
            head = head.next;
            n++;
        }
        if (n == 0) {
            return null;
        }
        k = k % n;
        return rotateRightHelper(sentinel.next, k);
    }

    //3、考虑k>N的情况（k大于节点数量的情况）
    public ListNode rotateRightHelper(ListNode head, int k) {
        //1、弄个烧饼（哨兵）节点
        ListNode sentinel = new ListNode(-1, head);

        //2、找到倒数第k个节点,快慢指针
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 最终fast指向了最后一个节点，slow指向了倒数第k个节点的前一个(看图有助于理解)
        fast.next = sentinel.next;
        sentinel.next = slow.next;
        slow.next = null;

        return sentinel.next;
        //3、考虑k>N的情况（k大于节点数量的情况）
    }
}
