package day26;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class sub_array_isk {
    public int subarraySum(int[] nums, int k) {
        // 暴力解法
//        int n = nums.length;
//        int count = 0;
//        // 先固定一个左指针，然后右指针移动，移动过程中判定
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            // 否则判断左指针到右指针的和是否等于k；如果等于k，计数器+1；如果不等，一直加到右指针结束，下一轮。
//            for (int j = i ; j < n; j++) {
//                sum += nums[j];
//                if (sum == k) {
//                    count++;
//                }
//            }
//        }
//        return count;
        // 前缀和+哈希表
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sub_array_isk s = new sub_array_isk();
        System.out.println(s.subarraySum(nums, k));
    }
}
