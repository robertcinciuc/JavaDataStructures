package robertcinciuc.problems.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> tmp = new ArrayList<>();

        recursiveSearch(root, 0, tmp);

        List<List<Integer>> resp = new ArrayList<>();
        for(int i = tmp.size() - 1; i >= 0; i--){
            resp.add(tmp.get(i));
        }

        return resp;
    }

    public void recursiveSearch(TreeNode node, int lvl, List<List<Integer>> resp){
        if(node == null){
            return;
        }

        if(resp.size() <= lvl){
            resp.add(new ArrayList<>());
        }

        resp.get(lvl).add(node.val);

        recursiveSearch(node.left, lvl + 1, resp);
        recursiveSearch(node.right, lvl + 1, resp);
    }

}
