package day36;

import java.util.HashMap;
import java.util.Map;

public class build_tree2 {
    private Map<Integer, Integer> inorderIndexMap;
    private int postorderIndex;
    public tree_node.TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderIndexMap = new HashMap<>();
        postorderIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return resRoot(postorder, 0, postorder.length-1);
    }

    private tree_node.TreeNode resRoot(int[] postorder, int inleft, int inright) {
        if (inleft > inright) return null;
        // 从后序最后一个开始作为根
        int rootNode = postorder[postorderIndex--];
        tree_node.TreeNode root = new tree_node.TreeNode(rootNode);
        int index = inorderIndexMap.get(rootNode);
        // 从尾部构建，顺序是右子树，再左子树
        root.right = resRoot(postorder, index+1, inright);
        root.left = resRoot(postorder, inleft, index-1);
        return root;
    }
}
