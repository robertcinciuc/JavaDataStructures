package robertcinciuc.problems.leetcode.dp;

import java.util.HashSet;
import java.util.Set;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {

        StringBuilder sb = new StringBuilder();
        Set<String> visited = new HashSet<>();

        if(s1.length() == s2.length() && s3.length() == s2.length()){

            return s1.equals("") && s2.equals("") && s3.equals("");
        }

        if(s1.length() > s3.length() || s2.length() > s3.length()){
            return false;
        }

        return recursiveSearch(s1, s2, s3, sb, 0, 0, 0, visited);
    }

    public boolean recursiveSearch(String s1, String s2, String s3, StringBuilder sb, int index1, int index2, int index3, Set<String> visited){
        if(sb.length() == s3.length() && index1 >= (s1.length() - 1) && index2 >= (s2.length() - 1)){
            return sb.toString().equals(s3);
        }

        visited.add(String.valueOf(index1) + index2);

        boolean first = false;
        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3) && !visited.contains(String.valueOf(index1 + 1) + index2)){
            sb.append(s1.charAt(index1));
            first = recursiveSearch(s1, s2, s3, sb, index1 + 1, index2, index3 + 1, visited);
            sb.deleteCharAt(sb.length() - 1);
        }

        boolean second = false;
        int tmpIndex2 = index2 + 1;
        if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3) && !visited.contains(String.valueOf(index1) + tmpIndex2)){
            sb.append(s2.charAt(index2));
            second = recursiveSearch(s1, s2, s3, sb, index1, index2 + 1, index3 + 1, visited);
            sb.deleteCharAt(sb.length() - 1);
        }

        return first || second;
    }

    public static void main(String[] args) {
        var v = new InterleavingString();
//        System.out.println(v.isInterleave("a", "b", "ab"));
//        System.out.println(v.isInterleave("aaa", "bb", "abaab"));
        System.out.println(v.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
