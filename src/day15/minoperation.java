package day15;

public class minoperation {
    public int minOperations(int[] nums, int x) {
        // 将最小操作数变为寻找数组中最长的子数组，满足和为sum-x
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果sum-x < 0，则无法达到目的
        if (sum - x < 0) {
            return -1;
        }
        // 然后寻找最长子数组--滑动窗口
        int left = 0, maxLen = -1;
        int curSum = 0;
        int target = sum - x;
        for (int right = 0; right < nums.length; right++) {
            curSum += nums[right];
            while (curSum > target && left <= right) {
                curSum -= nums[left];
                left++;
            }
            if (curSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        if (maxLen == -1) {
            return -1;
        }
        return nums.length - maxLen;
    }
}
