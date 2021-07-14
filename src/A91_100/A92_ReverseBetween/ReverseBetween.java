package A91_100.A92_ReverseBetween;

import MyUtils.LinkedListUtil;
import MyUtils.ListNode;

/**
 * @program: LeetCode
 * @description:
 * @author: geyangchen
 * @create: 2021/7/14 21:21
 * 92. 反转链表 II
 * 难度中等950收藏分享切换为英文接收动态反馈
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 * 提示：
 * 	• 链表中节点数目为 n
 * 	• 1 <= n <= 500
 * 	• -500 <= Node.val <= 500
 * 	• 1 <= left <= right <= n
 **/
public class ReverseBetween {
    public static void main(String[] args) {
        ListNode list = LinkedListUtil.getIntLinkedList(new int[]{1, 2, 3, 4, 5});

        LinkedListUtil.printList(list);
        ReverseBetween ins = new ReverseBetween();
        int left = 2;
        int right = 4;
        LinkedListUtil.printList(ins.reverseBetween(list, left, right));

    }
    //way1 一次扫描  sentinel -> 1 2 3 4 5 (left 2, right 4)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode first = sentinel;

        //找到第left节点前一个节点first 1
        for (int i = 0; i < left - 1; i++) {
            first = first.next;
        }

        //重新弄个新的链表头
        ListNode tempSentinel = new ListNode(-1);
        //记录最先插入表头的节点，它最后会排在这个临时链表的最后
        ListNode tempLast = first.next;

        //再往后找到right节点，找第过程中头插逆置
        ListNode curNode;//当前第节点
        ListNode nextNode;//当前第节点后一个节点

        curNode = first.next;

        for (int i = 0; i < right - left + 1; i++) {
            nextNode = curNode.next;

            curNode.next = tempSentinel.next;
            tempSentinel.next = curNode;

            curNode = nextNode;
        }
        first.next = tempSentinel.next;
        tempLast.next = curNode;
        return sentinel.next;
    }
}
