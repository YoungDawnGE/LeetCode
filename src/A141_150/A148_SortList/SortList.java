package A141_150.A148_SortList;

import MyUtils.LinkedListUtil;
import MyUtils.ListNode;

/**
 * Created by GYC
 * 2020/8/5 17:31
 * 148. 排序链表
 * 难度中等668
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */

public class SortList {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        ListNode input = LinkedListUtil.getIntLinkedList(arr);
        System.out.println(new SortList().getMidNode(input).val);

        ListNode list1 = LinkedListUtil.getIntLinkedList(new int[]{2, 4, 6, 8});
        ListNode list2 = LinkedListUtil.getIntLinkedList(new int[]{1, 3, 5, 7});
        ListNode output = new SortList().mergeTwoList(list1, list2);
        LinkedListUtil.printList(output);

        ListNode input2 = LinkedListUtil.getIntLinkedList(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1});
        ListNode output2 = new SortList().sortList(input2);
        LinkedListUtil.printList(output2);

    }
    //这个题目好好思考
    public ListNode sortList(ListNode head) {
        //1、递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        //2、获得中间节点
        ListNode mid = getMidNode(head);
        ListNode rightHead = mid.next;//右半部分的头节点
        mid.next = null;//左半部分的末尾节点置为null

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        //3、合并2个节点
        return mergeTwoList(left, right);
    }

    /**
     * 双指针 获取中间节点
     * @param head 链表
     * @return 中间节点 向上取整
     */
    public ListNode getMidNode(ListNode head) {
        if (null == head) return head;

        ListNode fast = head.next;
        ListNode slow = head;

        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 合并链表
     * @param list1 第一个链表
     * @param list2 第二个链表
     * @return 合并链表
     */
    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);//哨兵
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (null==list1) cur.next = list2;
        if (null==list2) cur.next = list1;
        return head.next;
    }
}
