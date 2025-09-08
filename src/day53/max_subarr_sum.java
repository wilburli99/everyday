package day53;

public class max_subarr_sum {
    public int maxSubArray(int[] nums) {
        int cur = 0, maxSum = Integer.MIN_VALUE;
        // 当前数要不是在+在前数后面，要不就重新开始
        for (int i = 0; i < nums.length; i++) {
            // 只需返回最大的和
            cur = Math.max(nums[i], cur + nums[i]);
            maxSum = Math.max(maxSum, cur);
        }
        return maxSum;
    }
}
