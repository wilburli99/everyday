package day48;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class find_course_order {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // 为每门课建立一个空的出边列表，后面把“pre->course”挂进去
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // 统计入度
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int pre = edge[1];
            graph.get(pre).add(course);// pre -> course
            indegree[course]++; // 表明course多了一个前置
        }
        // 队列存放入度为0的课程
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll(); // cur出队，加入结果顺序
            order[index++] = cur;

            for (int next : graph.get(cur)) { // cur的后序
                indegree[next]--; // 度数-1
                if (indegree[next] == 0) { // 如果度数为0，入队
                    queue.offer(next);
                }
            }
        }
        // 如果能排完所有课程
        if (index == numCourses) {
            return order;
        } else {
            return new int[0]; // 存在环，无法完成所有课程
        }
    }
}
