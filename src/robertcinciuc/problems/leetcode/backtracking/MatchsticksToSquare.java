package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        int sumedUp = Arrays.stream(matchsticks).reduce(0, Integer::sum);
        if(sumedUp % 4 != 0){
            return false;
        }

        Map<Integer, Integer> freq = buildFreq(matchsticks);
        List<Map<Integer, Integer>> current = new ArrayList<>();
        current.add(new HashMap<>());
        current.add(new HashMap<>());
        current.add(new HashMap<>());
        current.add(new HashMap<>());
        Set<List<Map<Integer, Integer>>> seen = new HashSet<>();
        List<Integer> sumOnSides = new ArrayList<>();
        sumOnSides.add(0);
        sumOnSides.add(0);
        sumOnSides.add(0);
        sumOnSides.add(0);

        return recursiveSearch(freq, seen, current, sumedUp / 4, sumOnSides);
    }

    public boolean recursiveSearch(Map<Integer, Integer> matchsticks, Set<List<Map<Integer, Integer>>> seen,
                                   List<Map<Integer, Integer>> current, int target, List<Integer> sumOnSides){
        if(allUsed(matchsticks)){
            return sidesEqual(current);
        }

        boolean found = false;
        for(Map.Entry<Integer, Integer>  matchstick: matchsticks.entrySet()){
            if(matchstick.getValue() > 0){

//              add to first side
                if(sumOnSides.get(0) < target){
                    current.get(0).merge(matchstick.getKey(), 1, Integer::sum);
                    matchstick.setValue(matchstick.getValue() - 1);
                    sumOnSides.set(0, sumOnSides.get(0) + matchstick.getKey());
                    if(!seen.contains(current) && sumOnSides.get(0) <= target){
                        seen.add(getCurrentCopy(current));
                        found = recursiveSearch(matchsticks, seen, current, target, sumOnSides);
                    }
                    matchstick.setValue(matchstick.getValue() + 1);
                    current.get(0).merge(matchstick.getKey(), 1, (prev, v) -> prev - v);
                    sumOnSides.set(0, sumOnSides.get(0) - matchstick.getKey());
                }

                if(!found && sumOnSides.get(1) < target){
//              add to second side
                    current.get(1).merge(matchstick.getKey(), 1, Integer::sum);
                    matchstick.setValue(matchstick.getValue() - 1);
                    sumOnSides.set(1, sumOnSides.get(1) + matchstick.getKey());
                    if(!seen.contains(current) && sumOnSides.get(1) <= target){
                        seen.add(getCurrentCopy(current));
                        found = recursiveSearch(matchsticks, seen, current, target, sumOnSides);
                    }
                    matchstick.setValue(matchstick.getValue() + 1);
                    current.get(1).merge(matchstick.getKey(), 1, (prev, v) -> prev - v);
                    sumOnSides.set(1, sumOnSides.get(1) - matchstick.getKey());
                }

                if(!found && sumOnSides.get(2) < target){
//               add to third side
                    current.get(2).merge(matchstick.getKey(), 1, Integer::sum);
                    matchstick.setValue(matchstick.getValue() - 1);
                    sumOnSides.set(2, sumOnSides.get(2) + matchstick.getKey());
                    if(!seen.contains(current) && sumOnSides.get(2) <= target){
                        seen.add(getCurrentCopy(current));
                        found = recursiveSearch(matchsticks, seen, current, target, sumOnSides);
                    }
                    matchstick.setValue(matchstick.getValue() + 1);
                    current.get(2).merge(matchstick.getKey(), 1, (prev, v) -> prev - v);
                    sumOnSides.set(2, sumOnSides.get(2) - matchstick.getKey());
                }

                if(!found && sumOnSides.get(3) < target){
//              add to fourth side
                    current.get(3).merge(matchstick.getKey(), 1, Integer::sum);
                    matchstick.setValue(matchstick.getValue() - 1);
                    sumOnSides.set(3, sumOnSides.get(3) + matchstick.getKey());
                    if(!seen.contains(current) && sumOnSides.get(3) <= target){
                        seen.add(getCurrentCopy(current));
                        found = recursiveSearch(matchsticks, seen, current, target, sumOnSides);
                    }
                    matchstick.setValue(matchstick.getValue() + 1);
                    current.get(3).merge(matchstick.getKey(), 1, (prev, v) -> prev - v);
                    sumOnSides.set(3, sumOnSides.get(3) - matchstick.getKey());
                }

                if(found){
                    return true;
                }
            }
        }

        return found;
    }

    private static boolean allUsed(Map<Integer, Integer> matchsticks){
        for(Map.Entry<Integer, Integer>  matchstick: matchsticks.entrySet()){
            if(matchstick.getValue() > 0){
                return false;
            }
        }

        return true;
    }

    private static boolean sidesEqual(List<Map<Integer, Integer>> current){
        int length1 = current.get(0).entrySet().stream().map(e -> e.getKey() * e.getValue()).reduce(0, Integer::sum);
        int length2 = current.get(1).entrySet().stream().map(e -> e.getKey() * e.getValue()).reduce(0, Integer::sum);
        int length3 = current.get(2).entrySet().stream().map(e -> e.getKey() * e.getValue()).reduce(0, Integer::sum);
        int length4 = current.get(3).entrySet().stream().map(e -> e.getKey() * e.getValue()).reduce(0, Integer::sum);

        return length1 == length2 && length2 == length3 && length3 == length4;
    }

    private static Map<Integer, Integer> buildFreq(int[] matchsticks){
        Map<Integer, Integer> freq = new HashMap<>();
        for(int stick: matchsticks){
            freq.merge(stick, 1, Integer::sum);
        }
        return freq;
    }

    private static List<Map<Integer, Integer>> getCurrentCopy(List<Map<Integer, Integer>> current){
        List<Map<Integer, Integer>> arr = new ArrayList<>();
        arr.add(current.get(0).entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue())));
        arr.add(current.get(1).entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue())));
        arr.add(current.get(2).entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue())));
        arr.add(current.get(3).entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue())));
        return arr;
    }

    public static void main(String[] args) {
        var v = new MatchsticksToSquare();
        System.out.println(v.makesquare(new int[]{1,1,2,2,2}));
        System.out.println(v.makesquare(new int[]{3,3,3,3,4}));
    }
}
