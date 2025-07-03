package day8;

public class find_the_kthchar {
    public char kthCharacter(int k) {
        // StringBuilder替代String：避免频繁创建新字符串对象
        StringBuilder start = new StringBuilder("a");
        char c;
        while (start.length() < k) {
            int l = start.length();
            for (int i = 0; i < l; i++) {
                c = start.charAt(i);
                // 处理循坏到z的情况
                char nextC = (c == 'z') ? 'a' : (char)(c + 1);
                start.append(nextC);
            }
        }
        return start.charAt(k - 1);
    }
}
