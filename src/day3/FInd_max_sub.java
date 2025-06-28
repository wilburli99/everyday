package day3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FInd_max_sub {
    public int[] maxSubsequence(int[] nums, int k) {
        // 1. 优先队列
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
//            // 如果数值不相等，则按照数值大小进行排序；如果数值相等，则按照索引大小进行排序
//                if (a[0] != b[0]) {
//                    return a[0] - b[0];
//                }
//                return a[1] - b[1];
//        });
//        // 遍历数组，将元素和索引加入优先队列
//        for (int i = 0; i < nums.length; i++) {
//            pq.offer(new int[]{nums[i],i});
//            if (pq.size()>k) {
//                pq.poll(); // 弹出最小的元素
//            }
//        }
//        // 提取索引并排序，保持原数组的顺序
//        int[] indices = new int[k];
//        for (int i = 0; i < k; i++) {
//            indices[i] = pq.poll()[1];
//        }
//        Arrays.sort(indices);
//        // 根据索引构建结果数组
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) {
//            res[i] = nums[indices[i]];
//        }
//        return res;
        // 2. 二维数组+部分排序
        int n = nums.length;
        int[][] arr = new int[n][2]; // 二维数组存储索引和值
        for (int i = 0; i < n; i++) {
            arr[i][0] = i; // 索引
            arr[i][1] = nums[i]; // 值
        }
        // 按照数值降序排序
        Arrays.sort(arr,(a,b) -> Integer.compare(b[1],a[1]));
        // 取前k个元素并按照下标升序排序
        Arrays.sort(arr,0,k,(a,b) -> Integer.compare(a[0],b[0]));
        // 构建目标子序列
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i][1];
        }
        return res;
    }
}
