package day28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        // 处理边界情况
        if (s.length() < p.length()) return ans;
        // 统计p字符串的字符频次
        int[] countP = new int[26];
        for (int i = 0; i < p.length(); i++) {
            countP[p.charAt(i) - 'a']++;
        }
        // 统计窗口内的字符频次
        int[] countS = new int[26];
        int windowSize = p.length();
        for (int i = 0; i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
            // 保持窗口大小为p.length()
            if (i >= windowSize) {
                countS[s.charAt(i-windowSize) - 'a']--;
            }
            // 比较
            if (Arrays.equals(countP, countS)) {
                ans.add(i-windowSize+1);
            }
        }
        return ans;
    }
}
