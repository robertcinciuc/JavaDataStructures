package robertcinciuc.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HanoiTowers {

    public static Map<Integer, List<Integer>> moveStackToFrom(
            int currPos, int destPos, Map<Integer, List<Integer>> towers, int depth){
        int levelToRemove = towers.get(currPos).size() - depth;
        Integer elemToMove = towers.get(currPos).remove(levelToRemove);

        if(elemToMove != 1){
            int nextDestPos = 3 - currPos - destPos;
            moveStackToFrom(currPos, nextDestPos, towers, depth - 1);
        }

        towers.get(destPos).add(elemToMove);

        if(elemToMove != 1){
            int nextBaseElemPos = 3 - currPos - destPos;
            moveStackToFrom(nextBaseElemPos, destPos, towers, depth - 1);
        }

        return towers;
    }

    public static void main(String[] args){
        Map<Integer, List<Integer>> towers = new HashMap<>();

        List<Integer> tower0 = new ArrayList<>();
        List<Integer> tower1 = new ArrayList<>();
        List<Integer> tower2 = new ArrayList<>();

        tower0.add(8);
        tower0.add(7);
        tower0.add(6);
        tower0.add(5);
        tower0.add(4);
        tower0.add(3);
        tower0.add(2);
        tower0.add(1);

        towers.put(0, tower0);
        towers.put(1, tower1);
        towers.put(2, tower2);

        System.out.println(towers);
        HanoiTowers.moveStackToFrom(0, 2, towers, tower0.size());
        System.out.println(towers);
    }
}
