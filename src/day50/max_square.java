package day50;

public class max_square {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxlen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) { // 边界条件
                        dp[i][j] = 1;
                    } else { // 作为右下角的点，取左，上，左上的最小值 + 1
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    maxlen = Math.max(maxlen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxlen * maxlen;
    }
}
