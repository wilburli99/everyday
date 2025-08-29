package day47;

public class BST_LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 二叉搜索树：左子树的值<根值<右子树值
        int a = p.val, b = q.val;
        // 先保证a <= b
        if (a > b) {int t = a; a = b; b = t;}
        TreeNode cur = root;
        while (cur != null) {
            if (b < cur.val) { // 两个点都在当前节点左边
                cur = cur.left;
            } else if (a > cur.val) { // 两个点都在当前节点右边
                cur = cur.right;
            } else { // 分叉或者其中一个就是根节点
                return cur;
            }
        }
        return null;
    }
}
