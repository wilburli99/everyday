package day11;

import java.util.HashMap;
import java.util.Map;

public class sum_twoNum {
    public int[] twoSum(int[] nums, int target) {
        // 暴力求解, 时间复杂度O(n^2)
//        int[] res = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    res[0] = i;
//                    res[1] = j;
//                    return res;
//                }
//            }
//        }
//        return null;
        // 使用哈希表, 时间复杂度O(n)
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            // 判断哈希表中是否存在target-nums[i], 如果存在，则返回该索引和当前索引
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            // 否则将nums[i]和其索引存入哈希表
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2,5,5,11};
        int target = 10;
        sum_twoNum sum_twoNum = new sum_twoNum();
        int[] res = sum_twoNum.twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
