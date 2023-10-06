package robertcinciuc.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {
    public List<Integer> splitIntoFibonacci(String num) {
        if(num.isEmpty()){
            return List.of();
        }

        List<Integer> soFarLong = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        return recursiveSearch(0, soFarLong, sb, num);
    }

    public List<Integer> recursiveSearch(int index, List<Integer> soFarInt, StringBuilder current, String s){
        String currentString = current.toString();

        if(index >= s.length()){
            if(currentString.isEmpty()){
                if(soFarInt.size() < 3){
                    return List.of();
                }
                if(soFarInt.get(soFarInt.size() - 1) == soFarInt.get(soFarInt.size() - 2) + soFarInt.get(soFarInt.size() - 3)){
                    return soFarInt;
                }
            }else{
                int currInt;
                try{
                    currInt = Integer.parseInt(currentString);
                }catch (Exception e){
                    return List.of();
                }

                if(soFarInt.size() < 2){
                    return List.of();
                }

                if(currInt == soFarInt.get(soFarInt.size() - 1) + soFarInt.get(soFarInt.size() - 2)){
                    soFarInt.add(currInt);
                    return soFarInt;
                }
            }
            return List.of();
        }

        if(!isValid(currentString)){
            return List.of();
        }

        if(!currentString.isEmpty()){
            try{
                Integer.parseInt(currentString);
            }catch (Exception e){
                return List.of();
            }
        }

        if(!currentString.isEmpty() && (soFarInt.size() < 2 || Integer.parseInt(currentString) == soFarInt.get(soFarInt.size() - 1) + soFarInt.get(soFarInt.size() - 2))){
            soFarInt.add(Integer.parseInt(currentString));
            StringBuilder newSb = new StringBuilder();
            newSb.append(s.charAt(index));
            List<Integer> resp1 = recursiveSearch(index + 1, soFarInt, newSb, s);
            if(!resp1.isEmpty()){
                return resp1;
            }
            soFarInt.remove(soFarInt.size() - 1);
        }

        current.append(s.charAt(index));
        List<Integer> resp2 = recursiveSearch(index + 1, soFarInt, current, s);
        if(!resp2.isEmpty()){
            return resp2;
        }

        return List.of();
    }

    private static boolean isValid(String s){
        String s1 = removeTrailingZeros(s);
        return s1.equals(s);
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
        var v = new SplitArrayIntoFibonacciSequence();
        System.out.println(v.splitIntoFibonacci("11235813"));
        System.out.println(v.splitIntoFibonacci("4748364721"));
    }
}
