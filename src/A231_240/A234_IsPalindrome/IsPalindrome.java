package A231_240.A234_IsPalindrome;

import MyUtils.LinkedListUtil;
import MyUtils.ListNode;

/**
 * Created by GYC
 * 2020/7/28 10:30
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */

public class IsPalindrome {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,2,1};
        ListNode list1 = LinkedListUtil.getIntLinkedList(input);
        LinkedListUtil.printList(list1);

        System.out.println(new IsPalindrome().isPalindrome2(list1));
        LinkedListUtil.printList(list1);

    }
    //way1 原地反转链表，破坏了原链表，无法时间将反转后的与原链表进行比较了  O(n)√ 空间O(1)？
    public boolean isPalindrome(ListNode head) {
        ListNode first = new ListNode(-1);//哨兵
        ListNode copy = head;
        first.next = null;
        while (head != null) {
            ListNode tempNext = head.next;
            head.next = first.next;
            first.next = head;
            head = tempNext;
        }

        while (copy != null) {
            if (copy.val != first.next.val) {
                return false;
            }
            copy = copy.next;
            first = first.next;
        }


        return true;
    }

    //way1 存入数组后 双指针 左右夹紧 时间空间O(N)
    public boolean isPalindrome1(ListNode head) {
        if (head==null||head.next==null) return true;
        ListNode head1 = head;
        int len = 0;
        while (head1 != null) {
            len++;
            head1 = head1.next;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = head.val;
            head = head.next;
        }
        for (int i = 0; i < len / 2; i++) {
            if (arr[i] != arr[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    //way2 将链表的后半部分原地逆置，最后亦可将链表复原
    public boolean isPalindrome2(ListNode head) {
        if (head==null||head.next==null) return true;
        //1、寻找链表中间节点
        ListNode fast = head.next;//这一步是必要的
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2、比较左半个与右半个链表
        ListNode leftList = reverseList(slow.next);
        ListNode leftListCopy = leftList;
        ListNode rightList = head;
        while (leftList != null) {
            if (leftList.val != rightList.val) return false;
            rightList = rightList.next;
            leftList = leftList.next;
        }
        //3、操作完了可用将链表的后半部分复原
        slow.next = reverseList(leftListCopy);
        return true;
    }
    //原地反转链表，破坏结构
    public ListNode reverseList(ListNode head) {
        ListNode first = new ListNode(-1);//哨兵
        first.next = null;
        while (head != null) {
            ListNode tempNext = head.next;
            head.next = first.next;
            first.next = head;
            head = tempNext;
        }
        return first.next;
    }


}
