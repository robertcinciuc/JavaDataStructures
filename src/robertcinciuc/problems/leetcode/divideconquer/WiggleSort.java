package robertcinciuc.problems.leetcode.divideconquer;

import java.util.Arrays;

public class WiggleSort {

    public void wiggleSort(int[] nums) {

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }

        int index = 0;
        for(int i = 0; i < count.length; ++i){
            if(count[i] > 0){
                while(count[i] > 0){
                    nums[index] = i;
                    count[i]--;
                    index++;
                }
            }
        }

        int[] tmp = Arrays.copyOf(nums, nums.length);
        int i = 1;
        int end = nums.length - 1;
        while(i < nums.length){
            nums[i] = tmp[end];
            end--;
            i += 2;
        }

        i = 0;
        while(i < nums.length){
            nums[i] = tmp[end];
            end--;
            i += 2;
        }
    }

    public static void main(String[] args) {
        var v = new WiggleSort();
        int[] arr1 = new int[]{1,5,1,1,6,4};
        v.wiggleSort(arr1);
        System.out.println();
    }

}
