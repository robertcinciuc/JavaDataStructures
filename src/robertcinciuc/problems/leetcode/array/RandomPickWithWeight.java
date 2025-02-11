package robertcinciuc.problems.leetcode.array;

import java.util.Random;

public class RandomPickWithWeight {

    class Solution {

        private int[] partialSums;
        private Random random;
        private int sum;

        public Solution(int[] w) {
            random = new Random();
            sum = w[0];
            for(int i = 1; i < w.length; ++i){
                sum += w[i];
                w[i] += w[i-1];
            }
            partialSums = w;
        }

        public int pickIndex() {
            int target = random.nextInt(sum);
            int left = 0;
            int right = partialSums.length - 1;
            while (left <= right){
                int mid = left + (right - left)/2;
                if(partialSums[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }

            return left;
        }
    }

    public static void main(String[] args){

    }
}
