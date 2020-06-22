package A1_10.A3_LengthOfLongestSubstring;

import java.util.HashMap;

/**
 * Created by GYC
 * 2020/5/21 12:56
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
 *
 *
 *      "abcdecfijdh"
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring lols = new LengthOfLongestSubstring();
        //"bbtablud"
        System.out.println(lols.lengthOfLongestSubstring_2("tmmzt"));//tmmzt
    }


//    way3, way2的精简
    public int lengthOfLongestSubstring_2(String s){
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int strLen = s.length();
        int res = 0;
        int end = 0, start = 0;//start开始
        for (; end < strLen; end++) {
            char c = s.charAt(end);
            if (!hashMap.containsKey(c)) {
                hashMap.put(c, end);
            } else {
                //只有遇到重复的时候 滑动窗口左侧才需要变
                start = Math.max(start, hashMap.get(c)+1);
                hashMap.put(c, end);//更新下标
            }
            res = Math.max(res, end + 1 - start);
        }
        return res;
    }

//    way2 hashmap
    public int lengthOfLongestSubstring_1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //Hashmap不用记录出现的次数，记录出现的index就行
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int strLen = s.length();
        int longestLen = 0;
        int tempLen = 0;
        int j = 0;//j 滑动窗口的左端，i滑动窗口的右端
        for (int i = 0; i < strLen; i++) {//tmmzt
            char c = s.charAt(i);
            if (!hashMap.containsKey(c)) {
                hashMap.put(c, i);
                tempLen++;
            } else {
                j = j < hashMap.get(c) ? hashMap.get(c) : j;
                tempLen++;
                tempLen = i - j;
                hashMap.put(c, i);
            }
            longestLen = tempLen > longestLen ? tempLen : longestLen;
        }
        return longestLen;
    }
}
