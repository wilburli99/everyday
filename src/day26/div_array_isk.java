package day26;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class div_array_isk {
    public int subarraysDivByK(int[] nums, int k) {
        // 暴力解法，容易超限
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum % k == 0) count++;
//            }
//        }
//        return count;
        // 前缀和+哈希表
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        // 每次计算新的前缀和sum%k，看看出现过多少相同的余数，就有多少个子数组
        for (int num : nums) {
            sum += num;
            int remainder = ((sum % k) + k) % k; // 防止负数情况，保证余数为正
            count += map.getOrDefault(remainder, 0);
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[6];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        div_array_isk s = new div_array_isk();
        System.out.println(s.subarraysDivByK(nums, k));
    }
}
