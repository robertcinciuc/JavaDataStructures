package robertcinciuc.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> seen = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        recursiveSearch(0, seen, sb, s);

        return seen;
    }

    private void recursiveSearch(int index, List<String> seen, StringBuilder sb, String s){
        if(index == s.length()){
            seen.add(sb.toString());
            return;
        }

        char otherCase = '0';
        boolean isLetter = false;
        if(isLowerCaseLetter(s.charAt(index))){
            otherCase = Character.toUpperCase(s.charAt(index));
            isLetter = true;
        }else if(isUpperCaseLetter(s.charAt(index))){
            otherCase = Character.toLowerCase(s.charAt(index));
            isLetter = true;
        }

        sb.append(s.charAt(index));
        recursiveSearch(index + 1, seen, sb, s);
        sb.delete(sb.length() - 1, sb.length());

        if(isLetter){
            sb.append(otherCase);
            recursiveSearch(index + 1, seen, sb, s);
            sb.delete(sb.length() - 1, sb.length());
        }
    }

    private static boolean isLowerCaseLetter(char symbol){
        return symbol >= 'a' && symbol <= 'z';
    }

    private static boolean isUpperCaseLetter(char symbol){
        return symbol >= 'A' && symbol <= 'Z';
    }
}
