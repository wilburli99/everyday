package day13;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {
    public int longestConsecutive(int[] nums) {
        // 哈希set去重存储数组
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : set) {
            // 如果该数不存在前驱，则该数是连续序列的起点
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                // 从起点位置开始寻找连续序列
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                // 更新最长连续序列长度
                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        longestConsecutive longestConsecutive = new longestConsecutive();
        System.out.println(longestConsecutive.longestConsecutive(nums));
    }
}
