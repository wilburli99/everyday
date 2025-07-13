package day18;

public class max_water {
    public static int maxArea(int[] height) {
        int left = 0;
        int n = height.length;
        int right = n - 1;
        int res = 0;
        // 左右指针分别指向两边
        while (left < right) {
            // 计算当前容量
            int area = (Math.min(height[left], height[right])) * (right - left);
            // 每次移动数值小的指针
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            res = Math.max(res, area);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
