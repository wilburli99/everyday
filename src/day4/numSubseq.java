package day4;

import java.util.Arrays;

public class numSubseq {
    public int numSubseq(int[] nums, int target) {
        // 取模常数
        int MOD = 1000000007;
        int n = nums.length;

        // 对数组进行排序
        Arrays.sort(nums);

        // 预计算2的幂次，用于快速计算子序列的数量
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 0; i < n; i++) {
            pow2[i] = (pow2[i - 1] *2) % MOD;
        }

        // 使用双指针
        int left = 0;
        int right = n-1;
        int res = 0;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                res = (res + pow2[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
