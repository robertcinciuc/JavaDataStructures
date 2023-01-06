package robertcinciuc.problems.leetcode;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {

        boolean descending = true;
        int pos = nums.length;
        for(int i = nums.length - 2; i > 0; i--){
            pos = i;
            if(nums[i] < nums[i + 1]){
                descending = false;
                break;
            }
        }

        if(descending){
            Arrays.sort(nums);
        }else{
            int min = nums[pos + 1];
            int posMin = pos + 1;
            for(int i = nums.length - 1; i > pos; i--){
                if(nums[i] < min && nums[i] > nums[pos]){
                    min = nums[i];
                    posMin = i;
                }
            }

            nums[posMin] = nums[pos];
            nums[pos] = min;
//            copy array from pos to end
//            sort this part
//            put it back in the original array
        }

    }

    public static void main(String[] args){

    }
}
