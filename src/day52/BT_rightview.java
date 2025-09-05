package day52;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BT_rightview {
    public List<Integer> rightSideView(TreeNode root) {
        // 使用BFS搜索，每一层最后一个点为右侧的节点
        List<Integer> res = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        // 使用队列加入每层的点,第一层
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size-1) { // 当前层的最后一个
                    res.add(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }
}
