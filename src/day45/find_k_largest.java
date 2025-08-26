package day45;

import java.util.PriorityQueue;

public class find_k_largest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : nums) {
            pq.offer(x);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
