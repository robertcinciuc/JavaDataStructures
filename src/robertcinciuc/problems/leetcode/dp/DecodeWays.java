package robertcinciuc.problems.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public int numDecodings(String s) {

        Map<String, String> mapping = getMapping();

        if(s.isEmpty() || !mapping.containsKey(String.valueOf(s.charAt(0)))){
            return 0;
        }

        return search(s, mapping);
    }

    public Map<String, String> getMapping(){
        Map<String, String> mapping = new HashMap<>();
        mapping.put("1", "A");
        mapping.put("2", "B");
        mapping.put("3", "C");
        mapping.put("4", "D");
        mapping.put("5", "E");
        mapping.put("6", "F");
        mapping.put("7", "G");
        mapping.put("8", "H");
        mapping.put("9", "I");
        mapping.put("10", "J");
        mapping.put("11", "K");
        mapping.put("12", "L");
        mapping.put("13", "M");
        mapping.put("14", "N");
        mapping.put("15", "O");
        mapping.put("16", "P");
        mapping.put("17", "Q");
        mapping.put("18", "R");
        mapping.put("19", "S");
        mapping.put("20", "T");
        mapping.put("21", "V");
        mapping.put("22", "U");
        mapping.put("23", "W");
        mapping.put("24", "X");
        mapping.put("25", "Y");
        mapping.put("26", "Z");

        return mapping;
    }

    public int search(String s, Map<String, String> mapping){

        int[] res = new int[s.length()];
        res[0] = 1;
        for(int i = 1; i < s.length(); ++i){
            if(mapping.containsKey(String.valueOf(s.charAt(i)))){
                if(mapping.containsKey(s.substring(i - 1, i + 1))){
                    if(i - 2 < 0){
                        res[i] = res[i - 1] + 1;
                    }else{
                        res[i] = res[i - 1] + res[i - 2];
                    }
                }else{
                    res[i] = res[i - 1];
                }
            }else{
                if(mapping.containsKey(s.substring(i - 1, i + 1))){
                    if(i > 2){
                        res[i] = res[i - 2];
                    }else{
                        res[i] = 1;
                    }
                }else{
                    return 0;
                }
            }
        }

        return res[s.length() - 1];
    }

    public static void main(String[] args) {
        var v = new DecodeWays();
        System.out.println(v.numDecodings("11106"));
        System.out.println(v.numDecodings("110"));
        System.out.println(v.numDecodings("10"));
        System.out.println(v.numDecodings("1123"));
        System.out.println(v.numDecodings("207"));
        System.out.println(v.numDecodings("2611055971756562"));
    }
}
