package day35;

import java.util.LinkedList;
import java.util.List;

public class count_smaller {
    private int[] count;
    private int[] indexes;
    private int[] tmp;
    public List<Integer> countSmaller(int[] nums) {
        // 暴力解法行不通
//        List<Integer> res = new LinkedList<>();
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            int count = 0;
//            for (int j = i+1; j < n; j++) {
//                if (nums[i] > nums[j]) {
//                    count++;
//                }
//            }
//            res.add(count);
//        }
//        return res;
        int n = nums.length;
        count = new int[n];
        indexes = new int[n];
        tmp = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        merge_sort(nums, 0, n-1);
        List<Integer> res = new LinkedList<>();
        for (int c : count) {
            res.add(c);
        }
        return res;
    }

    private void merge_sort(int[] nums, int left, int right) {
        // 结束条件
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        merge_sort(nums, left, mid);
        merge_sort(nums, mid+1, right);
        int i = left, j = mid+1, pos = left;
        while (i <= mid && j <= right) {
            if (nums[indexes[i]] > nums[indexes[j]]) {
                tmp[pos++] = indexes[j++]; // 右指针胜出，当前位进入临时数组，下一位进行比较
            } else {
                count[indexes[i]] += j - mid - 1;
                tmp[pos++] = indexes[i++];
            }
        }
        // 左半边的剩余情况
        while (i <= mid) {
            count[indexes[i]] += j - mid - 1;
            tmp[pos++] = indexes[i++];
        }
        // 右半边
        while (j <= right) {
            tmp[pos++] = indexes[j++];
        }
        for (int k = left; k <= right; k++) {
            indexes[k] = tmp[k];
        }
    }
}
