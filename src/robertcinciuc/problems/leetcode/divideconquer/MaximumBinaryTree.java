package robertcinciuc.problems.leetcode.divideconquer;

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recursiveCreation(nums, 0, nums.length);
    }

    public TreeNode recursiveCreation(int[] nums, int start, int end){
        if(start >= end){
            return null;
        }

        int maxi = nums[start];
        int index = start;
        for(int i = start; i < end; i++){
            if(nums[i] > maxi){
                maxi = nums[i];
                index = i;
            }
        }

        TreeNode node = new TreeNode();
        node.val = maxi;

        node.left = recursiveCreation(nums, start, index);
        node.right = recursiveCreation(nums, index + 1, end);

        return node;
    }

    public static void main(String[] args) {
        var v = new MaximumBinaryTree();
        TreeNode treeNode = v.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println();
    }

}
