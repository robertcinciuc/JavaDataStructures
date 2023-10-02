package robertcinciuc.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> seen = new HashMap<>();

        return recursiveSearch(price, special, needs, 0, seen);
    }

    public int recursiveSearch(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int sum, Map<List<Integer>, Integer> seen){
        if(sufficientCount(needs)){
            return sum;
        }

        int sumResp = Integer.MAX_VALUE;
        for(int i = 0; i < needs.size(); ++i){
            if(needs.get(i) <= 0){
                continue;
            }

//            take from price
            int tmpSum1 = sum + price.get(i);
            needs.set(i, needs.get(i) - 1);
            if(!seen.containsKey(needs) || seen.get(needs) >= sum){
                seen.put(new ArrayList<>(needs), sum);
                int sumRes1Tmp = recursiveSearch(price, special, needs, tmpSum1, seen);

                if(sumRes1Tmp < sumResp){
                    sumResp = sumRes1Tmp;
                }
            }
            needs.set(i, needs.get(i) + 1);

//            take from special
            for(int j = 0; j < special.size(); ++j){
                if(special.get(j).get(i) <= 0){
                    continue;
                }

                int tmpSum2 = sum + special.get(j).get(special.get(j).size() - 1);
                for(int k = 0; k < special.get(j).size() - 1; ++k){
                    needs.set(k, needs.get(k) - special.get(j).get(k));
                }
                int sumRes2Tmp = sumResp;
                if(!seen.containsKey(needs) || seen.get(needs) >= sum){
                    seen.put(new ArrayList<>(needs), sum);
                    sumRes2Tmp = recursiveSearch(price, special, needs, tmpSum2, seen);
                }
                for(int k = 0; k < special.get(j).size() - 1; ++k){
                    needs.set(k, needs.get(k) + special.get(j).get(k));
                }

                if(sumRes2Tmp < sumResp){
                    sumResp = sumRes2Tmp;
                }
            }
        }

        return sumResp;
    }

    private static boolean sufficientCount(List<Integer> needs){
        for(int elem: needs){
            if(elem != 0){
                return false;
            }
        }

        return true;
    }
}
