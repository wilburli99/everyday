package day19;

public class search_range {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        return new int[]{left, right};
    }
    public int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (nums[mid] == target) {
                    res = mid;
                }
                right = mid - 1;
            }
        }
        return res;
    }
    public int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (nums[mid] == target) {
                    res = mid;
                }
                left = mid + 1;
            }
        }
        return res;
    }
}
