package Tencent.数组和字符串;

import java.util.Stack;

/**
 * Created by Ge YangChen
 * 2019/10/21 10:12
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */


/*有1个 ( 则往栈中存一个 ) */
public class Q8_parenthesesMatching {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int len = s.length();
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.add(')');
                    break;
                case '[':
                    stack.add(']');
                    break;
                case '{':
                    stack.add('}');
                    break;
                case ')':
                    if (!stack.empty()&&stack.peek() == ')')
                        stack.pop();
                    else flag = true;
                    break;
                case ']':
                    if (!stack.empty()&&stack.peek() == ']')
                        stack.pop();
                    else flag = true;
                    break;
                case '}':
                    if (!stack.empty()&&stack.peek() == '}')
                        stack.pop();
                    else flag = true;
                    break;
                default:
                    flag = true;
                    break;
            }
            if (flag) {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Q8_parenthesesMatching a = new Q8_parenthesesMatching();
        System.out.println(a.isValid("[](){()}{"));
    }

}
