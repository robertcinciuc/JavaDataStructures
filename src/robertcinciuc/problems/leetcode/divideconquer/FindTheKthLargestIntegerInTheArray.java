package robertcinciuc.problems.leetcode.divideconquer;

import java.util.*;
import java.util.stream.Collectors;

public class FindTheKthLargestIntegerInTheArray {

    public String kthLargestNumber(String[] nums, int k) {

        Map<Integer, List<String>> resp = new TreeMap<>(Collections.reverseOrder());
        for(String elem : nums){
            if(!resp.containsKey(elem.length())){
                resp.put(elem.length(), new ArrayList<>());
            }
            resp.get(elem.length()).add(elem);
        }

        resp.replaceAll((s, v) -> resp.get(s).stream().sorted().collect(Collectors.toList()));

        int i = 1;
        for(Integer size : resp.keySet()){
            for(int j = resp.get(size).size() - 1; j >=0; j--){
                if(i == k){
                    return resp.get(size).get(j);
                }
                ++i;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        var v = new FindTheKthLargestIntegerInTheArray();
        System.out.println(v.kthLargestNumber(new String[]{"3","6","7","10"}, 4));
        System.out.println(v.kthLargestNumber(new String[]{"2","21","12","1"}, 3));
        System.out.println(v.kthLargestNumber(new String[]{"0","0"}, 2));
    }
}
