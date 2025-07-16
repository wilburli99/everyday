package day21;

public class find_min2 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) { // 最小值在左边
                right = mid;
            } else if (nums[mid] > nums[right]) { // 最小值在右边
                left = mid + 1;
            } else { // 不确定，缩小右边界
                right--;
            }
        }
        return nums[left];
    }
}
