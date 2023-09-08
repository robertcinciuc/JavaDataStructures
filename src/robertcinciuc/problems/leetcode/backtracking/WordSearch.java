package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;

public class WordSearch {
    public static class Pair{
        public final int x;
        public final int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean exist(char[][] board, String word) {

        Map<Character, Integer> wordFreq = new HashMap<>();
        for(int i = 0; i < word.length(); ++i){
            wordFreq.merge(word.charAt(i), 1, Integer::sum);
        }
        Map<Character, Integer> boardFreq = new HashMap<>();
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                boardFreq.merge(board[i][j], 1, Integer::sum);
            }
        }

        for(Character car: wordFreq.keySet()){
            if(!boardFreq.containsKey(car) || boardFreq.get(car) < wordFreq.get(car)){
                return false;
            }
        }

        List<Pair> startPlaces = findStart(board, word);
        Set<List<Pair>> seen = new HashSet<>();
        List<Pair> current = new ArrayList<>();
        boolean[][] available = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                available[i][j] = true;
            }
        }

        boolean foundWord = false;
        for(Pair start: startPlaces){
            current.add(start);
            available[start.x][start.y] = false;
            foundWord = recursiveSearch(start.x, start.y, 0, word, board, seen, current, available);
            available[start.x][start.y] = true;

            if(foundWord){
                break;
            }
        }

        return foundWord;
    }

    public List<Pair> findStart(char[][] board, String word){
        List<Pair> resp = new ArrayList<>();
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(board[i][j] == word.charAt(0)){
                    resp.add(new Pair(i, j));
                }
            }
        }

        return resp;
    }

    public boolean recursiveSearch(int x, int y, int index, String word, char[][] board, Set<List<Pair>> seen, List<Pair> current, boolean[][] available){
        if(index == word.length() - 1){
            return true;
        }

        if(index >= word.length()){
            return false;
        }

        boolean topSearch = false;
        boolean rightSearch = false;
        boolean botSearch = false;
        boolean leftSearch = false;
        if(x > 0 && board[x - 1][y] == word.charAt(index + 1) && available[x - 1][y]){
            current.add(new Pair(x - 1 , y));
            if(!seen.contains(current)){
                seen.add(new ArrayList<>(current));
                available[x - 1][y] = false;
                topSearch = recursiveSearch(x -1 , y, index + 1, word, board, seen, current, available);
                current.remove(current.size() - 1);
                available[x - 1][y] = true;
            }
        }

        if(y < board[0].length - 1 && board[x][y + 1] == word.charAt(index + 1) && available[x][y + 1]){
            current.add(new Pair(x, y + 1));
            if(!seen.contains(current)){
                seen.add(new ArrayList<>(current));
                available[x][y + 1] = false;
                rightSearch = recursiveSearch(x, y + 1, index + 1, word, board, seen, current, available);
                current.remove(current.size() - 1);
                available[x][y + 1] = true;
            }
        }

        if(x < board.length - 1 && board[x + 1][y] == word.charAt(index + 1) && available[x + 1][y]){
            current.add(new Pair(x + 1, y));
            if(!seen.contains(current)){
                seen.add(new ArrayList<>(current));
                available[x + 1][y] = false;
                botSearch = recursiveSearch(x + 1, y, index + 1, word, board, seen, current, available);
                current.remove(current.size() - 1);
                available[x + 1][y] = true;
            }
        }

        if(y > 0 && board[x][y - 1] == word.charAt(index + 1) && available[x][y - 1]){
            current.add(new Pair(x , y - 1));
            if(!seen.contains(current)){
                seen.add(new ArrayList<>(current));
                available[x][y - 1] = false;
                leftSearch = recursiveSearch(x , y - 1, index + 1, word, board, seen, current, available);
                current.remove(current.size() - 1);
                available[x][y - 1] = true;
            }
        }

        return topSearch || rightSearch || botSearch || leftSearch;
    }
}
