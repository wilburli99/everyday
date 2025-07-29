package day31;

public class sum_two_int {
    public int getSum(int a, int b) {
        while (b != 0) {
            int ad = (a & b) << 1;
            a = a ^ b;
            b = ad;
        }
        return a;
        // a = 2; b = 3
        // a=2= 010
        // b=3= 011
        // ad= (010 & 011) = 010 << 1 = 100 = 4
        // a = 010 ^ 011 = 001 = 1
        // b = ad = 4;

        // a=1= 001
        // b=4= 100
        // ad= (001 & 100) = 000 << 1 = 000 = 0无进位
        // a = 001 ^ 100 = 101 = 5
        // b = ad = 0;
    }
}
