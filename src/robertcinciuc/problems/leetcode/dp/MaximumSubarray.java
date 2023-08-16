package robertcinciuc.problems.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {

        List<List<Integer>> sums = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i){
            List<Integer> sums2 = new ArrayList<>();
            for(int j = i; j < nums.length; ++j){
                sums2.add(0);
            }
            sums.add(sums2);
        }

        for(int i = 0; i < nums.length; ++i){
            sums.get(i).set(0, nums[i]);
        }

        for(int delta = 1; delta < nums.length; ++delta){
            for(int i = 0; i < nums.length; i++){

                if(i + delta < sums.size()){

                    int val1 = sums.get(i).get(delta - 1) + sums.get(i + delta).get(0);
                    int val2 = sums.get(i + 1).get(delta-1) + sums.get(i).get(0);

                    sums.get(i).set(delta, Math.max(val1, val2));
                }
            }
        }

        int maxi = sums.get(0).get(0);
        for(int i = 0; i < sums.size(); ++i){
            for(int j = 0; j < sums.get(i).size(); ++j){
                if(sums.get(i).get(j) > maxi){
                    maxi = sums.get(i).get(j);
                }
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        var v = new MaximumSubarray();
        System.out.println(v.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(v.maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(v.maxSubArray(new int[]{1}));
        System.out.println(v.maxSubArray(new int[]{-2, -1}));
        System.out.println(v.maxSubArray(new int[]{-2,-3,-1}));
    }
}
