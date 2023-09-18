package robertcinciuc.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        if(s.isEmpty()){
            return List.of();
        }

        Set<List<String>> allCombinations = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        List<String> wordsUntilNow = new ArrayList<>();
        recursiveSearch(sb, wordsUntilNow, 0, allCombinations, s);

        return filterNonPalindrome(allCombinations);
    }

    public void recursiveSearch(StringBuilder currentWord, List<String> wordsUntilNow, int index, Set<List<String>> resp, String s){
        if(index >= s.length()){
            wordsUntilNow.add(currentWord.toString());
            resp.add(new ArrayList<>(wordsUntilNow));
            wordsUntilNow.remove(wordsUntilNow.size() - 1);
            return;
        }

//        create new word
        if(currentWord.length() > 0){
            wordsUntilNow.add(currentWord.toString());
            StringBuilder newCurrentWord = new StringBuilder();
            newCurrentWord.append(s.charAt(index));
            recursiveSearch(newCurrentWord, wordsUntilNow, index + 1, resp, s);
            wordsUntilNow.remove(wordsUntilNow.size() - 1);
        }

//        add character to current word
        currentWord.append(s.charAt(index));
        recursiveSearch(currentWord, wordsUntilNow, index + 1, resp, s);
        currentWord.delete(currentWord.length() - 1, currentWord.length());
    }

    public List<List<String>> filterNonPalindrome(Set<List<String>> allCombinations){
        List<List<String>> resp = new ArrayList<>();

        for(List<String> combination: allCombinations){
            boolean allPalindrome = true;
            for(String word : combination){
                if(!isPalindrome(word)){
                    allPalindrome = false;
                    break;
                }
            }

            if(allPalindrome){
                resp.add(combination);
            }
        }

        return resp;
    }

    public boolean isPalindrome(String word){
        int mid = word.length() / 2;
        boolean isPalindrome = true;
        for(int i = 0; i < mid; ++i){
            if(word.charAt(i) != word.charAt(word.length() - 1 - i)){
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }

    public static void main(String[] args) {
        var v = new PalindromePartitioning();
        System.out.println(v.partition("aab"));
    }
}
