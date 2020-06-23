package A21_30.A23_MergeKlLists;

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length <= 2) {
            return mergeKLists(lists);
        }
        if ()
    }
}
