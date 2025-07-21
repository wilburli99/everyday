package day25;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class longest_str {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        // 用哈希set来存储字符串，采用滑动窗口来寻找字符串
        Set<Character> set = new HashSet<>();
        int res = 0;
        // 先定义窗口的右边界，相当于左边界的左侧，还没开始移动
        int end = -1;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 左指针向右移动一格，就去掉前面的字符
                set.remove(s.charAt(i - 1));
            }
            while (end + 1 < n && !set.contains(s.charAt(end + 1))) {
                // 移动右指针
                set.add(s.charAt(end + 1));
                end++;
            }
            res = Math.max(res, end-i+1);
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(new longest_str().lengthOfLongestSubstring(s));
    }
}
