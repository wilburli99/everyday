package day47;

import java.util.HashSet;
import java.util.Set;

public class longest_substring {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口+hashset
        int n = s.length();
        if (n == 0) return 0;

        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, maxlen = 0;
        while (right < n) {
            char c = s.charAt(right);
            while (set.contains(c)) { // 如果有重复，则移去左边界如何左指针右移
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxlen = Math.max(maxlen, right-left+1);
            right++;
        }
        return maxlen;
    }

    public static void main(String[] args) {
        String s = "dvdf";
        longest_substring ls = new longest_substring();
        int res = ls.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
