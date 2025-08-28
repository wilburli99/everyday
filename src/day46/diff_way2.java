package day46;

public class diff_way2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 动态规划思路
        // 如果当前不是障碍物，机器人只能从上面[i-1][j]和左边[i][j-1]来到[i][j]
        // 如果当前是障碍物[i][j] == 0
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 边界条件：起始位障碍物
        if (obstacleGrid[0][0] == 1) return 0;
        dp[0][0] = 1;
        // 第一列
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0 && dp[i-1][0] == 1) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        // 第一行
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0 && dp[0][j-1] == 1) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        // 其他格子
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
