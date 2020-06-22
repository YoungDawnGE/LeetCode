package Tencent.数组和字符串;

/**
 * Created by Ge YangChen
 * 2019/10/18 11:42
 * 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：['h','e','l','l','o']
 * 输出：['o','l','l','e','h']
 * 示例 2：
 *
 * 输入：['H','a','n','n','a','h']
 * 输出：['h','a','n','n','a','H']
 */
/*len/2*/
public class Q12_reverseString {
    public void reverseString(char[] s) {
        int len = s.length;
        char temp;
        for (int i = 0; i < len/2; i++) {
            temp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = temp;
        }

    }

    public static void main(String[] args) {
        Q12_reverseString a = new Q12_reverseString();
        char[] c = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (char c1 : c) {
            System.out.print(c1+" ");
        }
        System.out.println();
        a.reverseString(c);
        for (char c1 : c) {
            System.out.print(c1+" ");
        }
    }
}
