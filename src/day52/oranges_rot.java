package day52;

import java.util.LinkedList;
import java.util.Queue;

public class oranges_rot {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        // 将烂橘子加入队列，并记录好橘子的数量
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int minutes = 0;
        int[][] position = {{0,-1},{0,1},{-1,0},{1,0}}; // 上下左右
        // BFS遍历每一轮橘子的腐烂情况
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 每一轮相当于一分钟
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1]; // 当前烂橘子坐标
                for (int[] p : position) {
                    int nx = x + p[0], ny = y + p[1]; // 找上下左右
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        fresh--;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}
