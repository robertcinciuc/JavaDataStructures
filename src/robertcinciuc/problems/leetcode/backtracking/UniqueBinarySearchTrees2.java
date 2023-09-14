package robertcinciuc.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueBinarySearchTrees2 {

    public List<TreeNode> generateTrees(int n) {

        Set<TreeNode> resp = new HashSet<>();
        recursiveCreation(1, n + 1, resp, null, null, "");

        return filterSmallerTrees(resp, n);
    }

//    Start: inclusive; End: exclusive
    public void recursiveCreation(int start, int end, Set<TreeNode> resp, TreeNode root, TreeNode parent, String direction){
        if(start >= end){
            return;
        }

        for(int i = start; i < end; ++i){
            TreeNode current = new TreeNode();
            current.val = i;

            if(parent != null && !direction.isEmpty()){
                if(direction.equals("right")){
                    parent.right = current;
                }else{
                    parent.left = current;
                }
            }

            if(parent == null){
                root = current;
            }

            recursiveCreation(start, i, resp, root, current, "left");
            recursiveCreation(i + 1, end, resp, root, current, "right");

            if(current.left == null && current.right == null){
                resp.add(deepCopyNode(root));
            }

            if(parent == null){
                root = null;
            }
        }
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

    public static void main(String[] args) {
        var v = new UniqueBinarySearchTrees2();
        List<TreeNode> treeNodes = v.generateTrees(3);
        System.out.println();
    }
}
