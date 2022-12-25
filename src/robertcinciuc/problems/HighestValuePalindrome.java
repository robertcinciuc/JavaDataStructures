package robertcinciuc.problems;

import java.util.HashSet;

class Result4{
    public static String highestValuePalindrome(String s, int n, int k) {
        int diffNb = 0;
        for(int i = 0; i < n/2; ++i){
            if(s.charAt(i) != s.charAt(n - 1 - i)){
                diffNb += 1;
            }
        }

        StringBuilder resp = new StringBuilder(s);
        if(k < diffNb){
            return "-1";
        }else{
            int nbDouble = Math.min(k - diffNb, k);
            int extra = k - diffNb*2;
            for(int i = 0; i < n/2; ++i) {
                if (s.charAt(i) != s.charAt(n - 1 - i)) {
                    if(nbDouble > 0 && k > 0){
                        int tmpDelta = 0;
                        if(s.charAt(i) != '9'){
                            tmpDelta += 1;
                        }
                        if(s.charAt(n - i - 1) != '9'){
                            tmpDelta += 1;
                        }
                        resp.setCharAt(i, '9');
                        resp.setCharAt(n - i - 1, '9');
                        nbDouble -= tmpDelta;
                        k -= tmpDelta;
                    }else{
                        if(diffNb > 0 && k > 0) {
                            char elem = (char) (Math.max(s.charAt(i), s.charAt(n - i - 1)));
                            resp.setCharAt(i, elem);
                            resp.setCharAt(n - i - 1, elem);
                            diffNb -= 1;
                            k -= 1;
                        }
                    }
                }else if(extra >= 2 && k >= 2){
                    if(s.charAt(i) != '9'){
                        resp.setCharAt(i, '9');
                        resp.setCharAt(n - i - 1, '9');
                        extra -= 2;
                        k -= 2;
                    }
                }
            }

            if(extra > 0 && n % 2 != 0 && k > 0){
                resp.setCharAt(n / 2, '9');
            }
        }


        return resp.toString();
    }

    public static String highestValuePalindrome2(String str, int n, int k) {
// Write your code here
        StringBuilder strB = new StringBuilder(str);
        HashSet<Integer> visitedStore = new HashSet<>(n/2);

        for(int i = 0; i< n /2; i++) {

            if(str.charAt(i)!= str.charAt(n-i-1)) {
                int max = Math.max(Integer.valueOf(str.charAt(i)), str.charAt(n - i - 1));
                strB.setCharAt(i, (char) max);
                strB.setCharAt(n-i-1, (char) max);
                visitedStore.add(i);
                k = k-1;

                if(k <0){
                    System.out.println("-1");
                    return "-1";
                }
            }
        }

        for(int i=0;i<n/2;i++) {
            if(k>0) {
                if (visitedStore.contains(i)) {

                    if (strB.charAt(i) == '9') {
                        continue;
                    } else {
                        strB.setCharAt(i, '9');
                        strB.setCharAt(n-i-1, '9');
                        k=k-1;
                    }

                } else if(k>1) {
                    if (strB.charAt(i) == '9') {
                        continue;
                    } else {
                        strB.setCharAt(i, '9');
                        strB.setCharAt(n - i - 1, '9');
                        k = k - 2;
                    }
                }
            }

        }

        if(k>0 && n%2==1) {
            strB.setCharAt(n/2, '9');
        }

        System.out.println(strB.toString());
        return strB.toString();

    }
}

public class HighestValuePalindrome {
    public static void main(String[] args){
//        System.out.println(Result4.highestValuePalindrome("3943", 4, 1));
//        System.out.println(Result4.highestValuePalindrome("12321", 5, 1));
//        System.out.println(Result4.highestValuePalindrome("092282", 6, 3));
//        System.out.println(Result4.highestValuePalindrome("0011", 4, 1));
        System.out.println(Result4.highestValuePalindrome("932239", 6, 2));
    }
}
