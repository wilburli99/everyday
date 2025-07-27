package day29;

public class max_sub_sum {
    public int maxSubArray(int[] nums) {
//        // 暴力解法
//        int max =  Integer.MIN_VALUE;
//        // 左指针控制子数组的起始位置
//        for (int left = 0; left < nums.length; left++) {
//            int sum = 0;
//            // 从右指针开始累加
//            for (int right = left; right < nums.length; right++) {
//                sum += nums[right];
//                max = Math.max(sum, max);
//            }
//        }
//        return max;

        // 动态规划+贪心算法
        int currSum = 0, maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            // 动态规划：当前数要不就接在子数组的后面，要不就重新开始
            currSum = Math.max(nums[i], currSum + nums[i]);
            // 全局最大的子数组的和
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        max_sub_sum max_sub_sum = new max_sub_sum();
        System.out.println(max_sub_sum.maxSubArray(nums));
    }
}
