package Tencent.数组和字符串;
/**
 * Created by Ge YangChen
 * 2019/9/29 9:50
 * Happy The National Day
 */

/*给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案

输入: "cbbd"
输出: "bb"*/
//正确的方法应该是从中间的某个字母向外拓展

/*1、先对字符串进行预处理，两个字符之间加上特殊符号#；

2、然后遍历整个字符串，用一个数组来记录以该字符为中心的回文长度，为了方便计算右边界，我在数组中记录长度的一半（向下取整）；

3、每一次遍历的时候，如果该字符在已知回文串最右边界的覆盖下，那么就计算其相对最右边界回文串中心对称的位置，得出已知回文串的长度；

4、判断该长度和右边界，如果达到了右边界，那么需要进行中心扩展探索。当然，如果第3步该字符没有在最右边界的“羽翼”下，则直接进行中心扩展探索。进行中心扩展探索的时候，同时又更新右边界；

5、最后得到最长回文之后，去掉其中的特殊符号即可。
*/
public class Q3 {
    //@Deprecated表示该方法弃用

    //字符串拓展，用于处理aa，即中心长度为偶数的情况。
    public String preOperation(String s){
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        return sb.toString();

    }


    public String longestPalindrome(String s) {
        String str = preOperation(s);
        int len = str.length();
        int[] halfLenArr = new int[len];
        System.out.println(str);
        //右边界rBoundary
        int rBoundary = 0;
        //有边界对应的回文中心；
        int rBoundaryCenter = 0;
        //记录当前字符的中心长度
        int centerLen;
        for (int i = 0; i < len ; i++) {
            centerLen = 0;
            if (i >= rBoundary) {
                int shift = Math.min(i, len - i - 1);
                for (int j = 0; j <= shift; j++) {
                    if (str.charAt(i - j) == str.charAt(i + j)) {
                        centerLen++;
                    } else break;
                }
                halfLenArr[i] = centerLen;
//                if (halfLenArr[i] >= halfLenArr[rBoundaryCenter]) {
//                    rBoundaryCenter = i;
//                }
                rBoundaryCenter = i;
                rBoundary = i + halfLenArr[i] - 1;
            } else {
                halfLenArr[i] = halfLenArr[2 * rBoundaryCenter - i];
            }
        }

        int max = 0;
        int index=0;

        for (int i = 0; i < len; i++) {
            System.out.print(" "+halfLenArr[i]);
            if (halfLenArr[i] > max) {
                max = halfLenArr[i];
                index = i;
            }
        }
        StringBuffer sb2 = new StringBuffer();
        for (int i = index - max +2; i < index +max; i+=2) {
           sb2.append(str.charAt(i));
        }
        System.out.println();
        return sb2.toString();
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3();
//        cabadabae
        System.out.println(q3.longestPalindrome("ccc"));
    }
}
