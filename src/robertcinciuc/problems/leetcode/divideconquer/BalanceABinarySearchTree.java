package robertcinciuc.problems.leetcode.divideconquer;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {

    public TreeNode balanceBST(TreeNode root) {

        List<Integer> nodes = new ArrayList<>();
        inOrderTraversal(root, nodes);

        return recursiveCreation(nodes, 0, nodes.size());
    }

    public void inOrderTraversal(TreeNode node, List<Integer> nodes){
        if(node == null){
            return;
        }

        inOrderTraversal(node.left, nodes);
        nodes.add(node.val);
        inOrderTraversal(node.right, nodes);
    }

    public TreeNode recursiveCreation(List<Integer> nodes, int start, int end){
        if(start >= end){
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode newNode = new TreeNode(nodes.get(mid));
        newNode.left = recursiveCreation(nodes, start, mid);
        newNode.right = recursiveCreation(nodes, mid + 1, end);

        return newNode;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode right2 = new TreeNode(3);
        TreeNode right3 = new TreeNode(4);

        root.right = right;
        right.right = right2;
        right2.right = right3;

        var v = new BalanceABinarySearchTree();
        TreeNode treeNode = v.balanceBST(root);
        System.out.println();
    }
}
