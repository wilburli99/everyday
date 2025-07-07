package day12;

import java.util.Arrays;
import java.util.PriorityQueue;

public class max_sessionNum {
    public int maxEvents(int[][] events) {
        // 按照起始时间排序
        Arrays.sort(events,(a, b) -> Integer.compare(a[0], b[0]));
        // 最小堆存储endDay
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int day = 1, i = 0, res = 0;
        int n = events.length;
        // 找出所有天数的最大值
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }
        // 从第一天到第Max天进行遍历
        while (day <= maxDay) {
            // 把所有今天开始的会议加入堆
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }
            // 移除所有已经结束的会议
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
            // 如果堆非空，则选择结束时间最早的会议
            if (!pq.isEmpty()) {
                pq.poll(); // 参加会议
                res++;
            }
            day++;
        }
        return res;
    }
}
