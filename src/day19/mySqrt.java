package day19;

public class mySqrt {
    public int mySqrt(int x) {
        // x平方根的整数部分k满足：k^2 <= x < (k+1)^2
        int left = 0, right = x;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 如果不是long类型，可能会溢出
            if ((long)mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
