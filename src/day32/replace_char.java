package day32;

public class replace_char {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '?') {
                for(char c = 'a'; c <= 'z'; c++) {
                    boolean pre = (i == 0 || sb.charAt(i-1) != c);
                    boolean next = (i == sb.length() - 1 || sb.charAt(i+1) != c);
                    if (pre && next) {
                        sb.setCharAt(i, c);
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}
