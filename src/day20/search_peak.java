package day20;

public class search_peak {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int n = arr.length;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 判断是否在爬升阶段
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else { // 否则在顶峰或下降阶段
                right = mid;
            }
            if (left == right) {
                return right;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0};
        System.out.println(new search_peak().peakIndexInMountainArray(arr));
    }
}
