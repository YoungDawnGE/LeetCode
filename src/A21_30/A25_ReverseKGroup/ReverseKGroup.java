package A21_30.A25_ReverseKGroup;

import MyUtils.LinkedListUtil;
import MyUtils.ListNode;

/**
 * Created by GYC
 * 2020/9/29 10:26
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode in = LinkedListUtil.getIntLinkedList(new int[]{1, 2, 3});
        int k = 2;
        LinkedListUtil.printList(in);
        ListNode res = new ReverseKGroup().reverseKGroup(in, k);
        LinkedListUtil.printList(res);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode sentry = new ListNode(-1);//首节点（哨兵节点）
        sentry.next = head;
        ListNode pre = sentry;
        ListNode end = sentry.next;
        while (end != null) {
            for (int i = 1; i < k; i++) {
                end = end.next;
                if (end == null) {
                    return sentry.next;
                }
            }
            ListNode[] listNodes = inverse2(pre.next, end);
            pre.next = listNodes[0];
            pre = listNodes[1];
            end = pre.next;
        }
        return sentry.next;
    }

    //逆置链表 从开头 逆置到 endNode节点
    private ListNode[] inverse2(ListNode startNode, ListNode endNode) {
        ListNode tail = startNode;//startNode逆置之后就是尾节点了，这个尾节点作为下一次循环的startNode的Pre;
        //把最后的endNode节点作为head节点
        ListNode nextNode;//记录startNode的后一个节点
        while (startNode != endNode) {
            nextNode = startNode.next;
            startNode.next = endNode.next;
            endNode.next = startNode;
            startNode = nextNode;
        }
        return new ListNode[]{endNode, tail};
    }

    //逆置链表 从开头 逆置到 endNode节点
    private ListNode[] inverse(ListNode listNode,ListNode endNode) {
        ListNode head = new ListNode(-1);//哨兵节点or头节点

        ListNode nextNode;
        //记录第一个节点,用于将未逆置的链表链接到此节点之后
        ListNode lastNode = listNode;//1、这个代码牛逼

        while (listNode != endNode) {
            nextNode = listNode.next; //先保存后一个节点
            listNode.next = head.next;//然后挂到head后面
            head.next = listNode;
            listNode = nextNode;
        }

        lastNode.next = listNode;//2、这个代码牛逼
        return new ListNode[]{head.next, lastNode};//返回第一个节点和逆置后的最后一个节点
    }



    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
