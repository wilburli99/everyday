package day7;

import java.util.ArrayList;
import java.util.List;

public class removeElement {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        // 双指针方法更节省空间，且按要求只需要修改原数组
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
