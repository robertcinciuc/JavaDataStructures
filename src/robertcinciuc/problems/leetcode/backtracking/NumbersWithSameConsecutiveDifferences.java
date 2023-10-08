package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;

public class NumbersWithSameConsecutiveDifferences {

    public int[] numsSameConsecDiff(int n, int k) {
        Set<String> strings = startSearch(n, k);
        int[] resp = new int[strings.size()];
        int i = 0;
        for(String elem : strings){
            resp[i] = Integer.parseInt(elem);
            ++i;
        }

        return resp;
    }

    public Set<String> startSearch(int n, int k){
        Set<String> resp = new HashSet<>();

        for(int i = 1; i <= 9; ++i){
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            recursiveSearch(resp, n, k, sb);
        }

        return resp;
    }

    public void recursiveSearch(Set<String> resp, int n, int k, StringBuilder current){
        String currentString = current.toString();
        if(Integer.parseInt(currentString) / Math.pow(10, n - 1) >= 1){
            resp.add(currentString);
        }else{
            int lastVal = Integer.parseInt(currentString.substring(currentString.length() - 1, current.length()));
            if(lastVal - k >= 0){
                current.append(lastVal - k);
                recursiveSearch(resp, n, k, current);
                current.delete(current.length() - 1, current.length());
            }
            if(lastVal + k <= 9){
                current.append(lastVal + k);
                recursiveSearch(resp, n, k, current);
                current.delete(current.length() - 1, current.length());
            }
        }
    }

    public static void main(String[] args) {
        var v = new NumbersWithSameConsecutiveDifferences();
        System.out.println(Arrays.toString(v.numsSameConsecDiff(3, 7)));
        System.out.println(Arrays.toString(v.numsSameConsecDiff(2, 1)));
    }
}
