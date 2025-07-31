package day33;

public class count_and_say {
    public String countAndSay(int n) {
        // 1 = "1".  2 = ""
        String res = "1";
        // 外层for循环遍历
        for (int i = 1; i < n; i++) {
            // 内层遍历统计次数
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j) == res.charAt(j-1)) {
                    count++;
                } else {
                    sb.append(count).append(res.charAt(j-1));
                    count = 1;
                }
            }
            sb.append(count).append(res.charAt(res.length() - 1));
            res = sb.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        count_and_say s = new count_and_say();
        System.out.println(s.countAndSay(n));
    }
}
