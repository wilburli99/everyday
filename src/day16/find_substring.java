package day16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class find_substring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words.length == 0) {
            return res;
        }
        int n = s.length();
        int m = words.length;
        int wordlen = words[0].length();

        // 创建一个map，记录words中单词出现的次数
        Map<String, Integer> wordmap = new HashMap<>();
        for (String word : words) {
            wordmap.put(word, wordmap.getOrDefault(word, 0) + 1);
        }
        // 开始滑动窗口匹配
        for (int i = 0; i < wordlen; i++) {
            int left = i, count = 0;
            // 创建一个窗口map，记录窗口中单词出现的次数
            Map<String, Integer> window = new HashMap<>();
            for (int j = i; j <= n - wordlen; j += wordlen) {
                String word = s.substring(j, j + wordlen);
                if (wordmap.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;
                    // 窗口中单词出现的次数大于模板中的单词出现的次数，则窗口左边界向右移动并减少单词的频率
                    while (window.get(word) > wordmap.get(word)) {
                        String word2 = s.substring(left, left + wordlen);
                        window.put(word2, window.get(word2) - 1);
                        left += wordlen;
                        count--;
                    }
                    if (count == m) {
                        res.add(left);
                    }
                } else {
                    window.clear();
                    count = 0;
                    left = j + wordlen;
                }
            }
        }
        return res;
    }
}
