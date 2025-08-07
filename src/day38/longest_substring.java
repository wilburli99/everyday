package day38;

public class longest_substring {
    public int longestSubstring(String s, int k) {
        // 记录每个字符的频率
        if (s.length() < k) return 0;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        // 分治如果找到频率小于k的就作为分割点
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] < k) {
                int left = longestSubstring(s.substring(0,i), k);
                int right = longestSubstring(s.substring(i+1), k);
                return Math.max(left, right);
            }
        }
        return s.length();
    }
}
