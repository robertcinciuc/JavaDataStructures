package robertcinciuc.problems.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resp = new ArrayList<>();
        recursiveSearch(root, 0, resp);
        return resp;
    }

    public void recursiveSearch(TreeNode node, int lvl, List<List<Integer>> resp){
        if(node == null){
            return;
        }

        if(resp.size() <= lvl){
            resp.add(new LinkedList<>());
        }

        recursiveSearch(node.left, lvl + 1, resp);

        if(lvl % 2 ==0){
            resp.get(lvl).add(node.val);
        }else{
            List<Integer> items = resp.get(lvl);
            ((LinkedList<Integer>)items).addFirst(node.val);
        }

        recursiveSearch(node.right, lvl + 1, resp);
    }

}
