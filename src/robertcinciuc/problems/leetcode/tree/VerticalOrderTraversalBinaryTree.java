package robertcinciuc.problems.leetcode.tree;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversalBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
        }
    }

    public static class DepthNode {
        int val;
        int depth;

        public DepthNode(int val, int depth){
            this.val = val;
            this.depth = depth;
        }
    }

    public static class NodeDepthComparator implements Comparator<DepthNode>{

        @Override
        public int compare(DepthNode o1, DepthNode o2) {
            if(o1 == null || o2 == null){
                throw new IllegalArgumentException("Can't compare null objects");
            }

            if(o1.depth < o2.depth){
                return -1;
            }else if(o1.depth > o2.depth){
                return 1;
            }else{
                if(o1.val < o2.val){
                    return -1;
                }else if(o1.val > o2.val){
                    return 1;
                }
                return 0;
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<DepthNode>> rawResult = new HashMap<>();
        traversal(root, 0, 0, rawResult);

        Map<Integer, List<Integer>> transformedResult = new HashMap<>(rawResult.size());
        for(Integer index: rawResult.keySet()) {
            List<DepthNode> depthNodes = rawResult.get(index);
            depthNodes.sort(new NodeDepthComparator());
            transformedResult.put(index, depthNodes.stream().map(e -> e.val).collect(Collectors.toList()));
        }

        int minIndex = getMinIndex(rawResult);
        List<List<Integer>> result = new ArrayList<>(rawResult.size());
        for(int i = minIndex; i <= minIndex * -2; ++i){
            if(transformedResult.get(i) != null){
                result.add(i - minIndex, transformedResult.get(i).stream().filter(Objects::nonNull).collect(Collectors.toList()));
            }
        }

        return result;
    }

    private int getMinIndex(Map<Integer, List<DepthNode>> rawResult) {
        int min = 0;
        for(Integer index: rawResult.keySet()){
            if(index < min){
                min = index;
            }
        }
        return min;
    }

    public void traversal(TreeNode node, int index, int depth, Map<Integer, List<DepthNode>> rawResult){
        rawResult.putIfAbsent(index, new ArrayList<>());
        rawResult.get(index).add(new DepthNode(node.val, depth));
        if(node.left != null){
            traversal(node.left, index - 1, depth + 1, rawResult);
        }
        if(node.right != null){
            traversal(node.right, index + 1, depth + 1, rawResult);
        }
    }

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode();
        treeNode.val = 3;
        TreeNode treeNodel = new TreeNode();
        treeNodel.val = 9;
        TreeNode treeNoder = new TreeNode();
        treeNoder.val = 20;
        treeNode.left = treeNodel;
        treeNode.right = treeNoder;
        TreeNode treeNoderl = new TreeNode();
        treeNoderl.val = 15;
        TreeNode treeNoderr = new TreeNode();
        treeNoderr.val = 7;
        treeNoder.left = treeNoderl;
        treeNoder.right = treeNoderr;

        VerticalOrderTraversalBinaryTree verticalTraversal = new VerticalOrderTraversalBinaryTree();
        System.out.println(verticalTraversal.verticalTraversal(treeNode));
    }
}
