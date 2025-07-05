package day10;

import java.util.HashMap;
import java.util.Map;

public class find_luckyNum {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        // 用map记录数字出现的次数
        for (int num :  arr) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int lucky = -1;
        // Map.Entry<Integer, Integer>表示key-value对， map.entrySet()返回所有key-value对
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (key == value) {
                lucky = Math.max(lucky,entry.getKey());
            }
        }
        return lucky;
    }

    public static void main(String[] args) {
        find_luckyNum find_luckyNum = new find_luckyNum();
        int[] arr = {1,2,2,3,3,3};
        System.out.println(find_luckyNum.findLucky(arr));
    }
}
