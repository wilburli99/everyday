package day8;

import static java.util.Collections.swap;

public class sort_color {
    public void sortColors(int[] nums) {
        int n = nums.length;
        // 冒泡排序
//        for (int i = 0; i < n - 1; i++) {
//            boolean flag = false;
//            for (int j = 0; j < n - i - 1; j++) {
//                if (nums[j] > nums[j + 1]) {
//                    int temp = nums[j];
//                    nums[j] = nums[j + 1];
//                    nums[j + 1] = temp;
//                    flag = true;
//                }
//            }
//            if (!flag) {
//                break;
//            }
//        }
        // 双指针
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = tmp;
                p1++;
            } else if (nums[i] == 0){
                int tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                // 遇到0时，需要把0放到p0位置。但如果p0位置已经有1了，我们需要保证这个1不会丢失
                if (p0 < p1) {
                    tmp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = tmp;
                }
                p0++;
                p1++;
            }
        }
    }
}
