package robertcinciuc.problems.leetcode.backtracking;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueBinarySearchTrees2 {

    public List<TreeNode> generateTrees(int n) {

        Set<TreeNode> resp = recursiveCreation(1, n + 1, null);

        return filterSmallerTrees(resp, n);
    }

//    Start: inclusive; End: exclusive
    public Set<TreeNode> recursiveCreation(int start, int end, TreeNode root){
        if(start >= end){
            HashSet<TreeNode> objects = new HashSet<>();
            objects.add(null);
            return objects;
        }

        Set<TreeNode> currentResponse = new HashSet<>();
        for(int i = start; i < end; ++i){
            TreeNode current = new TreeNode();
            current.val = i;

            boolean chancedRoot = false;
            if(root == null){
                root = current;
                chancedRoot = true;
            }

            Set<TreeNode> leftList = recursiveCreation(start, i, root);
            Set<TreeNode> rightList = recursiveCreation(i + 1, end, root);
            currentResponse.addAll(combine(leftList, rightList, current));

            if(chancedRoot){
                root = null;
            }
        }

        return currentResponse;
    }

    private static TreeNode deepCopyNode(TreeNode treeNode){
        if(treeNode == null){
            return null;
        }

        TreeNode newNode = new TreeNode();
        newNode.val = treeNode.val;
        newNode.left = deepCopyNode(treeNode.left);
        newNode.right = deepCopyNode(treeNode.right);

        return newNode;
    }

    private static List<TreeNode> filterSmallerTrees(Set<TreeNode> trees, int n){
        List<TreeNode> resp = new ArrayList<>();

        for(TreeNode tree: trees){
            if(countChildren(tree) == n){
                resp.add(tree);
            }
        }

        return resp;
    }

    private static int countChildren(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }

        int left = countChildren(treeNode.left);
        int right = countChildren(treeNode.right);
        return left + right + 1;
    }

    private static Set<TreeNode> combine(Set<TreeNode> leftList, Set<TreeNode> rightList, TreeNode treeNode){
        Set<TreeNode> combined = new HashSet<>();

        for(TreeNode left: leftList){
            for(TreeNode right: rightList){
                TreeNode newTreeNode = new TreeNode();
                newTreeNode.val = treeNode.val;
                newTreeNode.left = deepCopyNode(left);
                newTreeNode.right = deepCopyNode(right);
                combined.add(newTreeNode);
            }
        }

        return combined;
    }

    public static void main(String[] args) {
        var v = new UniqueBinarySearchTrees2();
        List<TreeNode> treeNodes = v.generateTrees(3);
        System.out.println();
    }
}
