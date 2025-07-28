package day30;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class missing_num {
    public int missingNumber(int[] nums) {
//        // 排序 O(nlogn)
//        Arrays.sort(nums);
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] != i) {
//                return i;
//            }
//        }
//        return n; // 如果前面的都相等，就是缺少最后一位

        // 哈希set O(n)
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int res = -1;
        // 查找0-n的数中缺少哪个
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                res = i;
                break;
            }
        }
        return res;
    }
}
