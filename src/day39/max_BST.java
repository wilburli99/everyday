package day39;

public class max_BST {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        return max_BST(nums, 0, n-1);
    }

    private TreeNode max_BST(int[] nums, int inleft, int inright) {
        if (inleft > inright) return null;
        int maxIndex = inleft;
        //  找到最大值进行分割
        for (int i = inleft+1; i <= inright; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = max_BST(nums, inleft, maxIndex-1);
        root.right = max_BST(nums, maxIndex+1, inright);
        return root;
    }
}
