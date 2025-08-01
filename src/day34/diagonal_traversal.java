package day34;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class diagonal_traversal {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        List<Integer> res = new ArrayList<>();
        // 对角线的数量
        for (int d = 0; d <= m+n-2; d++) {
            // 起始位置
            int row = d<n ? 0 : d-n+1;
            int col = d<n ? d : n-1;
            List<Integer> tmp = new ArrayList<>();
            while (row < m && col >= 0) {
                tmp.add(mat[row][col]);
                row++; // 往左下走
                col--;
            }
            // d为偶数时方向反过来
            if (d % 2 == 0) {
                Collections.reverse(tmp);
            }
            res.addAll(tmp);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
