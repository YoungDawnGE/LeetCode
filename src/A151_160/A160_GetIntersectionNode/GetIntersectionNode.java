package A151_160.A160_GetIntersectionNode;

import MyUtils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by GYC
 * 2020/8/13 16:10
 * 160. 相交链表
 * 难度简单773
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 如下面的两个链表：
 *
 * 在节点 c1 开始相交。
 *  
 * 示例 1：
 * 这边示例的图片没有显示
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  
 * 示例 2：
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *  
 * 示例 3：
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *  
 * 注意：
 * 	• 如果两个链表没有交点，返回 null.
 * 	• 在返回结果后，两个链表仍须保持原有的结构。
 * 	• 可假定整个链表结构中没有循环。
 * 	• 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class GetIntersectionNode {
    //way1 走一走彼此走过的路 终将相遇 时间O(N),空间O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode head1 = headA;//哨兵节点,保留headA的值
        ListNode head2 = headB;
        while (head1 != head2) {
            head1 = head1 == null ? headB : head1.next;
            head2 = head2 == null ? headA : head2.next;
            //如果不相交，最后他们都会指向null，也会退出循环的。
        }
        return head1;
    }

    //way2 HashSet  时间O(n) 空间O(n)
    //把一个链表的所有元素都存起来，另一个链表去hashmap里取自己的元素
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}