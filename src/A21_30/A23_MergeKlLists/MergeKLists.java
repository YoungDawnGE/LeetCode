package A21_30.A23_MergeKlLists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by GYC
 * 2020/6/23 17:35
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class MergeKLists {

    //way1 非递归 每次去一个最小的插入
    public static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        //每次找一个最小的
        ListNode head = new ListNode(-1);
        ListNode current = head;
        ListNode tempNode;

        //如果lists里面每个都为空，那么循环结束
        int flag = 0;//记录为空的数量
        while (flag < len) {
            flag = 0;
            tempNode = new ListNode(Integer.MAX_VALUE);//用于比较大小的
            int temp = 0;//用于记录每次最小的元素
            for (int i = 0; i < len; i++) {
                if (lists[i] == null) {
                    flag++;
                    continue;
                }
                //如果lists[i]不空
                if (lists[i].val < tempNode.val) {
                    //用于存每次最小的
                    temp = i;
                    tempNode = lists[i];
                }

            }
            if (flag < len) {//加这一步是为了防止插入，ListNode(Integer.MAX_VALUE)
                current.next = tempNode;//存入最小的元素
                current = current.next;//后移
                if (lists[temp] != null) {
                    lists[temp] = lists[temp].next;//更改lists数组
                }
            }
        }
        return head.next;
    }

    //way2 利用PriorityQueue 比way1好
    public static ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing((ListNode node)->node.val));
        ListNode head = new ListNode(-1);//dummy node
        ListNode cur = head;//用于存储当前的节点
        ListNode temp;//临时变量
        for (ListNode node : lists) {
            if (node!=null) pq.offer(node);//先把所有的元素加进去
        }
        while (pq.size() != 0) {
            temp = pq.poll();
            cur.next = temp;
            cur = cur.next;
            if (temp.next != null) pq.offer(temp.next);//PriorityQueue不能插入null
        }
        return head.next;
    }

    //way3 分治，每次合并两个链表 利用了MergeTwoLists
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists.length == 0 || lists == null) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        int interval = 1;//设置间隔

        while (interval <= lists.length) {
            for (int i = 0; i < lists.length-interval; i += interval) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
                interval *= 2;
            }
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //合并2个链表的操作
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if (l1 == null) cur.next = l2;
        if (l2 == null) cur.next = l1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(3);
        ListNode listNode13 = new ListNode(4);
        ListNode listNode14 = new ListNode(20);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;

        ListNode listNode111 = new ListNode(2);
        ListNode listNode112 = new ListNode(6);
        listNode111.next = listNode112;


        ListNode[] lists = {listNode1, listNode11, listNode111};
//        ListNode[] lists = {listNode1, listNode111};
        ListNode a = new MergeKLists().mergeKLists3(lists);

        while (a != null) {
            System.out.print(a.val+" ");
            a = a.next;
        }
    }
}
