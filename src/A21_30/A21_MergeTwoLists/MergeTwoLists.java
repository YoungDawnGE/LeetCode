package A21_30.A21_MergeTwoLists;

import java.util.List;

/**
 * Created by GYC
 * 2020/6/23 16:08
 * 21. 合并两个有序链表
 * 难度简单1118收藏分享切换为英文关注反馈
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *  
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {this.val = val;}

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode11 = new ListNode(4);
        ListNode listNode12 = new ListNode(5);
        ListNode listNode13 = new ListNode(6);
        listNode11.next = listNode12;
        listNode12.next = listNode13;

        ListNode a = mergeTwoLists(listNode1, listNode11);

        while (a != null) {
            System.out.print(a.val+" ");
            a = a.next;
        }
    }

    //way1:最普通的方法
    public static ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        if (l1 == null)return l2;
        if (l2 == null)return l1;
        //设置一个头节点，保存起始位置
        ListNode head = new ListNode(-1);
        ListNode cur = head;//cur用于操作

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;//l2后移
            }else{
                cur.next = l1;
                l1 = l1.next;//l1后移
            }
            cur = cur.next;
        }

        if (l1 == null)cur.next = l2;
        if (l2 == null)cur.next = l1;

        return head.next;
    }


    //way2 递归
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)return l2;
        if (l2 == null)return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
