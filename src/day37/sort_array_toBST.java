package day37;

public class sort_array_toBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return resTree(nums, 0, nums.length-1);
    }

    private TreeNode resTree(int[] nums, int inleft, int inright) {
        if (inleft > inright) return null;
        int mid = inleft + (inright - inleft) / 2;
        TreeNode newTree = new TreeNode(nums[mid]);
        newTree.left = resTree(nums, inleft, mid-1);
        newTree.right = resTree(nums, mid+1, inright);
        return newTree;
    }
}
