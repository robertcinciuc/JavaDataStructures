package robertcinciuc.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RestoreIpAdresses {
    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12 || s.length() < 4){
            return List.of();
        }

        StringBuilder totalCurrent = new StringBuilder();
        StringBuilder current = new StringBuilder();
        totalCurrent.append(s.charAt(0));
        current.append(s.charAt(0));
        Set<String> adresses = new HashSet<>();
        Set<String> seen = new HashSet<>();

        recursiveSearch(s, 0, 1, totalCurrent, current, adresses, seen);

        return new ArrayList<>(adresses);
    }

    public void recursiveSearch(String s, int totalIndex, int nb, StringBuilder totalCurrent, StringBuilder current, Set<String> adresses, Set<String> seen){
        if(nb > 4){
            return;
        }

        String totalCurrentString = totalCurrent.toString();
        String currentString = current.toString();
        if(!currentString.equals(removeLeadingZeros(currentString))){
            return;
        }

        int currentInt = Integer.parseInt(current.toString());
        if(currentInt > 255){
            return;
        }

        seen.add(totalCurrentString);

        if(totalIndex == s.length() - 1){
            if(nb == 4){
                adresses.add(totalCurrent.toString());
            }
            return;
        }

        if(current.length() < 3 && !current.toString().equals("0")){
            totalCurrent.append(s.charAt(totalIndex + 1));
            current.append(s.charAt(totalIndex + 1));
            if(!seen.contains(totalCurrent.toString())){
                recursiveSearch(s, totalIndex + 1, nb, totalCurrent, current, adresses, seen);
            }
            totalCurrent.delete(totalCurrent.length() - 1, totalCurrent.length());
            current.delete(current.length() - 1, current.length());
        }

        totalCurrent.append(".");
        totalCurrent.append(s.charAt(totalIndex + 1));
        StringBuilder newCurrent = new StringBuilder();
        newCurrent.append(s.charAt(totalIndex + 1));
        if(!seen.contains(totalCurrent.toString())){
            recursiveSearch(s, totalIndex + 1, nb + 1, totalCurrent, newCurrent, adresses, seen);
        }
        totalCurrent.delete(totalCurrent.length() - 2, totalCurrent.length());
        newCurrent.delete(newCurrent.length() - 1, newCurrent.length());
    }

    public String removeLeadingZeros(String s){
        if(s.equals("0")){
            return "0";
        }

        int i = 0;
        boolean leadingZeros = true;
        while(leadingZeros){
            if(s.charAt(i) == '0'){
                ++i;
            }else{
                leadingZeros = false;
            }
        }

        return s.substring(i);
    }
}
