package robertcinciuc.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return List.of();
        }

        List<List<Integer>> resp = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        recursiveSearch(0, root, resp, current, targetSum);

        return resp;
    }

    public void recursiveSearch(int sum, TreeNode current, List<List<Integer>> resp, List<Integer> currentList, int targetSum){
        if(current == null){
            return;
        }

        currentList.add(current.val);

        if(current.left == null && current.right == null && (sum + current.val == targetSum)){
            resp.add(new ArrayList<>(currentList));
        }

        recursiveSearch(sum + current.val, current.left, resp, currentList, targetSum);
        recursiveSearch(sum + current.val, current.right, resp, currentList, targetSum);
        currentList.remove(currentList.size() - 1);
    }

    public static void main(String[] args) {

    }
}
