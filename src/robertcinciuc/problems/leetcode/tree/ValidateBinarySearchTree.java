package robertcinciuc.problems.leetcode.tree;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {

        if(root == null){
            return true;
        }

        return validateTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validateTree(TreeNode node, long min, long max){
        boolean currentIsValid = true;
        if(node.val <= min || node.val >= max){
            currentIsValid = false;
        }

        if(!currentIsValid){
            return false;
        }

        boolean left = true;
        if(node.left != null){
           left = validateTree(node.left, min, node.val);
        }

        boolean right = true;
        if(node.right != null){
            right = validateTree(node.right, node.val, max);
        }

        return left && right;
    }

    public static void main(String[] args) {
        var v = new ValidateBinarySearchTree();
        System.out.println(v.isValidBST(null));
    }
}
