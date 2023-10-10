package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class IteratorForCombination {
    private List<String> words = new ArrayList<>();
    private int index = 0;

    public IteratorForCombination(String characters, int combinationLength) {
        boolean[] used = new boolean[characters.length()];
        StringBuilder sb = new StringBuilder();
        Set<String> seen = new HashSet<>();
        recursiveSearch(characters, used, sb, seen, combinationLength, 0);

        seen.stream().collect(Collectors.toCollection(() -> words));
        Collections.sort(words);
    }

    public String next() {
        String resp = null;
        if(index < words.size()){
            resp = words.get(index);
            index++;
        }
        return resp;
    }

    public boolean hasNext() {
        return index < words.size();
    }

    private static void recursiveSearch(String tiles, boolean[] used, StringBuilder current, Set<String> seen, int len, int index){
        String currentString = current.toString();
        if(seen.contains(currentString)){
            return;
        }

        if(!currentString.isEmpty() && currentString.length() == len){
            seen.add(currentString);
        }

        for(int i = index; i < used.length; ++i){
            if(used[i]){
                continue;
            }
            used[i] = true;

            current.append(tiles.charAt(i));
            recursiveSearch(tiles, used, current, seen, len, i + 1);
            current.delete(current.length() - 1, current.length());

            used[i] = false;
        }
    }
}
