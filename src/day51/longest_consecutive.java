package day51;

import java.util.HashSet;
import java.util.Set;

public class longest_consecutive {
    public int longestConsecutive(int[] nums) {
        // hashset存储
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // 遍历每个数，如果该数无前驱，可以作为开头
        int maxlen = 0;
        for (int num : set) {
            if (!set.contains(num-1)) {
                int cur = num; // 当前为起点
                int curmax = 1; // 当前区间的最长
                while (set.contains(cur + 1)) {
                    cur++;
                    curmax++;
                }
                maxlen = Math.max(maxlen, curmax);
            }
        }
        return maxlen;
    }
}
