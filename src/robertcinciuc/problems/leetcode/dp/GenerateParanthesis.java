package robertcinciuc.problems.leetcode.dp;

import java.util.*;
import java.util.stream.Collectors;

public class GenerateParanthesis {

    public List<String> generateParenthesis(int n) {

        Set<String> resp = new HashSet<>();
        Set<String> isValid = new HashSet<>();
        isValid.add("");

        checkValidity("", isValid, resp, 0, n);

        return resp.stream().filter(s -> !s.isEmpty()).sorted().collect(Collectors.toList());
    }

    public void checkValidity(String current, Set<String> isValid, Set<String> resp, int lvl, int n){
        if(lvl == n){
            resp.add(current);
            return;
        }

        if(isValid.contains(current)){
            String newCurrent1 = "(" + current + ")";
            if(!isValid.contains(newCurrent1)){
                isValid.add(newCurrent1);
                int newLvl1 = lvl + 1;
                checkValidity(newCurrent1, isValid, resp, newLvl1, n);
            }

            String newCurrent2 = "()" + current ;
            if(!isValid.contains(newCurrent2)){
                isValid.add(newCurrent2);
                int newLvl2 = lvl + 1;
                checkValidity(newCurrent2, isValid, resp, newLvl2, n);
            }

            String newCurrent3 = current + "()" ;
            if(!isValid.contains(newCurrent3)) {
                isValid.add(newCurrent3);
                int newLvl3 = lvl + 1;
                checkValidity(newCurrent3, isValid, resp, newLvl3, n);
            }

            if(lvl == n / 2 && lvl > 0){
                String newCurrent4 = current + current;
                if(!isValid.contains(newCurrent4)) {
                    isValid.add(newCurrent4);
                    int newLvl = lvl * 2;
                    checkValidity(newCurrent4, isValid, resp, newLvl, n);
                }
            }

            checkInsertion(current, isValid, resp, lvl, n);
        }
    }

    public void checkInsertion(String current, Set<String> isValid, Set<String> resp, int lvl, int n){

        for(int i = 0; i <= current.length(); ++i){
            for(int j = i; j <= current.length(); ++j){
                String first = current.substring(0, i);
                String second = current.substring(i, j);
                String third = current.substring(j);

                if(isValid.contains(first) && isValid.contains(second) && isValid.contains(third)){
                    String newCurrent = first + "(" + second + ")" + third;

                    if(!isValid.contains(newCurrent)) {
                        isValid.add(newCurrent);

                        if (lvl + 1 == n) {
                            resp.add(newCurrent);
                        }

                        checkValidity(newCurrent, isValid, resp, lvl + 1, n);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        var v = new GenerateParanthesis();
//        System.out.println(v.generateParenthesis(1));
//        System.out.println(v.generateParenthesis(2));
//        System.out.println(v.generateParenthesis(3));
//        System.out.println(v.generateParenthesis(4));
        System.out.println(v.generateParenthesis(5));

    }
}
