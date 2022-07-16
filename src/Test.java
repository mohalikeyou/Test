import java.lang.management.ThreadMXBean;
import java.util.*;
import java.util.jar.JarEntry;

/**
 * @author CrazyYao
 * @create 2022-06-12 16:23
 */
public class Test {
    public static void main(String[] args) {
        new Solution().minWindow("ADOBECODEBANC"
                ,"ABC");
    }
}

class Solution {
    public String minWindow(String s, String t) {
        // 窗口右元素始终添加，直到结束；
        // 窗口左元素，如果非t则剔除窗口。或者，如果随着右元素的添加，当前左侧t元素变得冗余（即添加的右元素和当前左元素相同），
        // 那么剔除当前冗余的左元素也不会影响滑动窗口的t元素总量！
        // 根据这种思路，从而求得最小覆盖t窗的s串的子串；
        if (s.length() < t.length()) return "";

        int[] hash = new int[128];

        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();

        for (char c : tchar) ++hash[c];

        String res = ""; //初始值，如果滑动窗口始终没有滑动过，则返回这个；

        int nums = tchar.length; // 记录窗口内t字母的个数
        for (int i = 0, j = 0; i < s.length(); ++i) {
            --hash[schar[i]];//非t元素 会小于0，多余的重复t元素，也会小于零；恰好t中字母个数的都是等于零

            if(hash[schar[i]] >= 0) --nums; //如果减了之后大于等于零，说明这个元素是需要的；

            //如果t元素不够不会执行，一旦够了，滑动窗口会一直包含所有t元素；
            // 关键！！ 左指针向右滑动窗口的条件？1. 左侧元素是冗余的t元素。2.左侧元素是非t内元素
            // 删掉以上的，窗口内仍然保持有所有t元素；
            // 冗余元素，hash值总是小于零的；
            // 总是剔除没用元素；
            while (nums == 0 && hash[schar[j]] < 0)
                ++hash[schar[j++]];

            // 每次 都比较目前窗口的元素的个数；如果t元素不够，不会执行
            if (nums == 0) {
                if (res.equals("") || res.length() > i - j + 1)
                    res = s.substring(j, i + 1);
            }
	    return 0;// test0//test1.........//333
        }
    }
}








