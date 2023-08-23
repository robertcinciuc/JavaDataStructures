package robertcinciuc.problems.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> resp = new ArrayList<>();
        recursiveSearch(root, 0, resp);
        return resp;
    }

    public void recursiveSearch(TreeNode node, int lvl, List<List<Integer>> resp){
        if(node == null){
            return;
        }

        if(resp.size() <= lvl){
            resp.add(new ArrayList<>());
        }

        recursiveSearch(node.left, lvl + 1, resp);

        resp.get(lvl).add(node.val);

        recursiveSearch(node.right, lvl + 1, resp);
    }

}
