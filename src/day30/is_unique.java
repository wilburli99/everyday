package day30;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class is_unique {
    public boolean isUnique(String astr) {
//        // 使用哈希map
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : astr.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        for (int i = 0; i < astr.length(); i++) {
//            if (map.containsKey(astr.charAt(i))) {
//                if (map.get(astr.charAt(i)) != 1) {
//                    return false;
//                }
//            }
//        }
//        return true;

        // 使用set
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            if (set.contains(astr.charAt(i))) {
                return false;
            }
            set.add(astr.charAt(i));
        }
        return true;
    }
}
