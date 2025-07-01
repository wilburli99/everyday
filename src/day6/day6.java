package day6;

public class day6 {
    public int possibleStringCount(String word) {
        int n = word.length();
        int res = 1; // 最少只有一种
        for (int i = 1; i < n; i++) {
            if (word.charAt(i-1) == word.charAt(i)) {
                res++;
            }
        }
        return res;
    }
}
