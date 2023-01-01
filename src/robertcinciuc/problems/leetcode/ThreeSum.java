package robertcinciuc.problems.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resp = new ArrayList<>();
        Set<Integer> hashArray = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; ++i){
            search(nums, nums[i], i, hashArray, resp);
        }
        return resp;
    }

    public void search(int[] nums, int first, int firstPos, Set<Integer> hashArray, List<List<Integer>> resp){
        int start = firstPos + 1;
        int end = nums.length - 1;
        while(start < end){
            if(first + nums[start] + nums[end] < 0){
                start++;
            }else if(first + nums[start] + nums[end] > 0){
                end--;
            }else {
                int[] num = new int[]{first, nums[start], nums[end]};
                int hashCode = Arrays.hashCode(num);
                if(!hashArray.contains(hashCode)){
                    resp.add(List.of(first, nums[start], nums[end]));
                    hashArray.add(hashCode);
                }
                start++;
                end--;
            }
        }
    }

    public  List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
            int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if (sum >0) k--;
                else if (sum<0) j++;
            }

        }
        return new ArrayList<>(res);

    }

    public static void main(String[] args) throws IOException {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arr = Stream.of(br.readLine().split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

        int[] arr2 = new int[arr.size()];
        for(int i = 0; i < arr.size() - 1; ++i){
            arr2[i] = arr.get(i);
        }

        System.out.println(threeSum.threeSum(arr2));
    }

}
