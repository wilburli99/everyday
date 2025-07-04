package day9;

public class find_kth_char2 {
    public char kthCharacter(long k, int[] operations) {
        int count = 0;
        for (int i = 63 - Long.numberOfLeadingZeros(k-1); i >= 0; i--) {
            // 如果k在左半边则不进行操作
            if (k > (1l << i)) { // k在右半边
                count += operations[i]; // 是否操作
                k -= (1l << i); // 右半边
            }
        }
        return (char) ('a' + (count % 26));
    }
}
