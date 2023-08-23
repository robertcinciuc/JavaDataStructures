package robertcinciuc.problems.leetcode.tree;

public class RecoverBinarySearchTree {

    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        search(root);
        swap(first, second);
    }

    public void swap(TreeNode n1, TreeNode n2){
        int tmpVal = n1.val;
        n1.val = n2.val;
        n2.val = tmpVal;
    }

    public void search(TreeNode node){
        if(node == null){
            return;
        }

        search(node.left);

        if(prev != null && prev.val > node.val){
            if(first == null)
                first = prev;
            second = node;
        }

        prev = node;

        search(node.right);
    }

    public static void main(String[] args) {
        var v = new RecoverBinarySearchTree();

        TreeNode root = new TreeNode();
        root.val = 2;

        TreeNode left = new TreeNode();
        left.val = 3;
        TreeNode right = new TreeNode();
        right.val = 1;

        root.left = left;
        root.right = right;

        v.recoverTree(root);
    }
}
