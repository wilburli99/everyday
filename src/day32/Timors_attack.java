package day32;

public class Timors_attack {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // 本质上是区间重叠问题
        // 如果间隔时间大于中毒的持续时间，那么就可以吃满；否则，就会重叠只持续间隔时间
        int total = 0;
        for (int i = 0; i < timeSeries.length-1; i++) {
            total += Math.min(duration, timeSeries[i+1] - timeSeries[i]);
        }
        total = total+duration;
        return total;
    }
}
