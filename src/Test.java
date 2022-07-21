import java.lang.management.ThreadMXBean;
import java.util.*;
import java.util.jar.JarEntry;

/**
 * @author CrazyYao
 * @create 2022-06-12 16:23
 */
public class Test {
    public static void main(String[] args) {
        new Solution().canConstruct("a","b");
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) {this.val = val;}
    public ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        char[] map = new char[26];
        for (int i = 0; i < magazine.length(); ++i) {
            ++map[magazine.charAt(i) - 'a'];
        }

        char[] rchar = ransomNote.toCharArray();

        for (int i = 0; i < rchar.length; ++i) {
            --map[rchar[i] - 'a'];
            if (map[rchar[i] - 'a'] < 0) return false;
        }

        return true;
    }
}







