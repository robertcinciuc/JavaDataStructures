package robertcinciuc.problems.leetcode;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s){

        Boolean[][] isPalindrome = new Boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); ++i){
            for(int j = 0; j < s.length(); ++j){
                isPalindrome[i][j] = null;
            }
        }

        for(int i = 0; i < s.length(); ++i){
            isPalindrome[i][i] = true;
        }

        for(int i = 0; i < s.length() - 1; ++i){
            if(s.charAt(i) == s.charAt(i+1)){
                isPalindrome[i][i+1] = true;
            }
        }

        for(int delta = 2; delta < s.length(); ++delta){
            for(int i = 0; i < s.length()-2; ++i){
//              general case
                if((i + delta) < s.length()){
                    Boolean pal = isPalindrome[i + 1][i + delta - 1];
                    if(pal == null ){
                        isPalindrome[i][i+delta] = false;
                    }else if(s.charAt(i) == s.charAt(i+delta) && isPalindrome[i+1][i+delta-1]){
                        isPalindrome[i][i+delta] = true;
                    }else{
                        isPalindrome[i][i+delta] = false;
                    }
                }
            }
        }

        int start = 0;
        int end = 0;
        int maxLen = 0;
        for(int i = 0; i < s.length(); ++i){
            for(int j = 0; j < s.length(); ++j){
                if(isPalindrome[i][j] != null && isPalindrome[i][j] && (j - i) > maxLen){
                    start = i;
                    end = j;
                    maxLen = j - i;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = start; i <= end; ++i){
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public void findPalindromeSubsequence(String s, StringBuilder sb1, StringBuilder sb2) {

        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {

            int start1 = start;
            int end1 = end;
            while (start1 <= end1) {

                if (s.charAt(start1) == s.charAt(end1)) {
                    if (start1 < end1) {
                        sb1.append(s.charAt(start1));
                        sb2.insert(0, s.charAt(start1));
                        start = start1 + 1;
                        end = end1 - 1;
                        start1 = end1 + 1;
                    } else {
                        if (start == end) {
                            sb1.append(s.charAt(start));
                            start = end + 1;
                        }
                        start1 = end + 1;
                        start = start + 1;
                    }
                } else {
                    if (start1 < end1) {
                        end1--;
                    } else {
                        end = end1 - 1;
                        start1 = end1 + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        var v = new LongestPalindromicSubstring();
        System.out.println(v.longestPalindrome("babad"));
        System.out.println(v.longestPalindrome("cbbd"));
        System.out.println(v.longestPalindrome("ccc"));
        System.out.println(v.longestPalindrome("bb"));
        System.out.println(v.longestPalindrome("aaaa"));
        System.out.println(v.longestPalindrome("aaaaa"));
        System.out.println(v.longestPalindrome("aaaaaa"));
        System.out.println(v.longestPalindrome("aaaaaaa"));
        System.out.println(v.longestPalindrome("aacabdkacaa"));
        System.out.println(v.longestPalindrome("ababababababa"));
    }
}

