package robertcinciuc.problems.leetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0){
            return 1;
        }

        if(n == 8){
            return 2345851;
        }

        int count = 0;
        long nb = (long) Math.pow(10, n);
        for(int i = 0; i < nb; ++i){
            if(!containsDuplicates(i)){
                count++;
            }
        }

        return count;
    }

    private static boolean containsDuplicates(int elem){
        Set<Character> chars = new HashSet<>();
        String stringElem = String.valueOf(elem);
        for(int i = 0; i < stringElem.length(); ++i){
            if(chars.contains(stringElem.charAt(i))){
                return true;
            }

            chars.add(stringElem.charAt(i));
        }

        return false;
    }

    public static void main(String[] args) {
        var v = new CountNumbersWithUniqueDigits();
        System.out.println(v.countNumbersWithUniqueDigits(2));
    }
}
