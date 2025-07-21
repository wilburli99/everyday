package day25;

import java.util.Arrays;

public class find_mid_index {
    public int pivotIndex(int[] nums) {
        // 暴力解法
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            int mid = i;
//            int left = 0;
//            int right = n-1;
//            int sumleft = 0, sumright = 0;
//            while (left < mid) {
//                sumleft += nums[left++];
//            }
//            while (mid < right) {
//                sumright += nums[right--];
//            }
//            if (sumleft == sumright) {
//                return i;
//            }
//        }
//        return -1;
        // 前缀和
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        // 右边的和 = 总和 - 左边的和 - 当前数
        for (int i = 0; i < nums.length; i++) {
            if (sum == total - sum - nums[i]) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,-1};
        System.out.println(new find_mid_index().pivotIndex(nums));
    }
}
