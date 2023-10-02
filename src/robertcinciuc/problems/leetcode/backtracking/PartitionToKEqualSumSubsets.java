package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;

public class PartitionToKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        Map<Integer, Integer> left = new HashMap<>();
        for(int elem: nums){
            left.merge(elem, 1, Integer::sum);
        }

        List<Map<Integer, Integer>> current = new ArrayList<>();
        for(int i = 0; i < k; ++i){
            current.add(new HashMap<>());
        }

        return recursiveSearch(left, current, k);
    }

    public boolean recursiveSearch(Map<Integer, Integer> left, List<Map<Integer, Integer>> current, int k){
        if(allUsed(left) && allEqual(current)){
            return true;
        }

        for(Map.Entry<Integer, Integer> entry: left.entrySet()){
            if(entry.getValue() > 0){
//              put into existing
                for(Map<Integer, Integer> collect : current){
                    left.merge(entry.getKey(), 1, (prev, v) -> prev - v);
                    collect.merge(entry.getKey(), 1, Integer::sum);
                    boolean tmpResp = recursiveSearch(left, current, k);
                    if(tmpResp){
                        return true;
                    }
                    left.merge(entry.getKey(), 1, Integer::sum);
                    collect.merge(entry.getKey(), 1, (prev, v) -> prev - v);
                }
            }
        }

        return false;
    }

    private static boolean allUsed(Map<Integer, Integer> left){
        for(Map.Entry<Integer, Integer> entry: left.entrySet()){
            if(entry.getValue() > 0){
                return false;
            }
        }

        return true;
    }

    private static boolean allEqual(List<Map<Integer, Integer>> current){
        int tmp = 0;
        boolean first = true;
        for(Map<Integer, Integer> collection : current){
            int tmp1 = collection.entrySet().stream().map(e -> e.getValue() * e.getKey()).reduce(0, Integer::sum);
            if(first){
                first = false;
                tmp = tmp1;
            }

            if(tmp != tmp1){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        var v = new PartitionToKEqualSumSubsets();
        System.out.println(v.canPartitionKSubsets(new int[]{4,3,2,3,5,2,1}, 4));
        System.out.println(v.canPartitionKSubsets(new int[]{1,2,3,4}, 3));
    }
}
