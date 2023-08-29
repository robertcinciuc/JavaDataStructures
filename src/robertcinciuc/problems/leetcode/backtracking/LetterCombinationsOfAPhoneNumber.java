package robertcinciuc.problems.leetcode.backtracking;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {

        if(digits.isEmpty()){
            return List.of();
        }

        Map<Character, List<Character>> buttons = fillButtons();
        Set<String> seen = new HashSet<>();
        List<String> resp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        recursiveSearch(seen, resp, 0, digits, buttons, sb);

        return resp;
    }

    public Map<Character, List<Character>> fillButtons(){
        Map<Character, List<Character>> buttons = new HashMap<>();
        buttons.put('2', new ArrayList<>());
        buttons.put('3', new ArrayList<>());
        buttons.put('4', new ArrayList<>());
        buttons.put('5', new ArrayList<>());
        buttons.put('6', new ArrayList<>());
        buttons.put('7', new ArrayList<>());
        buttons.put('8', new ArrayList<>());
        buttons.put('9', new ArrayList<>());

        buttons.get('2').add('a');
        buttons.get('2').add('b');
        buttons.get('2').add('c');
        buttons.get('3').add('d');
        buttons.get('3').add('e');
        buttons.get('3').add('f');
        buttons.get('4').add('g');
        buttons.get('4').add('h');
        buttons.get('4').add('i');
        buttons.get('5').add('j');
        buttons.get('5').add('k');
        buttons.get('5').add('l');
        buttons.get('6').add('m');
        buttons.get('6').add('n');
        buttons.get('6').add('o');
        buttons.get('7').add('p');
        buttons.get('7').add('q');
        buttons.get('7').add('r');
        buttons.get('7').add('s');
        buttons.get('8').add('t');
        buttons.get('8').add('u');
        buttons.get('8').add('v');
        buttons.get('9').add('w');
        buttons.get('9').add('x');
        buttons.get('9').add('y');
        buttons.get('9').add('z');

        return buttons;
    }

    public void recursiveSearch(Set<String> seen, List<String> resp, int index, String digits, Map<Character, List<Character>> buttons, StringBuilder current){
        if(index >= digits.length()){
            resp.add(current.toString());
            return;
        }

        for(Character letter: buttons.get(digits.charAt(index))){
            current.append(letter);

            if(!seen.contains(current.toString())){
                seen.add(current.toString());
                recursiveSearch(seen, resp, index + 1, digits, buttons, current);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        var v = new LetterCombinationsOfAPhoneNumber();
        System.out.println(v.letterCombinations("23"));
        System.out.println(v.letterCombinations("2"));
        System.out.println(v.letterCombinations(""));
    }

}
