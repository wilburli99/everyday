package day14;

import java.util.Scanner;

public class first_word {
    // 简写单词
    public static void main(String[] args) {
        String[] arrs = new String[0];
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            arrs = sc.nextLine().split(" ");
        }
        String tmp = "";
        String res = "";
        for (int i = 0; i < arrs.length; i++) {
            tmp += arrs[i] + " ";
        }
        res = tmp.charAt(0)+"";
        for (int i = 1; i < tmp.length()-1; i++) {
            if (tmp.charAt(i) == ' ') {
                res += tmp.charAt(i+1);
            }
        }
        System.out.println(res.toUpperCase());
    }
}
