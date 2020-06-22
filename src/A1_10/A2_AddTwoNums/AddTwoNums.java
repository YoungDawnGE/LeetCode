package A1_10.A2_AddTwoNums;

import java.util.List;

/**
 * Created by GYC
 * 2020/5/18 8:09
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        ListNode listNode = this.next;
        while (listNode != null) {
            System.out.print(listNode.val+"->");
            listNode = listNode.next;
        }

        System.out.println();
        return super.toString();
    }
}

public class AddTwoNums {
    public static void main(String[] args) {
        int []a = {3,4,6,9};//2 4 3
        int []b = {4,6,5};//5 6 4

        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(0);

        ListNode l1 = listNode1;
        ListNode l2 = listNode2;

//        不带头节点
//        头插法 数字大的在前面
        for (int i = 0; i < a.length; i++) {
            ListNode temp = new ListNode(a[i]);
            temp.next = listNode1.next;
            listNode1.next = temp;
            listNode1 = temp;
        }

        for (int i = 0; i < b.length; i++) {
            ListNode temp = new ListNode(b[i]);
            temp.next = listNode2.next;
            listNode2.next = temp;
            listNode2 = temp;
        }

        l1.toString();

        l2.toString();

        AddTwoNums addTwoNums = new AddTwoNums();
        ListNode ans = new ListNode(0);
        ans = addTwoNums.addTwoNumbers_1(l1, l2);
        ans.toString();

    }


    public ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        int carry = 0 ;
        ListNode ans = new ListNode(0);
//        把首地址先保存起来
        ListNode ansHead = ans;
        while (l1 != null && l2 != null) {
//            基数加进位
            int base = l1.val + l2.val +carry;
            ans.next= new ListNode(base % 10 );
            ans = ans.next;
            l1 = l1.next;
            l2 = l2.next;
//            计算下一次的进位
            carry = base / 10;
        }
        while (l1 != null) {
//            最后考虑1+9999的情况
            int base = l1.val + carry;
            ans.next = new ListNode(base % 10);
            carry = base / 10;
            ans = ans.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int base = l2.val + carry;
            ans.next = new ListNode(base % 10);
            carry = base / 10;
            ans = ans.next;
            l2 = l2.next;
        }
//        最后处理，99+1变成100的进位
        if (carry == 1) {
            ans.next = new ListNode(1);
        }
        return ansHead.next;
    }

}
