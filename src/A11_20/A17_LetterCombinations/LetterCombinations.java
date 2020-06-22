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
 */
public class LetterCombinations {
    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        int step = 2;
        final char[][] table=new char[8][];
        table[0] = "abc".toCharArray();
        table[1] = "def".toCharArray();
        table[2] = "ghi".toCharArray();
        table[3] = "jkl".toCharArray();
        table[4] = "mno".toCharArray();
        table[5] = "pqrs".toCharArray();
        table[6] = "tuv".toCharArray();
        table[7] = "wxyz".toCharArray();

        List<String> res = new ArrayList<>();

        return null;




    }

}
