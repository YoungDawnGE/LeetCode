package MyUtils;

/**
 * Created by GYC
 * 2020/8/6 12:05
 */

public class LinkedListUtil {
    public static ListNode getIntList(int[] arr) {
        ListNode head = new ListNode(-1);//哨兵
        ListNode cur = head;
        ListNode temp;

        for (int v : arr) {
            temp = new ListNode(v);
            cur.next = temp;
            cur = cur.next;
        }
        cur.next = null;
        return head.next;
    }
}
