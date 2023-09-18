package robertcinciuc.problems.leetcode.backtracking;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        return recursiveSearch(num, 0, 1, 2, 3);
    }

    public boolean recursiveSearch(String num, int aStart, int bStart, int cStart, int cEnd){
        if(cEnd > num.length()){
            return false;
        }

        String stringA = removeTrailingZeros(num.substring(aStart, bStart));
        String stringB = removeTrailingZeros(num.substring(bStart, cStart));
        String stringC = removeTrailingZeros(num.substring(cStart, cEnd));

        if(!stringA.equals(num.substring(aStart, bStart)) ||
        !stringB.equals(num.substring(bStart, cStart)) ||
        !stringC.equals(num.substring(cStart, cEnd))){
            return false;
        }

        long a = Long.parseLong(num.substring(aStart, bStart));
        long b = Long.parseLong(num.substring(bStart, cStart));
        long c = Long.parseLong(num.substring(cStart, cEnd));
        boolean additiveNb = false;
        if(a + b == c){
            if(cEnd == num.length()){
                additiveNb = true;
            }else{
                additiveNb = recursiveSearch(num, bStart, cStart, cEnd, cEnd + 1);
            }
        }

        if(!additiveNb){
            additiveNb = recursiveSearch(num, aStart, bStart + 1, cStart + 1, cEnd + 1);
        }

        if(!additiveNb){
            additiveNb = recursiveSearch(num, aStart, bStart, cStart + 1, cEnd + 1);
        }

        if(!additiveNb && (cEnd - cStart + 1) <= (Math.max(bStart - aStart, cStart - bStart) + 1)){
            additiveNb = recursiveSearch(num, aStart, bStart, cStart, cEnd + 1);
        }

        return additiveNb;
    }

    private static String removeTrailingZeros(String input){
        if(input.equals("0")){
            return "0";
        }

        int i = 0;
        while(i < input.length()){
            if(input.charAt(i) == '0'){
                ++i;
            }else{
                break;
            }
        }

        return input.substring(i);
    }

    public static void main(String[] args) {
        var v = new AdditiveNumber();
//        System.out.println(v.isAdditiveNumber("199100199"));
//        System.out.println(v.isAdditiveNumber("112358"));
//        System.out.println(v.isAdditiveNumber("1023"));
//        System.out.println(v.isAdditiveNumber("101"));
        System.out.println(v.isAdditiveNumber("11112233558"));
    }
}
