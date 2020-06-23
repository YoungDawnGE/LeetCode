package A11_20.A17_LetterCombinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GYC
 * 2020/6/22 16:41
 * 17. 电话号码的字母组合
 * 难度中等762收藏分享切换为英文关注反馈
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"   abc def
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 回溯？
 *
 */
public class LetterCombinations {
    public static void main(String[] args) {
        List<String> res = letterCombinations("23");
        for (String s : res) {
            System.out.print(s+" ");
        }
    }

    //通过while循环做
    public static List<String> letterCombinations(String digits) {
        final int step = 2;
        final String[] table = new String[8];
        table[0] = "abc";
        table[1] = "def";
        table[2] = "ghi";
        table[3] = "jkl";
        table[4] = "mno";
        table[5] = "pqrs";
        table[6] = "tuv";
        table[7] = "wxyz";

        List<String> res = new ArrayList<>();
        int digitsLen = digits.length();//传入字符串的长度

        //如果长度为0，返回空
        if (digitsLen == 0) {
            return res;
        }

        //如果长度为1，直接返回字母
        if (digitsLen == 1) {
            String curStr = table[Integer.parseInt(digits)-2];
            int len = curStr.length();
            for (int i = 0; i < len; i++) {
                res.add(curStr.substring(i, i + 1));
            }
            return res;
        }

        //如果长度大于1，和已有的List组合后添加
        String firstLetter = digits.substring(0, 1);
        String curStr = table[Integer.parseInt(firstLetter)-2];

        int len = curStr.length();
        for (int i = 0; i < len; i++) {
            res.add(curStr.substring(i, i + 1));
        }
        digits = digits.substring(1);//除去首字符后剩下的数字
        digitsLen = digits.length();

        while (digitsLen > 0 ) {
            firstLetter = digits.substring(0, 1);
            curStr = table[Integer.parseInt(firstLetter)-2];
            len = curStr.length();
            List<String> temp = new ArrayList<>();
            int size = res.size();

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < len; j++) {
                    temp.add(res.get(i) + curStr.substring(j, j + 1));
                }
            }
            res = temp;
            digits = digits.substring(1);//除去首字符后剩下的数字
            digitsLen = digits.length();
        }
        return res;
    }
}
