package robertcinciuc.problems.leetcode;


public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while(start < end){
            if(numbers[start] + numbers[end] > target){
                end--;
            }else if(numbers[start] + numbers[end] < target){
                start++;
            }else return new int[]{start + 1, end + 1};
        }
        return null;
    }

    public void print(int[] arr){
        System.out.println(arr[0] + " " + arr[1]);
    }

    public static void main(String[] args){
        TwoSum2 sum = new TwoSum2();
        sum.print(sum.twoSum(new int[]{2,7,11,15}, 9));
        sum.print(sum.twoSum(new int[]{2,3,4}, 6));
        sum.print(sum.twoSum(new int[]{-1, 0}, -1));
    }
}
