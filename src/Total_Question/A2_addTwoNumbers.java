package Total_Question;

/**
 * 两数相加
 * Created by GYC
 * 2019/11/20 16:45
 */

/*给出两个 非空 的链表用来表示两个非负的整数。
其中，它们各自的位数是按照 逆序 的方式存储的，
并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class A2_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return null;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        head1.val = 0;
        ListNode head2 = new ListNode(0);

        //尾插法每次插入最后一位
        int num1 = 342;
        int num2 = 465;
        int digital;

        ListNode temp = null;
        temp = head1;
        while (num1 != 0) {
            digital = num1%10;
            num1 /= 10;
            temp.next = new ListNode(digital);
            temp = temp.next;
            temp.next = null;
        }

        while (head1.next != null) {
            System.out.print(head1.next.val+" ");
        }

//        int count1 = Integer.;
//        System.out.println(count1);
//        for (int i = 0; i < 342; i++) {
//            temp =
//            ListNode node = new ListNode();
//        }
//
//            head1.val = 2;
//
//        int len1 =


    }
}
