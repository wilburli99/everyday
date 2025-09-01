package day48;

public class longest_common_sub {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        // 动态规划
        for (int i = 1; i <= n; i++) {
            char t1 = text1.charAt(i-1);
            for (int j = 1; j <= m; j++) {
                char t2 = text2.charAt(j-1);
                if (t1 == t2) { // 如果当前字符相等，两个字符串都-1，结果+1
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else { // 当前字符不相等，比较一个字符串-1后的最长，取最大值
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
