package robertcinciuc.problems.leetcode.string;

public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        boolean offsetUsed = false;
        while (left < right){
            if(s.charAt(left) == s.charAt(right) ){
                left++;
                right--;
            }else if(s.charAt(left + 1) == s.charAt(right) && !offsetUsed){
                left += 2;
                right--;
                offsetUsed = true;
            }else if(s.charAt(left) == s.charAt(right - 1) && !offsetUsed){
                left++;
                right -= 2;
                offsetUsed = true;
            }else{
                return false;
            }
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
