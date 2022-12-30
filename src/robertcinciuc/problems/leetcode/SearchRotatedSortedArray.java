package robertcinciuc.problems.leetcode;

class Solution2 {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int start, int end){
        if(end - start == 1){
            if(nums[start] == target){
                return start;
            }
            if(nums[end] == target){
                return end;
            }
            return -1;
        }else if(end == start){
            if(nums[start] == target){
                return start;
            }
            return -1;
        }

        int mid = (end - start) / 2 + start;
        if(nums[mid] > nums[start] && nums[mid] > nums[end]){
            if(target >= nums[mid] || target < nums[start]){
                return search(nums, target, mid, end);
            }else{
                return search(nums, target, start, mid);
            }
        }else if(nums[mid] < nums[start] && nums[mid] < nums[end]) {
            if(target < nums[mid] || target >= nums[start]){
                return search(nums, target, start, mid);
            }else{
                return search(nums, target, mid, end);
            }
        }else{
            if(target >= nums[mid]){
                return search(nums, target, mid, end);
            }else{
                return search(nums, target, start, mid);
            }
        }
    }
}

public class SearchRotatedSortedArray {
    public static void main(String[] args){
        Solution2 sol = new Solution2();
        System.out.println(sol.search(new int[]{4,5,6,7,0,1,2}, 4));
        System.out.println(sol.search(new int[]{4,5,6,7,0,1,2}, 7));
        System.out.println(sol.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(sol.search(new int[]{5, 1, 3}, 5));
        System.out.println(sol.search(new int[]{1}, 0));
    }

}

