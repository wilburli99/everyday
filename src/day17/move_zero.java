package day17;

import java.util.Arrays;

public class move_zero {
    public void moveZeroes(int[] nums) {
//        int left = 0;
//        int right = left + 1;
//        if (nums.length == 0) {
//            return;
//        }
//        // 双指针，left比right慢，left指向非0的元素，right指向0的元素
//        while (right < nums.length) {
//            if (nums[left] == 0 && nums[right] != 0) {
//                int tmp = nums[left];
//                nums[left] = nums[right];
//                nums[right] = tmp;
//                left++;
//                right++;
//            } else if (nums[left] != 0) {
//                left++;
//                right++;
//            } else { // left == 0 && nums[right] == 0
//                right++;
//            }
//        }
        // 进阶方法
        // 左指针左边均为非零数，右指针到左指针处均为0
        int left = 0, right = 0;
        int n = nums.length;
        while (right < n) {
            if (nums[right] != 0) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1};
        new move_zero().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
