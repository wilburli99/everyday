package day36;

import java.util.HashMap;
import java.util.Map;

public class build_tree1 {
    private Map<Integer, Integer> inorderIndexMap;
    private int preoderIndex;
    public tree_node.TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        preoderIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return resRoot(preorder, 0, preorder.length-1);
    }

    private tree_node.TreeNode resRoot(int[] preorder, int inleft, int inright) {
        // 结束条件
        if (inleft > inright) return null;
        // 从前序遍历中去当前节点为根节点
        int rootNode = preorder[preoderIndex++];
        tree_node.TreeNode root = new tree_node.TreeNode(rootNode);
        // 从中序遍历中划分左右子树
        int index = inorderIndexMap.get(rootNode);
        // 开始递归
        root.left = resRoot(preorder, inleft, index-1);
        root.right = resRoot(preorder, index+1, inright);

        return root;
    }
}
