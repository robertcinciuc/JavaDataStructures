package robertcinciuc.problems.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {

    public int minDistance(String word1, String word2) {

        StringBuilder w1 = new StringBuilder(word1);
        StringBuilder w2 = new StringBuilder(word2);
        int[] resp = new int[1];
        resp[0] = Integer.MAX_VALUE;
        Map<String, Integer> triedCombinations = new HashMap<>();

        recursiveSearch(w1, w2, 0, 0, 0, resp, triedCombinations);

        return resp[0];
    }

    public void recursiveSearch(StringBuilder w1, StringBuilder w2, int index1, int index2, int lvl, int[] resp, Map<String, Integer> triedCombinations){
        triedCombinations.put(w2.toString(), lvl);

//        stop condition
        if(w1.toString().equals(w2.toString()) && lvl < resp[0]){
            resp[0] = lvl;
            return;
        }

        if(index1 < w1.length() && index2 < w2.length()){
            if(w1.charAt(index1) == w2.charAt(index2)){
                recursiveSearch(w1, w2, index1 + 1, index2 + 1, lvl, resp, triedCombinations);
            }
        }

        if(index2 < w2.length() && index1 < w1.length()){
            char originalChar = w2.charAt(index2);

            w2.replace(index2, index2 + 1, String.valueOf(w1.charAt(index1)));
            if(!triedCombinations.containsKey(w2.toString()) || triedCombinations.get(w2.toString()) > lvl){
                recursiveSearch(w1, w2, index1 + 1, index2 + 1, lvl + 1, resp, triedCombinations);
            }
            w2.replace(index2, index2 + 1, String.valueOf(originalChar));
        }

        if(index1 < w1.length() && index2 <= w2.length()){
            w2.insert(index2, w1.charAt(index1));
            if(!triedCombinations.containsKey(w2.toString()) || triedCombinations.get(w2.toString()) > lvl){
                recursiveSearch(w1, w2, index1 + 1, index2 + 1, lvl + 1, resp, triedCombinations);
            }
            w2.delete(index2, index2 + 1);
        }

        if(index2 < w2.length()){
            char originalChar = w2.charAt(index2);

            w2.delete(index2, index2 + 1);
            if(!triedCombinations.containsKey(w2.toString()) || triedCombinations.get(w2.toString()) > lvl){
                recursiveSearch(w1, w2, index1, index2, lvl + 1, resp, triedCombinations);
            }
            w2.insert(index2, originalChar);
        }
    }

    public static void main(String[] args) {
        var v = new EditDistance();
        System.out.println(v.minDistance("a", "b"));
        System.out.println(v.minDistance("aa", "b"));
        System.out.println(v.minDistance("horse", "ros"));
        System.out.println(v.minDistance("intention", "execution"));
        System.out.println(v.minDistance("sea", "eat"));
    }
}
