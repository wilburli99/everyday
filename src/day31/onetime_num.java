package day31;

import java.util.HashMap;
import java.util.Map;

public class onetime_num {
    public int singleNumber(int[] nums) {
//        // map
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }
//        for (int num : nums) {
//            if (map.get(num) == 1) {
//                return num;
//            }
//        }
//        return 0;

        // 位运算
        int result = 0;
        // 对于 32 位整数的每一位
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;
            for (int num : nums) {
                // 把 num 右移 i 位，判断最后一位是否是 1
                bitSum += (num >> i) & 1;
            }
            // 如果某一位上出现 1 的次数不是 3 的倍数，那就说明这个 1 是来自那个只出现一次的数，我们就把这一位加进 result。
            // 模 3 后剩下的就是那个只出现一次的数在该位上的值
            if (bitSum % 3 != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
}
