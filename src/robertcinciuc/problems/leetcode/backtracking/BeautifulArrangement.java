package robertcinciuc.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BeautifulArrangement {

    public int countArrangement(int n) {

        Set<List<Integer>> seen = new HashSet<>();
        List<Integer> current = new ArrayList<>();
        List<Integer> available = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            available.add(i);
        }

        return recursiveSearch(seen, current, available, 0);
    }

    public int recursiveSearch(Set<List<Integer>> seen, List<Integer> current, List<Integer> available, int index){
        if(available.size() == 0){
            return 1;
        }

        int nbWays = 0;
        for(int i = 0; i < available.size(); ++i){
            int tmp = available.get(i);
            if(tmp % (index + 1) == 0 || (index + 1) % tmp == 0){
                current.add(tmp);
                available.remove(i);

                if(!seen.contains(current)){
                    seen.add(new ArrayList<>(current));
                    nbWays += recursiveSearch(seen, current, available, index + 1);
                }

                available.add(i, tmp);
                current.remove(current.size() - 1);
            }
        }

        return nbWays;
    }

    public static void main(String[] args) {
        var v = new BeautifulArrangement();
        System.out.println(v.countArrangement(2));
    }
}
