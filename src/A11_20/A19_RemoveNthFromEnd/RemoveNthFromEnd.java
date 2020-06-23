package A11_20.A19_RemoveNthFromEnd;

/**
 * Created by GYC
 * 2020/6/23 14:11
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode start = new ListNode(0);
        ListNode listNode1= new ListNode(1);
        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//
//        listNode4.next = listNode5;
//        listNode3.next = listNode4;
//        listNode2.next = listNode3;
        listNode1.next = listNode2;
        start.next = listNode1;

        ListNode a = removeNthFromEnd(start.next, 2);

        while (a != null) {
            System.out.print(a.val+" ");
            a = a.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //这边赋值是传递的引用的值，但是没有对于对象操作，只是遍历，不碍事
        ListNode start = new ListNode(0);//自定义一个头节点
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;
        while (n > 0) {
            fast = fast.next;//快指针先走
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;//快指针
            slow = slow.next;//慢指针随后
        }
        slow.next = slow.next.next;
        return start.next;
    }
}
