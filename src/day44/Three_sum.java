package day44;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复i
            if (i > 0 && nums[i] == nums[i-1]) continue;
            if (nums[i] > 0) break;
            // 固定i，求两数之和
            int left = i+1, right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //跳过重复的数
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if(sum > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
