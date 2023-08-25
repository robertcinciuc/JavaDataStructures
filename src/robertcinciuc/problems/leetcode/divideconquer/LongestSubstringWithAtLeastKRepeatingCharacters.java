package robertcinciuc.problems.leetcode.divideconquer;

import java.util.*;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    static class Pair{
        public List<Integer> pos = new ArrayList<>();
        public Integer freq;
        public Pair(Integer pos, Integer freq){
            this.pos.add(pos);
            this.freq = freq;
        }
    }

    public int longestSubstring(String s, int k) {
        return recursiveSearch(s, k, 0, s.length());
    }

    public int recursiveSearch(String s, int k, int start, int end){
        if(start == end - 1 || start == end){
            if(k > 1){
                return 0;
            }
            return 1;
        }

        Map<Character, Pair> lesserChars = new HashMap<>();
        Set<Character> dontAdd = new HashSet<>();
        for(int i = start; i < end; ++i){
            if(!dontAdd.contains(s.charAt(i))){
                if(!lesserChars.containsKey(s.charAt(i))){
                    lesserChars.put(s.charAt(i), new Pair(i, 1));
                }else{
                    if(lesserChars.get(s.charAt(i)).freq + 1 >= k){
                        lesserChars.remove(s.charAt(i));
                        dontAdd.add(s.charAt(i));
                    }else{
                        Pair pair = lesserChars.get(s.charAt(i));
                        pair.freq += 1;
                        pair.pos.add(i);
                    }
                }
            }
        }

        boolean foundLesser = false;
        if(lesserChars.size() > 0) {
            for (int i = start; i < end; ++i) {
                if (lesserChars.containsKey(s.charAt(i))) {
                    foundLesser = true;
                    break;
                }
            }
        }

        if(!foundLesser){
            return end - start;
        }

        Set<Integer> positions = new TreeSet<>();
        for(Character car : lesserChars.keySet()){
            positions.addAll(lesserChars.get(car).pos);
        }
        positions.add(end);

        List<Integer> positions1 = new ArrayList<>(positions);
        int maxLen = 0;
        if(positions1.get(0) != start){
            maxLen = recursiveSearch(s, k, start, positions1.get(0));
        }
        for(int i = 0; i < positions.size() - 1; ++i){
            int len = recursiveSearch(s, k, positions1.get(i) + 1, positions1.get(i + 1));
            if(len > maxLen){
                maxLen = len;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        var v = new LongestSubstringWithAtLeastKRepeatingCharacters();
        System.out.println(v.longestSubstring("bcxababbczb", 2));
        System.out.println(v.longestSubstring("aaabb", 3));
        System.out.println(v.longestSubstring("ababbc", 2));
        System.out.println(v.longestSubstring("baaabcb", 3));
    }
}
