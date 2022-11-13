package robertcinciuc.problems;

import java.util.ArrayList;
import java.util.List;

public class ParenthesesCombination {

    public static List<String> generateParenthesesCombiations(int n){
        List<String> result = new ArrayList<>();
        return generateParenthesesCombiations(n, n, result, "", n);
    }

    public static List<String> generateParenthesesCombiations(int remainToOpen, int remainToClose, List<String> result, String current, int n){
        if(remainToOpen > 0){
            generateParenthesesCombiations(remainToOpen - 1, remainToClose, result, current + "(", n);
        }

        if(remainToClose > 0 && remainToClose > remainToOpen){
            generateParenthesesCombiations(remainToOpen, remainToClose - 1, result, current + ")", n);
        }

        if(remainToOpen == 0 && remainToClose == 0){
            result.add(current);
        }

        return result;
    }

    public static void main(String[] args){
        int n = 4;
        System.out.println(generateParenthesesCombiations(n));
    }
}
