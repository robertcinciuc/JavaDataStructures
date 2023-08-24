package robertcinciuc.problems.leetcode.divideconquer;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.merge(num, 1, Integer::sum);
        }

        Map<Integer, Set<Integer>> inverseFreq = new TreeMap<>(Collections.reverseOrder());
        for(Integer key : freq.keySet()){
            if(!inverseFreq.containsKey(freq.get(key))){
                inverseFreq.put(freq.get(key), new HashSet<>());
            }
            inverseFreq.get(freq.get(key)).add(key);
        }

        int i = 0;
        List<Integer> resp = new ArrayList<>();
        for(Integer freqForVal: inverseFreq.keySet()){
            if(i < k){
                ArrayList<Integer> vals = new ArrayList<>(inverseFreq.get(freqForVal));
                while(vals.size() > 0){
                    Integer val = vals.remove(vals.size() - 1);
                    resp.add(val);
                    ++i;
                }
            }
        }

        return resp.stream().mapToInt(e -> e).toArray();
    }

    public static void main(String[] args) {
        var v = new TopKFrequentElements();
        System.out.println(Arrays.toString(v.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(v.topKFrequent(new int[]{1, 2}, 2)));
    }

}
