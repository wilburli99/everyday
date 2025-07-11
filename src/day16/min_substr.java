package day16;

import java.util.HashMap;
import java.util.Map;

public class min_substr {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> windowmap = new HashMap<>();
        // 创建关于字符串t的map，记录map中单词出现的次数
        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int count = 0;
        int minlen = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            // 窗口右边界向右移动
            char c = s.charAt(right);
            right++;
            if (tmap.containsKey(c)) {
                windowmap.put(c, windowmap.getOrDefault(c, 0) + 1);
                if (windowmap.get(c).intValue() == tmap.get(c).intValue()) {
                    count++;
                }
            }
            while (count == tmap.size()) {
                if (right - left < minlen) {
                    start = left;
                    minlen = right - left;
                }
                // 从左开始收缩窗口
                char d = s.charAt(left);
                left++;
                if (tmap.containsKey(d)) {
                    if (windowmap.get(d).intValue() == tmap.get(d).intValue()) {
                        count--;
                    }
                    windowmap.put(d, windowmap.get(d) - 1);
                }
            }
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start + minlen);
    }
}
