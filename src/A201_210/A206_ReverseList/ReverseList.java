package A201_210.A206_ReverseList;

import org.w3c.dom.ls.LSInput;

import java.util.List;

/**
 * Created by GYC
 * 2020/7/24 10:31
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class ReverseList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode res = new ReverseList().reverseList3(node1);
        while (res != null) {
            System.out.print(" " + res.val);
            res = res.next;
        }
    }
    //way1 头插法 迭代
    //读取输入的链表，并采用头插法插入新的链表
    public ListNode reverseList(ListNode head) {
        ListNode headNode = new ListNode(-1);//哨兵节点
        headNode.next = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;

            temp.next = headNode.next;
            headNode.next = temp;
        }
        return headNode.next;
    }

    //way2 双指针 迭代
    //每次将两个元素中指向右边的指针，改为指向左边。
    public ListNode reverseList2(ListNode head) {
        ListNode pre;
        pre = null;
        while (head != null) {
            ListNode tmp = head.next;//保留当前节点的next
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    //way3 双指针 递归
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
