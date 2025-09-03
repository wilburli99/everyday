package day50;

public class Max_BT {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return BST(nums, 0, nums.length-1);
    }

    private TreeNode BST(int[] nums, int inleft, int inright) {
        if (inleft > inright) return null;
        int maxInt = inleft;
        for (int i = inleft + 1; i <= inright; i++) {
            if (nums[i] > nums[maxInt]) {
                maxInt = i;
            }
        }
        // 用最大数分隔
        TreeNode root = new TreeNode(nums[maxInt]);
        root.left = BST(nums, inleft, maxInt-1);
        root.right = BST(nums, maxInt+1, inright);
        return root;
    }
}
