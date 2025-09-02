package day50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//求出一个字符串所有长度大于2的不重复的子串，并统计出现次数，降序输出
public class substring_count {
    public static void main(String[] args) {
        String s = "abcabcabc";
        Map<String, Integer> countMap = new HashMap<>();

        // 枚举所有长度 >= 3 的子串
        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                String sub = s.substring(i, i + len);
                countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
            }
        }

        // 排序：根据次数从高到低排序
        List<Map.Entry<String, Integer>> list = new ArrayList<>(countMap.entrySet());
        list.sort((a, b) -> b.getValue().equals(a.getValue()) ?
                a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

        // 输出
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
