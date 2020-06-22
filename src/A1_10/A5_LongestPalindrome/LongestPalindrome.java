package A1_10.A5_LongestPalindrome;

/**
 * Created by GYC
 * 2020/5/28 9:26
 * 5. 最长回文子串
 * 难度中等2247收藏分享切换为英文关注反馈
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();

        String s = "cbbd";
//        System.out.println(s.substring(1, 2));
//        System.out.println(lp.longestPalindrome_2(s));
        System.out.println(lp.longestPalindrome_3(s));
    }



    //way1 超暴力 O(n3)
    public String longestPalindrome_1(String s) {
        if (s.length() < 2) {
            return s;
        }
        int sLen = s.length();
        //通过起始点和长度就可以确定子串
        int start = 0;
        int tempLen = 0;
        char[] charArray = s.toCharArray();//转化为char数组更快，因为charAt每次都需要查看是否越界

        for (int i = 0; i < sLen - 1; i++) {
            for (int j = i ; j < sLen; j++) {
                if ((j - i + 1) > tempLen && isPalindrome_1(charArray, i, j)) {
                    start = i;
                    tempLen = j-i+1;
                }
            }
        }
        return s.substring(start, start + tempLen);
    }

    public boolean isPalindrome_1(char[] charArray, int i, int j) {
        int mid = (j + i + 1) / 2;
        while (i < mid) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }


    //way2 中心拓展法 O(n2)
    public String longestPalindrome_2(String s) {
        if (s.length() < 2) {
            return s;
        }
        int sLen = s.length();
        //通过起始点和长度就可以确定子串
        int start = 0;
        int maxsubLen = 1;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < sLen - 1; i++) {
            int oddSubLen = expandFromCenter(charArray, i, i);
            int evenSubLen = expandFromCenter(charArray, i, i + 1);
            int tempSubLen= Math.max(oddSubLen, evenSubLen);

            if (tempSubLen > maxsubLen) {
                maxsubLen = tempSubLen;
                //画个图就能理解
                start = i - (maxsubLen - 1) / 2;
            }
        }
        return s.substring(start, start + maxsubLen);
    }

    public int expandFromCenter(char[] charArray, int i, int j) {
//        int len = j - i + 1;//若i，j相同则是中心只有一个元素的情况，len==1; 若i,j不同则是中心元素为2的情况，len==2
//        好像没必要上一句
        int sLen = charArray.length;
        while (i >= 0 && j < sLen) {
            if (charArray[i] == charArray[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
//        System.out.println(j - i + 1);
        return j - i - 1;
    }


    //动态规划
    public String longestPalindrome_3(String s) {
        int sLen = s.length();
        if (sLen < 2) {
            return s;
        }
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[sLen][sLen];

        //初始化对角线上元素
        for (int i = 0; i < sLen; i++) {
            dp[i][i] = true;
        }

        int start = 0;
        int maxLen = 1;

        //构建dp二维表,只要构建上三角矩阵,先构建列，再构建行
        for (int j = 1; j < sLen; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                }else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
//                    System.out.println(start+" "+maxLen);
                }
            }
        }

//        //输出
//        for (int i = 0; i < sLen; i++) {
//            for (int j = 0; j < sLen; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

        return s.substring(start, start + maxLen);
    }
}
