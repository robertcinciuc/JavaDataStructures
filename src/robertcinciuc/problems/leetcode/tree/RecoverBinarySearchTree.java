package robertcinciuc.problems.leetcode.tree;

public class RecoverBinarySearchTree {

    TreeNode first = null;
    TreeNode firstOrigin = null;

    TreeNode second = null;
    TreeNode secondOrigin = null;

    public void recoverTree(TreeNode root) {
        search(root, Long.MIN_VALUE, null, Long.MAX_VALUE, null);

        if(second == null){
            swap(first, firstOrigin);
        }else{
            if(firstOrigin.equals(secondOrigin)){
                swap(first, second);
            }else if(first == secondOrigin){
                swap(firstOrigin, second);
            }
        }
    }

    public void swap(TreeNode n1, TreeNode n2){
        int tmpVal = n1.val;
        n1.val = n2.val;
        n2.val = tmpVal;
    }

    public void search(TreeNode node, long min, TreeNode minFrom, long max, TreeNode maxFrom){
        if(node == null){
            return;
        }

        if(node.val > max){
            if(first == null){
                first = node;
                firstOrigin = maxFrom;
            }else{
                second = node;
                secondOrigin = maxFrom;
            }
        }

        if(node.val < min){
            if(first == null){
                first = node;
                firstOrigin = minFrom;
            }else{
                second = node;
                secondOrigin = minFrom;
            }
        }

        search(node.left, min, minFrom, node.val, node);

        search(node.right, node.val, node, max, maxFrom);
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
