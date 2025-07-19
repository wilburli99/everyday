package day24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class range_sum {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mode = 1000000007;
        List<Integer> sum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sums = 0;
            for (int j = i; j < n; j++) {
                sums += nums[j];
                sum.add(sums % mode);
            }
        }
        Collections.sort(sum);
        int res = 0;
        for (int i = left - 1; i < right; i++) {
            res += sum.get(i % mode);
        }
        return res % mode;
    }
}
