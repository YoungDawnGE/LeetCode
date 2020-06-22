package Tencent.数组和字符串;

/**
 * Created by Ge YangChen
 * 2019/10/14 16:33
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */

/*找最小长度，以第一个元素为基准*/
public class Q5_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = null;
        int len = strs.length;
        if (len == 0) {
            return "";
        }

        int maxLen=10000;
        for (int i = 0; i < len; i++) {
            if (strs[i].length() < maxLen) {
                maxLen = strs[i].length();
            }
        }
        boolean flag = false;
        int count=0;
        for (int i = 0; i < maxLen; i++) {
            char a = strs[0].charAt(i);
            for (int j = 0; j < len; j++) {
                if (a != strs[j].charAt(i)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            count++;
        }
        if (count == 0) {
            prefix = "";
        }else{
            prefix = strs[0].substring(0, count);
        }
        return prefix;
    }
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight" };
        Q5_longestCommonPrefix a = new Q5_longestCommonPrefix();
        System.out.println(a.longestCommonPrefix(strs));
    }
}
