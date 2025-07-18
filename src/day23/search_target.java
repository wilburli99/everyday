package day23;

public class search_target {
    public boolean searchMatrix(int[][] matrix, int target) {
        int cow = matrix.length;
        int col = matrix[0].length;
        int x = 0, y = col - 1;
        while (x < cow && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
