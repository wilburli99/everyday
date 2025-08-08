package day39;

public class bulid_BST_acc_preandpos {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build_BST(preorder, 0, preorder.length-1
                , postorder, 0, postorder.length-1);
    }
    private TreeNode build_BST(int[] preorder, int preL, int preR
            , int[] postorder, int postL, int postR) {

        if (preL > preR) return null;
        TreeNode root = new TreeNode(preorder[preL]);
        if (preL == preR) return root; // 只有一个节点
        // 在前序找左子树根的值
        int leftPreVal = preorder[preL+1];
        // 在后续中找到这个值的位置
        int index = postL;
        while (postorder[index] != leftPreVal) index++;
        int leftSize = index - postL + 1;
        // 构建左子树
        root.left = build_BST(preorder, preL+1, preL+leftSize,
                postorder, postL, index);
        // 构建右子树
        root.right = build_BST(preorder, preL+leftSize+1, preR,
                postorder, index+1, postR-1);
        return root;
    }
}
