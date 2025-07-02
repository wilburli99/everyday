package day7;

import java.util.HashMap;
import java.util.Map;

public class croakOfFrogs {
    public int minNumberOfFrogs(String croakOfFrogs) {
        // 如果输入的字符不能被5整除，证明不是完整的蛙叫
        if(croakOfFrogs.length() % 5 != 0) {
            return -1;
        }
        // 创建长度为4的数组，记录croa的状态
        int[] cnt = new int[4];
        int res = 0, flagNum = 0;
        // 创建hashmap记录对应字母的映射
        Map<Character, Integer> map = new HashMap<>();
        map.put('c', 0);
        map.put('r', 1);
        map.put('o', 2);
        map.put('a', 3);
        map.put('k', 4);
        // 开始遍历
        for(int i = 0; i < croakOfFrogs.length(); i++) {
            char ch = croakOfFrogs.charAt(i);
            int t = map.get(ch);
            // t==0说明刚开始
            if (t == 0) {
                cnt[t]++;
                flagNum++;
                res = Math.max(res, flagNum);
            } else {
                // t!=0说明不是刚开始,则需要检查上一个字母的状态
                if (cnt[t-1] == 0) {
                    return -1;
                }
                cnt[t-1]--;
                if (t == 4) {
                    // 说明已经完成一轮蛙叫，flagNum减1
                    flagNum--;
                } else {
                    // 否则，cnt[t]+1
                    cnt[t]++;
                }
            }
        }
        // 检查是否所有蛙叫都完成
        if (flagNum > 0) {
            return -1;
        }
        return res;
    }
}
