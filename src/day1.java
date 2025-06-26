public class day1 {
    // 小于等于k的最长二进制子序列
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int count = 0; // 记录选择的字符数量
        long value = 0; // 当前子序列对应的十进制的值
        long power = 1; // 当前位的权重
        // 倒序遍历字符串，因为二进制的地位对数值的影响较小，所以从低位开始遍历
        for (int i = n-1; i >= 0; i--) {
            // 遇到0，则选择该字符
            if (s.charAt(i) == '0') {
                count++;
            } else {
                // 遇到1，则判断是否满足该要求
                if (value + power <= k) {
                    count++;
                    value += power;
                }
            }
            // 更新下一位的权重
            if (power <= k) {
                power *= 2;
            }
        }
    }
}
