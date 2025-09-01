package day48;

public class is_anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) return false;
        int[] times = new int[26];
        // 如果字符串t中字符出现的次数不小于0，说明顺序不同且次数相同
        for (int i = 0; i < s.length(); i++) {
            times[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            times[t.charAt(i) - 'a']--;
            if (times[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
