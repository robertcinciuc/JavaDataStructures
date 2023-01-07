package robertcinciuc.problems.leetcode;

public class FirstLastPosSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1};
        }else if(nums.length == 1){
            if(nums[0] == target){
                return new int[]{0, 0};
            }else{
                return new int[]{-1, -1};
            }
        }
        return search(nums, target, 0, nums.length - 1);
    }

    public int[] search(int[] nums, int target, int start, int end){
        if(end - start == 1){
            if(nums[start] == target){
                int respEnd = nums[end] == target ? end : start;
                return new int[]{start, respEnd};
            }else{
                if(nums[end] == target){
                    return new int[]{end, end};
                }else{
                    return new int[]{-1, -1};
                }
            }
        }

        int mid = (end - start)/2 + start;
        if(nums[mid] == target){
            int respStart = searchStart(nums, target, start, mid);
            int respEnd = searchEnd(nums, target, mid, end);
            return new int[]{respStart, respEnd};
        }else if(nums[mid] > target){
            return search(nums, target, start, mid);
        }else{
            return search(nums, target, mid, end);
        }
    }

    public int searchStart(int[] nums, int target, int start, int end){
        if(end - start == 1){
            int respStart = nums[start] == target ? start : end;
            return respStart;
        }

        int mid = (end - start)/2 + start;
        if(nums[mid] == target){
            if(mid > 0 && nums[mid - 1] < target){
                return mid;
            }else{
                return searchStart(nums, target, start, mid);
            }
        }else if(nums[mid] < target){
            return searchStart(nums, target, mid, end);
        }else{
            return -1;
        }
    }

    public int searchEnd(int[] nums, int target, int start, int end){
        if(end - start == 1){
            int respEnd = nums[end] == target ? end : start;
            return respEnd;
        }

        int mid = (end - start)/2 + start;
        if(nums[mid] == target){
            if(mid < nums.length - 1 && nums[mid + 1] > target){
                return mid;
            }else{
                return searchEnd(nums, target, mid, end);
            }
        }else if(nums[mid] > target){
            return searchEnd(nums, target, start, mid);
        }else{
            return -1;
        }
    }

    private void print(int[] arr){
        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        FirstLastPosSortedArray obj = new FirstLastPosSortedArray();
        obj.print(obj.searchRange(new int[]{5,7,7,8,8,10}, 8));
        obj.print(obj.searchRange(new int[]{5,7,7,8,8,10}, 6));
        obj.print(obj.searchRange(new int[]{}, 0));
        obj.print(obj.searchRange(new int[]{5}, 5));
        obj.print(obj.searchRange(new int[]{5}, 7));
        obj.print(obj.searchRange(new int[]{1, 3}, 1));
        obj.print(obj.searchRange(new int[]{1, 3}, 3));
    }
}
