package day8;

import java.util.ArrayList;
import java.util.List;

public class Yanghui_triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // 边界都是1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // 如果不是边界的情况，该元素是上一层的上一个元素和上一层的当前元素之和
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}
