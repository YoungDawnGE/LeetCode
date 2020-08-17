package A391_400.A394_DecodeString;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by GYC
 * 2020/8/14 16:27
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
public class DecodeString {
    public static void main(String[] args) {
        String input = "100[a]2[bc]";
        System.out.println(new DecodeString().decodeString(input));
    }

    //way1 基于栈的实现 暂时没优化
    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (chars[i] == ']') {
                String temp = "";
                //将 [ 之前的都出栈
                while (!stack.peekLast().equals("[")) {
                    temp = stack.pollLast() + temp;
                }
                //将"["出栈
                stack.pollLast();
                //将数字出栈
                char digit = stack.peekLast().toCharArray()[0];
                int m = 1;
                int k = 0;
                while (digit >= '0' && digit <= '9') {
                    k += Integer.parseInt(stack.pollLast())*m;
                    m *= 10;
                    if (stack.size() == 0) {
                        break;
                    }
                    digit = stack.peekLast().toCharArray()[0];
                }

//                int k = Integer.parseInt(stack.pollLast());
//                System.out.println(k);
                //重复k次
                String var = "";
                for (int j = 0; j < k; j++) {
                    var += temp;
                }
                //将拼接后的字符串入栈
                stack.addLast(var);
            } else {
                stack.addLast(s.substring(i, i + 1));
            }
        }

        String res = "";
        while (stack.size() != 0) {
            res += stack.pollFirst();
        }
        return res;
    }
}
