package robertcinciuc.problems.leetcode;

class Solution {
    public int findMin(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int start, int end){
        if(end - start == 1){
            return Math.min(nums[start], nums[end]);
        }

        int mid = (end - start) / 2 + start;
        if(nums[start] > nums[mid]){
            return search(nums, start, mid);
        }else if(nums[end] < nums[mid]){
            return search(nums, mid, end);
        }else{
            return nums[start];
        }
    }
}

public class MinimumRotatedSortedArray {

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findMin(new int[]{3,4,5,1,2}));
        System.out.println(sol.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(sol.findMin(new int[]{11,13,15,17}));
    }
}
