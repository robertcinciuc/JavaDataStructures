package robertcinciuc.problems.hanoi.towers;

import java.util.*;

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

    public static Map<Integer, List<Integer>> moveStackToFromHackerRank(
            int currPos, int destPos, Map<Integer, List<Integer>> towers, int depth, Map<Integer, String> towerLetters){
        int levelToRemove = towers.get(currPos).size() - depth;
        Integer elemToMove = towers.get(currPos).remove(levelToRemove);

        if(elemToMove != 1){
            int nextDestPos = 3 - currPos - destPos;
            moveStackToFromHackerRank(currPos, nextDestPos, towers, depth - 1, towerLetters);
        }

        System.out.println("Moving ring " + elemToMove + " from " + towerLetters.get(currPos) + " to " + towerLetters.get(destPos));
        towers.get(destPos).add(elemToMove);

        if(elemToMove != 1){
            int nextBaseElemPos = 3 - currPos - destPos;
            moveStackToFromHackerRank(nextBaseElemPos, destPos, towers, depth - 1, towerLetters);
        }

        return towers;
    }

    public static Map<Integer, List<Integer>> moveStackToFromOptimized(
            int currPos, int destPos, Map<Integer, List<Integer>> towers, int depth, Map<Integer, HanoiSubResult> subResultMap){
        int levelToRemove = towers.get(currPos).size() - depth;
        Integer elemToMove = towers.get(currPos).remove(levelToRemove);

        if(subResultMap.containsKey(elemToMove) && subResultMap.get(elemToMove).isDone()){
            HanoiSubResult hanoiSubResult = subResultMap.get(elemToMove);
            executeGivenMoves(currPos, towers, depth, hanoiSubResult);
        }else{
            HanoiSubResult hanoiSubResult = new HanoiSubResult(currPos, destPos);
            subResultMap.put(elemToMove, hanoiSubResult);

            if (elemToMove != 1) {
                int nextDestPos = 3 - currPos - destPos;
                moveStackToFromOptimized(currPos, nextDestPos, towers, depth - 1, subResultMap);
            }

            towers.get(destPos).add(elemToMove);
            Move newMove = new Move(depth, currPos, destPos);
            hanoiSubResult.getMoves().add(0, newMove);
            hanoiSubResult.setDone(true);


            if (elemToMove != 1) {
                int nextBaseElemPos = 3 - currPos - destPos;
                moveStackToFromOptimized(nextBaseElemPos, destPos, towers, depth - 1, subResultMap);
            }
        }

        return towers;
    }

    public static void executeGivenMoves(int stackCurrPos, Map<Integer, List<Integer>> towers, int depth, HanoiSubResult hanoiSubResult){
        for(Move move : hanoiSubResult.getMoves()){
            int levelToRemove = towers.get(stackCurrPos).size() - depth;
            Integer elemToMove = towers.get(stackCurrPos).remove(levelToRemove);
            int destPos = (stackCurrPos + move.getDeltaDestPos()) % 3;
            towers.get(destPos).add(elemToMove);
        }
    }

    public static void main(String[] args){
        Map<Integer, List<Integer>> towers = new HashMap<>();

        List<Integer> tower0 = new ArrayList<>();
        List<Integer> tower1 = new ArrayList<>();
        List<Integer> tower2 = new ArrayList<>();

//        tower0.add(8);
//        tower0.add(7);
//        tower0.add(6);
//        tower0.add(5);
        tower0.add(4);
        tower0.add(3);
        tower0.add(2);
        tower0.add(1);

        towers.put(0, tower0);
        towers.put(1, tower1);
        towers.put(2, tower2);

////        Base unoptimized case
//        System.out.println(towers);
//        HanoiTowers.moveStackToFrom(0, 2, towers, tower0.size());
//        System.out.println(towers);

////        Unfinished optimized case
//        System.out.println(towers);
//        Map<Integer, HanoiSubResult> subResultMap = new HashMap<>();
//        HanoiTowers.moveStackToFromOptimized(0, 2, towers, tower0.size(), subResultMap);

//        HackerRank version
        Map<Integer, String> towerLetters = new HashMap<>();
        towerLetters.put(0, "A");
        towerLetters.put(1, "B");
        towerLetters.put(2, "C");
        System.out.println(towers);
        HanoiTowers.moveStackToFromHackerRank(0, 2, towers, tower0.size(), towerLetters);
        System.out.println(towers);
    }
}
