package robertcinciuc.problems.leetcode;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {

        boolean descending = true;
        int pos = nums.length;
        for(int i = nums.length - 2; i >= 0; i--){
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

            Arrays.sort(nums, pos + 1, nums.length);
        }
    }

    private void print(int[] arr){
        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        NextPermutation nextPermutation = new NextPermutation();

//        int[] arr1 = new int[]{1,2,3};
//        nextPermutation.nextPermutation(arr1);
//        nextPermutation.print(arr1);
//
//        int[] arr2 = new int[]{3,2,1};
//        nextPermutation.nextPermutation(arr2);
//        nextPermutation.print(arr2);
//
//        int[] arr3 = new int[]{1,1,5};
//        nextPermutation.nextPermutation(arr3);
//        nextPermutation.print(arr3);

        int[] arr4 = new int[]{1,2};
        nextPermutation.nextPermutation(arr4);
        nextPermutation.print(arr4);
    }
}
