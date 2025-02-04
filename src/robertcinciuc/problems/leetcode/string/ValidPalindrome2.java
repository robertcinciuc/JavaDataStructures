package robertcinciuc.problems.leetcode.string;

public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if(s.charAt(left) == s.charAt(right) ){
                left++;
                right--;
            }else{
                return checkPalindrome(s, left + 1, right) || checkPalindrome(s, left, right - 1);
            }
        }

        return true;
    }

    private boolean checkPalindrome(String s, int left, int right){
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome2 validPalindrome2 = new ValidPalindrome2();
        System.out.println(validPalindrome2.validPalindrome("aba"));
        System.out.println(validPalindrome2.validPalindrome("abca"));
        System.out.println(validPalindrome2.validPalindrome("abc"));
        System.out.println(validPalindrome2.validPalindrome("abba"));
        System.out.println(validPalindrome2.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
