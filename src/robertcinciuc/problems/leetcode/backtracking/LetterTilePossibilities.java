package robertcinciuc.problems.leetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        boolean[] used = new boolean[tiles.length()];
        StringBuilder sb = new StringBuilder();
        Set<String> seen = new HashSet<>();

        recursiveSearch(tiles, used, sb, seen);

        return seen.size();
    }

    private static void recursiveSearch(String tiles, boolean[] used, StringBuilder current, Set<String> seen){
        String currentString = current.toString();
        if(seen.contains(currentString)){
            return;
        }

        if(!currentString.isEmpty()){
            seen.add(currentString);
        }

        for(int i = 0; i < used.length; ++i){
            if(used[i]){
                continue;
            }
            used[i] = true;

            if(currentString.isEmpty()){
                current.append(tiles.charAt(i));
                recursiveSearch(tiles, used, current, seen);
                current.delete(current.length() - 1, current.length());
            }else{
                for(int j = 0; j < currentString.length(); ++j){
                    current.insert(j, tiles.charAt(i));
                    recursiveSearch(tiles, used, current, seen);
                    current.delete(j, j + 1);
                }
            }

            used[i] = false;
        }
    }
}
