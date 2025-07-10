package day15;

public class longestones {
    public int longestOnes(int[] nums, int k) {
        // 滑动窗口
        int left = 0, right = 0;
        int count = 0;
        int maxLen = 0;
        // 如果窗口区间内的0数量<=k，则窗口向右扩展
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                count++;
            }
            // 窗口区间内的0数量>k，则窗口向左收缩
            while (count > k) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
