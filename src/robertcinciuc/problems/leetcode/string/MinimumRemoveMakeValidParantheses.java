package robertcinciuc.problems.leetcode.string;

public class MinimumRemoveMakeValidParantheses {

}

class Solution {
    public String minRemoveToMakeValid(String s) {

        int nbValidParantheses = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == ')' && nbValidParantheses > 0){
                nbValidParantheses--;
                sb.append(s.charAt(i));
            }else if(s.charAt(i) == '('){
                nbValidParantheses++;
                sb.append(s.charAt(i));
            }else{
                sb.append(s.charAt(i));
            }
        }

        return "";
    }
}
