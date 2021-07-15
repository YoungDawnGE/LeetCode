package A81_90.A86_Partition;

import MyUtils.LinkedListUtil;
import MyUtils.ListNode;

/**
 * @program: LeetCode
 * @description:
 * @author: geyangchen
 * @create: 2021/7/15 10:17
 * 86. 分隔链表
 * 难度中等423收藏分享切换为英文接收动态反馈
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 示例 1：
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 * 提示：
 * 	• 链表中节点的数目在范围 [0, 200] 内
 * 	• -100 <= Node.val <= 100
 * -200 <= x <= 200
 **/
public class Partition {
    public static void main(String[] args) {
        ListNode list = LinkedListUtil.getIntLinkedList(new int[]{1, 4, 3, 2, 5, 2});
        LinkedListUtil.printList(list);

        LinkedListUtil.printList(new Partition().partition2(list, 3));

    }

    //way2 擅用哨兵节点
    public ListNode partition2(ListNode head, int x) {
        //用于记录sentinel_1和sentinel_2链表的最后节点
        ListNode small= new ListNode(-1);//第一个头节点的位置
        ListNode large = new ListNode(-1);//第二个头节点的位置

        ListNode sentinel_1 = small;
        ListNode sentinel_2 = large;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;


        }
        small.next = sentinel_2.next;
        large.next = null;
        return sentinel_1.next;
    }

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
