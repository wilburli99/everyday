package day27;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class max_length {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // 初始前缀和为0的下标为-1
        map.put(0, -1);
        int n = nums.length;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 将0换做-1
            if (nums[i] == 0) {
                nums[i] = -1;
            }
            sum += nums[i];
            if (map.containsKey(sum)) {
                // 如果sum在map里出现，证明下标i到map.get(sum)+1这一段的和为0
                res = Math.max(res, i - map.get(sum));
            } else {
                // 记录第一次出现的位置
                map.put(sum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(new max_length().findMaxLength(nums));
    }
}
