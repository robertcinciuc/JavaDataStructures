package robertcinciuc.problems.leetcode.string;

public class MinimumRemoveMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {

        int nbValidParantheses = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == ')'){
                if(nbValidParantheses > 0){
                    nbValidParantheses--;
                    sb.append(s.charAt(i));
                }
            }else if(s.charAt(i) == '('){
                nbValidParantheses++;
                sb.append(s.charAt(i));
            }else{
                sb.append(s.charAt(i));
            }
        }

        StringBuilder sb2 = new StringBuilder(sb.toString());
        int j = sb.length() - 1;
        if(nbValidParantheses > 0){
            for(int i = sb.length() - 1; i >= 0; i--){
                if(nbValidParantheses == 0){
                    break;
                }
                if(sb.charAt(i) == '('){
                    nbValidParantheses--;
                    sb2.delete(j, j + 1);
                }
                j--;
            }
        }

        return sb2.toString();
    }

    public static void main(String[] args){
        MinimumRemoveMakeValidParentheses solution = new MinimumRemoveMakeValidParentheses();
        System.out.println(solution.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(solution.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(solution.minRemoveToMakeValid("))(("));
        System.out.println(solution.minRemoveToMakeValid("())()((("));
    }
}
