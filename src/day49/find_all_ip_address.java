package day49;

import java.util.ArrayList;
import java.util.List;

public class find_all_ip_address {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backTrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backTrack(String s, int start, List<String> path, List<String> res) {
        // 结束条件
        if (path.size() == 4) {
            if (start == s.length()) {
                res.add(String.join("." , path));
            }
            return;
        }
        // 开始递归回溯
        for (int i = 0; i < 4; i++) {
            if ((start + i) > s.length()) break;
            String seg = s.substring(start, start+i);
            if (isVaild(seg)) {
                path.add(seg);
                backTrack(s,start+i,path,res);
                path.remove(path.size() - 1); // 撤回刚才一段
            }
        }
    }
    private boolean isVaild(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) return false;
        if (segment.isEmpty()) return false;
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }
}
