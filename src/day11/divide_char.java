package day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class divide_char {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 创建一个HashMap，用于存储key(排序后的str) 和 value(包含该key的字符串)
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            // 先对该字符串进行排序
            char[] chars = str.toCharArray();
            java.util.Arrays.sort(chars);
            // 获取排序后的字符串作为key
            String key = new String(chars);
            // 如果map中不存在该key，则创建一个空列表作为value
//            if (!map.containsKey(key)) {
//                map.put(key, new ArrayList<>());
//            }
            // 将当前字符串添加到对应的列表中
//            map.get(key).add(str);

            // 用getOrDefault方法避免key为null的情况，会报空指针异常
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            // 将当前字符串添加到对应的列表中
            map.put(key, list);

        }
        return new ArrayList<>(map.values());
    }
}
