package day14;

import java.util.Arrays;

public class minSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minSub = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
               sum += nums[right];
               while (sum >= target) {
                   minSub = Math.min(minSub, right - left + 1);
                   sum -= nums[left++];
               }
        }
        // 如果从头到尾一次都没有找到合法子数组，说明 minLen 没被更新，仍是初始值 → 返回 0
        if (minSub == Integer.MAX_VALUE) {
            return 0;
        }
        return minSub;
    }
}
