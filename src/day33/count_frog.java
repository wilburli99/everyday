package day33;

public class count_frog {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] count = new int[5];
        int maxfrogs = 0, current = 0;
        for (char ch : croakOfFrogs.toCharArray()) {
            int index = "croak".indexOf(ch);
            if (index == -1) {
                return -1;
            }
            if (index == 0) { // 开始
                current++;
                count[0]++;
                maxfrogs = Math.max(maxfrogs, current);
            } else {
                if (count[index-1] == 0) { // 不连贯不是有效组合
                    return -1;
                } else {
                    count[index-1]--;
                    count[index]++;
                    if (index == 4) {
                        current--; // 其中一只已经叫完了
                    }
                }
            }
        }
        // 如果前面有不为0，证明还有青蛙没有叫完
        for (int i = 0; i < count.length-1; i++) {
            if (count[i] != 0) return -1;
        }
        return maxfrogs;
    }
}
