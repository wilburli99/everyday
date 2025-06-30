package day5;

import java.util.Arrays;

public class day5 {
    public static int findLHS(int[] nums) {
        // 升序排序
        Arrays.sort(nums);
        int left = 0;
        int n = nums.length;
        int res = 0;
        // 双指针
        for (int end = 0; end < n; end++) {
            // 如果end的值与left的差值大于1，移动left指针
            while (nums[end] - nums[left] > 1) {
                left++;
            }
            // 如果end的值与left的差值等于1，更新其最远距离
            if (nums[end] - nums[left] == 1) {
                res = Math.max(res, end - left + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
    }
}
